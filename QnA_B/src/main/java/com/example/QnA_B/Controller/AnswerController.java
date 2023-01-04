package com.example.QnA_B.Controller;


import com.example.QnA_B.DTO.AnswerForm;
import com.example.QnA_B.Domain.Question.Question;
import com.example.QnA_B.Service.AnswerService;
import com.example.QnA_B.Service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {

    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id")
    Integer id, @Valid AnswerForm answerForm, BindingResult bindingResult){
        Question question = questionService.getQuestion(id);
        if(bindingResult.hasErrors()){
            model.addAttribute("question",question);
            return "QuestionDetail";
        }

        answerService.create(question,answerForm.getContent());
        return String.format("redirect:/question/detail/%s",id);
    }

}
