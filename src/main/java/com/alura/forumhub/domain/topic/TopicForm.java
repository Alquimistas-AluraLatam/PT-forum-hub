package com.alura.forumhub.domain.topic;

import com.alura.forumhub.domain.course.Course;
import com.alura.forumhub.domain.course.CourseRepository;
import jakarta.validation.constraints.*;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Setter
public class TopicForm {

	@NotNull
	@NotEmpty @Length(min = 5)
	private String title;
	
	@NotNull @NotEmpty @Length(min = 10)
	private String message;
	
	@NotNull @NotEmpty
	private String courseName;

	public Topic convert(CourseRepository courseRepository) {
		Course course = courseRepository.findByName(courseName);
		return new Topic(title, message, course);
	}

}
