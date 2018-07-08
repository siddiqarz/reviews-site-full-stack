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
	
	@Test
	public void shouldRouteToSingleCategory() throws Exception{
		long arbitraryCategoryId = 1L;
		when(categoryRepo.findById(arbitraryCategoryId)).thenReturn(Optional.of(category));
		mvc.perform(get("/show-category?id=1")).andExpect(view().name(is("category")));
	}
}
