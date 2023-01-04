package com.example.QnA_B.Controller;


import com.example.QnA_B.DTO.AnswerForm;
import com.example.QnA_B.DTO.QuestionForm;
import com.example.QnA_B.Domain.Question.Question;
import com.example.QnA_B.Service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionService questionService;
    @GetMapping("/")
    public String test(){
        return "redirect:/question/List";
    }

    @GetMapping("/question/List")
    public String List(Model model,@RequestParam(value = "page",defaultValue = "0") int page){
        Page<Question> paging = this.questionService.getList(page);
        model.addAttribute("paging", paging);
        return "QuestionList";
    }

    @GetMapping(value = "/question/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm){
    Question question = questionService.getQuestion(id);
    model.addAttribute("question",question);
        return "QuestionDetail";
    }

    @GetMapping("/question/create")
    public String Create(QuestionForm questionForm){
        return "question_form";
    }

    @PostMapping("/question/create")
    public String Create(@Valid QuestionForm questionForm, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "question_form";

        questionService.create(questionForm.getSubject(),questionForm.getContent());
        return "redirect:/question/List";
    }
}
