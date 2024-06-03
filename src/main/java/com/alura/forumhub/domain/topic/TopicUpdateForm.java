package com.alura.forumhub.domain.topic;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class TopicUpdateForm {
	
	@NotNull
	@NotEmpty @Length(min = 5)
	private String title;
	
	@NotNull @NotEmpty @Length(min = 10)
	private String message;

	public void setTitle(String title) {
		this.title = title;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Topic update(Long id, TopicRepository topicRepository) {
		Topic topic = topicRepository.getOne(id);
		
		topic.setTitle(this.title);
		topic.setMessage(this.message);
		
		return topic;
	}
	
}
