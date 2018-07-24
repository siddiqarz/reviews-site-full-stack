package reviews;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewController {

	@Resource
	CategoryRepository categoryRepo;

	@Resource
	ReviewRepository reviewRepo;

	@Resource
	TagRepository tagRepo;

	@Resource
	CommentRepository commentRepo;

	@RequestMapping("/review")
	public String findOneReview(@RequestParam(value = "id") long id, Model model) throws ReviewNotFoundException {

		Optional<Review> review = reviewRepo.findById(id);

		if (review.isPresent()) {
			model.addAttribute("review", review.get());
			return "review";
		}

		throw new ReviewNotFoundException();
	}

	@RequestMapping("/show-reviews")
	public String findAllReviews(Model model) {
		model.addAttribute("reviews", reviewRepo.findAll());

		return "reviews";
	}

	@RequestMapping("/category")
	public String findOneCategory(@RequestParam(value = "id") long categoryId, Model model)
			throws CategoryNotFoundException {

		Optional<Category> category = categoryRepo.findById(categoryId);

		if (category.isPresent()) {
			model.addAttribute("category", category.get());
			// model.addAttribute("reviews", reviewRepo.findByCategory(category.get()));
			return "category";
		}
		throw new CategoryNotFoundException();
	}

	@RequestMapping("/show-categories")
	public String findAllCategories(Model model) {
		model.addAttribute("categories", categoryRepo.findAll());

		return "categories";
	}

	@RequestMapping("/tag")
	public String findOneTag(@RequestParam(value = "id") long tagId, Model model) throws TagNotFoundException {
		Optional<Tag> tag = tagRepo.findById(tagId);

		if (tag.isPresent()) {
			model.addAttribute("tag", tag.get());
			// model.addAttribute("reviews", reviewRepo.findByCategory(category.get()));
			return "tag";
		}
		throw new TagNotFoundException();
	}

	@RequestMapping("/tags")
	public String findAllTags(Model model) {
		model.addAttribute("tags", tagRepo.findAll());

		return "tags";
	}

	@PostMapping("/add-tags")
	public String addTag(@RequestParam(value = "name") String name, @RequestParam(value = "id") Long id) {

		Optional<Review> tagReview = reviewRepo.findById(id);

		// Create and save tag
		if (tagReview.isPresent()) {
			Tag newTag = tagRepo.save(new Tag(name));
			Review review = tagReview.get();
			review.addTag(newTag);
			reviewRepo.save(review);
		}
		return "redirect:/review?id=" + id;
	}

	@PostMapping("/delete-tags")
	public String deleteTag(
		@RequestParam(value="name") String name,
		@RequestParam(value="id") Long id) {
		
		
		
		 //get tag to be deleted
			Optional<Tag> toDeleteTag = tagRepo.findById(id);
			
			//get review associated with the tag id
			Optional<Review> tagReview = reviewRepo.findById(id);
			Review review = tagReview.get();
			
			Tag tag =toDeleteTag.get();
			review.deleteTag(tag);
			reviewRepo.save(review);
		

	return"redirect:/review?id="+id;
}
	}

//	@RequestMapping("/add-comment")
//	public String addComment(String comment, Long id) {
//		
//		return "redirect:/review?id=" + id;
//		 
//	}		
