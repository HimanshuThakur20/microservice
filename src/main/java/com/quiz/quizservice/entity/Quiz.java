package com.quiz.quizservice.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Table("quiz")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@ToString
public class Quiz {
    @Id
    @Column("quiz_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;

}
