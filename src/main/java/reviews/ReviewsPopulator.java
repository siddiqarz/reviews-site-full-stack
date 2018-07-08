package reviews;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ReviewsPopulator implements CommandLineRunner {
	
	@Resource
	private ReviewRepository reviewRepo;
	
	@Resource
	private CategoryRepository categoryRepo;

	@Override
	public void run(String... args) throws Exception {
		Category asia = categoryRepo.save(new Category("Asia"));
		Category northAmerica = categoryRepo.save(new Category("North America"));
		
		Review dubai = reviewRepo.save(new Review("Dubai","burj", "image", asia));
		Review india = reviewRepo.save(new Review("India","chutney", "image", asia));
		Review columbus = reviewRepo.save(new Review("Columbus","amish", "image", northAmerica));
	}

}
