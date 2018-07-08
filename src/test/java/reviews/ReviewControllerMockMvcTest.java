package reviews;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@WebMvcTest(ReviewController.class)

public class ReviewControllerMockMvcTest {

	@Resource 
	private MockMvc mvc;
	
	@MockBean
	private CategoryRepository categoryRepo;
	
	@MockBean
	private ReviewRepository reviewRepo;
	
	@Mock
	private Category category;
	
	@Mock
	private Review review;
	
	@Test
	public void shouldRouteToSingleCategory() throws Exception{
		long arbitraryCategoryId = 1L;
		
		when(categoryRepo.findById(arbitraryCategoryId)).thenReturn(Optional.of(category));
		mvc.perform(get("/category?id=1")).andExpect(view().name(is("category")));
	}
	
	@Test
	public void shouldBeOKForCategory() throws Exception {
		long arbitraryReviewId = 1L;
		when(categoryRepo.findById(arbitraryReviewId)).thenReturn(Optional.of(category));
		mvc.perform(get("/category?id=1")).andExpect(status().isOk());
	}
	
	@Test
	public void shouldRouteToSingleReview() throws Exception { 
		long arbritraryReviewId = 3L;
		when(reviewRepo.findById(arbritraryReviewId)).thenReturn(Optional.of(review));
		mvc.perform(get("/review?id=3")).andExpect(view().name(is("review")));
	}
	
	@Test
	public void shouldBeOKForReview() throws Exception {
		long arbitraryReviewId = 3L;
		when(reviewRepo.findById(arbitraryReviewId)).thenReturn(Optional.of(review));
		mvc.perform(get("/review?id=3")).andExpect(status().isOk());
	}
}
