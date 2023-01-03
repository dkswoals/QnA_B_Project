package com.example.QnA_B.Repository;

import com.example.QnA_B.Domain.Answer.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer,Integer> {
}
