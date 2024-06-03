package com.alura.forumhub.domain.topic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {

	Page<Topic> findByCourseName(String courseName, Pageable pagination);

}
