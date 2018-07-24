package reviews;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private long id;

	private String title;
	private String content;
	private String imageUrl;

	@ManyToOne
	private Category category; // Review will track based on categoryID since it is in the review table
	
	@ManyToMany
	private Collection <Tag> tags;
	
	@ManyToMany
	private Collection <Comment> comments;
	
	protected Review() { // ?
	}

	public Review(String title, String content, String imageUrl, Category category, Tag...tags) {
		this.title = title;
		this.content = content;
		this.imageUrl = imageUrl;
		this.category = category;
		this.tags = new HashSet<>(Arrays.asList(tags));
	}

	public void addTag(Tag newTag) {
		tags.add(newTag);
		
	}
public void deleteTag(Tag toDeleteTag) {
		tags.remove(toDeleteTag);
	}

	//getters
	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public Category getCategory() {

		return category;
	}
	public Collection<Tag> getTags() {
		return tags;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		if (id != other.id)
			return false;
		return true;
	}

	


	

}
