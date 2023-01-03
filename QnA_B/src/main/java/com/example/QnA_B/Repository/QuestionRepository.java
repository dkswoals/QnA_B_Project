package com.example.QnA_B.Repository;

import com.example.QnA_B.Domain.Qustion.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Integer> {
   Question findBySubject(String subject);
   List<Question> findBySubjectLike(String subject);
}
