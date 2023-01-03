package com.example.QnA_B.Repository;

import com.example.QnA_B.Domain.Answer.Answer;
import com.example.QnA_B.Domain.Qustion.Question;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class JpaTest {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;


    @Transactional
    @Test
    void TestA(){
       Optional<Question> oq = this.questionRepository.findById(2);
       assertTrue(oq.isPresent());
       Question q = oq.get();

       List<Answer> list = q.getAnswerList();

       assertEquals(3,list.size());

       System.out.println(list.get(0).getContent());

    }
}
