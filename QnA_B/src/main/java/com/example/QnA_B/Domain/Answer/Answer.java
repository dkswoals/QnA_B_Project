package com.example.QnA_B.Domain.Answer;

import com.example.QnA_B.Domain.Qustion.Question;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String content;

    private LocalDateTime createDate;
    @ManyToOne
    private Question question;
}
