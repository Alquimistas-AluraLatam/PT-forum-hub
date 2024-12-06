package com.alura.forumhub.domain.topic;

import com.alura.forumhub.domain.answer.AnswerDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record TopicDetailsDTO(Long id,
                              String title,
                              String message,
                              LocalDateTime creationDate,
                              String authorName,
                              TopicStatus status,
                              List<AnswerDTO> answers) {


    public TopicDetailsDTO(Topic topic) {
        this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getCreationDate(), topic.getUser().getName(), topic.getStatus(), topic.getAnswers().stream().map(AnswerDTO::new).collect(Collectors.toList()));

    }

}
