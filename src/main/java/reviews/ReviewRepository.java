package reviews;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {

	Collection<Review> findByCategory(Category category);

	Collection<Review> findByCategoryId(long categoryId);

	Collection<Review> findByTagsContains(Tag hot);

	

	

	

	

}
