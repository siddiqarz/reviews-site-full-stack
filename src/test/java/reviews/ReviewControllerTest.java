package reviews;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

public class ReviewControllerTest {
	// inject
	@InjectMocks
	private ReviewController testReview;
	private ReviewController testCategory;
	
	@Mock
	private ReviewRepository reviewRepo;
	
	@Mock
	private CategoryRepository categoryRepo;
	
	@Mock
	private Category category;
	
	@Mock
	private Category category1;
	
	@Mock
	private Category category2;

	@Mock
	private Review review;
	
	@Mock
	private Review review1;
	
	@Mock
	private Review review2;
	
	@Mock
	private Model model;

	// setup
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldAddAReviewToModel() throws ReviewNotFoundException{
		long arbitraryReviewId = 5L;
		when(reviewRepo.findById(arbitraryReviewId)).thenReturn(Optional.of(review)); // returns value if present
		
		testReview.findOneReview(arbitraryReviewId, model);
		verify(model).addAttribute("reviews", review);
	}
	
//	@Test
//	public void shouldAddAllReviewsToModel() {
//		Collection<Review> allReviews = Arrays.asList(review1, review2);
//		when(reviewRepo.findAll()).thenReturn(allReviews);
//		
//		testReview.findAllReviews(model);
//		verify(model).addAttribute("reviews", allReviews);
//	}
	
	@Test
	public void shouldAddOneCategoryToModel() throws CategoryNotFoundException {
		long arbitraryCategoryId = 4L;
		when(categoryRepo.findById(arbitraryCategoryId)).thenReturn(Optional.of(category));
		
		testCategory.findOneCategory(arbitraryCategoryId, model);
		verify(model).addAttribute("category", category);
	}
	
//	@Test
//	public void shouldAddAllCategoriesToModel()throws CategoryNotFoundException {
//		Collection<Category> allCategories = Arrays.asList(category1, category2);
//		when(categoryRepo.findAll()).thenReturn(allCategories);
//		
//		testCategory.findAllCategories(model);
//		verify(model).addAttribute("categories", allCategories);
//		
//	}
}