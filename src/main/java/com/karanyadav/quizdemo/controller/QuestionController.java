package com.karanyadav.quizdemo.controller;

import com.karanyadav.quizdemo.model.questiondb;
import com.karanyadav.quizdemo.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("allquestions")
    public ResponseEntity<List<questiondb>> getAllQuestions(){
        return questionService.getAllQuestions();
    }
    @GetMapping("category/{category}")
    public ResponseEntity<List<questiondb>>getQuestionsByCategory(@PathVariable String category){
        return questionService.getAllquestionsByCategory(category);
    }
    @GetMapping("byId/{num}")
    public ResponseEntity<Optional<questiondb>> getQuestionById(@PathVariable Integer num){
        return questionService.getQuestionByid(num);
    }
    @PostMapping("add")
    public ResponseEntity<String> Postquestion(@RequestBody questiondb que){
        return questionService.uploadThequestion(que);
    }
    @GetMapping("delete/{id}")
    public ResponseEntity<Void>  DeleteQuestionById(@PathVariable Integer id)
    {
        return questionService.deleteById(id);
    }
}
