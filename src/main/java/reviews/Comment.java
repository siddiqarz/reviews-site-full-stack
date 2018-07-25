package reviews;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment {

	//empty constructor
	public Comment() {
		
	}
	@Id
	@GeneratedValue
	private long id;
	private String comment;
	
	@ManyToOne
	private Review review;
	
	
	public Comment(String comment, Review review) {
		this.comment = comment;
		this.review = review;
}

	public String getComment() {
		return comment;
	}

	public long getId() {
		return id;
	}

	public Review getReview() {
		return review;
	}

	
}
