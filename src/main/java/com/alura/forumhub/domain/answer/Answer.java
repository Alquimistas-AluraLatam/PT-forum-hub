package com.alura.forumhub.domain.answer;

import com.alura.forumhub.domain.topic.Topic;
import com.alura.forumhub.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "answers")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;

    @ManyToOne
    private Topic topic;
    private LocalDateTime creationDate = LocalDateTime.now();
    @ManyToOne
    private User author = new User();
    private Boolean isSolution = false;
}
