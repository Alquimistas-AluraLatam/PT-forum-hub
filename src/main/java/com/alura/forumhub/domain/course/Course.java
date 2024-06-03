package com.alura.forumhub.domain.course;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "courses")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;

}
