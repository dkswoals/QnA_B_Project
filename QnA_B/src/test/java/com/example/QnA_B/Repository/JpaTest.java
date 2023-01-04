package com.example.QnA_B.Repository;

import com.example.QnA_B.Service.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class JpaTest {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private AnswerRepository answerRepository;

    @Test
    void testJpa(){
        for(int i=0;i<=300;i++){
            String subject = String.format("테스트 데이터:[%03d]",i);
            String content = "내용없음";
            questionService.create(subject,content);
        }
    }
}
