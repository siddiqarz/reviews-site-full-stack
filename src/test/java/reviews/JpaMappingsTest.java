package reviews;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class JpaMappingsTest {

	@Resource
	private TestEntityManager entityManager;

	// Repositories
	@Resource
	private CategoryRepository categoryRepo;

	@Resource
	private ReviewRepository reviewRepo;

	@Test
	public void shouldSaveAndLoadCategory() {
		Category category = categoryRepo.save(new Category("category"));
		long categoryId = category.getId();

		entityManager.flush(); // force JPA to hit db when we try to find it
		entityManager.clear();

		Optional<Category> result = categoryRepo.findById(categoryId);
		// findbyid is an optional, so result has to be of type optional, with a
		// parametrized type of 'Category'
		// Returning Optional adds explicitly the possibility that there might not be a
		// category for that given ID.
		result.get();
		assertThat(category.getName(), is("category"));
	}

	@Test
	public void shouldGenerateTopicId() {
		Category category = categoryRepo.save(new Category("category"));
		long categoryId = category.getId();

		entityManager.flush();
		entityManager.clear();

		assertThat(categoryId, is(greaterThan(0L)));
	}

	@Test
	public void shouldSaveAndLoadReview() {
		Category asia = categoryRepo.save(new Category("Asia"));
		Review review = reviewRepo.save(new Review("Title", "content", "image url", asia));
		// OR Review review = new Review("Title..."image url");
		// review = reviewRepo.save(review)

		long reviewId = review.getId();

		entityManager.flush();
		entityManager.clear();

		Optional<Review> result = reviewRepo.findById(reviewId);
		Review resultReview = result.get();
		assertThat(resultReview.getTitle(), is("Title"));
	}

	@Test
	public void shouldEstablishReviewToCategoryRelationship() {
		// To see if category has this review
		Category asia = categoryRepo.save(new Category("Asia"));
		Review bay = reviewRepo.save(new Review("Bay", "content", "image", asia));

		long categoryId = asia.getId();
		long reviewId = bay.getId();

		entityManager.flush(); // flushed out cache and servered connection
		entityManager.clear();

		Optional<Category> categoryOptional = categoryRepo.findById(categoryId);
		Optional<Review> reviewOptional = reviewRepo.findById(reviewId);

		Category resultCategory = categoryOptional.get();
		Review resultReview = reviewOptional.get();

		assertThat(resultReview.getCategory().getName(), is("Asia"));
		assertThat(resultCategory.getReviews(), contains(resultReview));

	}

	@Test
	public void shouldFindReviewsForCategory() {
		Category asia = categoryRepo.save(new Category("Asia"));

		Review bay = reviewRepo.save(new Review("Bay", "content", "image", asia));
		Review key = reviewRepo.save(new Review("Bay3", "content2", "image1", asia));

		entityManager.flush();
		entityManager.clear();

		Collection<Review> reviewsForCategory = reviewRepo.findByCategory(asia);
		assertThat(reviewsForCategory, containsInAnyOrder(bay, key));
	}

	@Test
	public void shouldFindReviewByCategoryId() {
		Category asia = categoryRepo.save(new Category("Asia"));

		Review bay = reviewRepo.save(new Review("Bay", "content", "image", asia));
		Review key = reviewRepo.save(new Review("Bay3", "content2", "image1", asia));

		long categoryId = asia.getId();

		entityManager.flush();
		entityManager.clear();

		Collection<Review> reviewsByCategoryId = reviewRepo.findByCategoryId(categoryId);

		assertThat(reviewsByCategoryId, containsInAnyOrder(bay, key));
	}

}
