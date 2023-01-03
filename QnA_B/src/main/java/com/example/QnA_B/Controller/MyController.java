package com.example.QnA_B.Controller;


import com.example.QnA_B.Domain.Qustion.Question;
import com.example.QnA_B.Repository.QuestionRepository;
import com.example.QnA_B.Service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
@RequiredArgsConstructor
@Controller
public class MyController {

    private final QuestionRepository questionRepository;
    private final QuestionService questionService;
    @GetMapping("/")
    public String test(){
        return "redirect:/question/List";
    }

    @GetMapping("/question/List")
    public String List(Model model){
        List<Question> list = questionService.getList();
        model.addAttribute("questionList",list);
        return "QuestionList";
    }

}
