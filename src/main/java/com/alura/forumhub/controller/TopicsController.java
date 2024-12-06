package com.alura.forumhub.controller;


import com.alura.forumhub.domain.course.CourseRepository;
import com.alura.forumhub.domain.topic.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/topics")
public class TopicsController {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    @Cacheable(value = "topicList")
    public Page<TopicDTO> list(@RequestParam(required = false) String courseName,
                               @PageableDefault(sort = "creationDate", direction = Direction.DESC, page = 0, size = 10) Pageable pagination) {

        Page<Topic> topics;
        if (courseName == null) {
            topics = topicRepository.findAll(pagination);
            System.out.println(topics.getTotalElements());
        } else {
            topics = topicRepository.findByCourseName(courseName, pagination);
            System.out.println(topics.getTotalElements());
        }
        return TopicDTO.convert(topics);
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = "topicList", allEntries = true)
    public ResponseEntity<TopicDTO> register(@RequestBody @Valid TopicForm form, UriComponentsBuilder uriBuilder) {
        Topic topic = form.convert(courseRepository);
        topicRepository.save(topic);

        URI uri = uriBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicDTO(topic));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicDetailsDTO> detail(@PathVariable Long id) {
        Optional<Topic> topic = topicRepository.findById(id);
        if (topic.isPresent()) {
            return ResponseEntity.ok(new TopicDetailsDTO(topic.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicDTO> update(@PathVariable Long id, @RequestBody @Valid TopicUpdateForm form) {
        Optional<Topic> optional = topicRepository.findById(id);
        if (optional.isPresent()) {
            Topic topic = form.update(id, topicRepository);
            return ResponseEntity.ok(new TopicDTO(topic));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    @CacheEvict(value = "topicList", allEntries = true)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Topic> topic = topicRepository.findById(id);
        if (topic.isPresent()) {
            topicRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}