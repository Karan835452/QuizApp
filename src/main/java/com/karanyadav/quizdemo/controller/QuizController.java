package com.karanyadav.quizdemo.controller;

import com.karanyadav.quizdemo.Service.QuizService;
import com.karanyadav.quizdemo.model.questiondb;
import com.karanyadav.quizdemo.model.response;
import com.karanyadav.quizdemo.model.wrapperQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
    @PostMapping ("create")
    public ResponseEntity<List<questiondb>> createQuestions(@RequestParam String quizTitle, @RequestParam Integer noOfQuestion, @RequestParam String category){
//        return new ResponseEntity<>("I m here", HttpStatus.OK);
        return quizService.createQuiz(quizTitle,noOfQuestion,category);

    }
    @GetMapping("quizQuestions/{id}")
    public ResponseEntity<List<wrapperQuestions>> showQuiz(@PathVariable Integer id)
    {
        return quizService.showQuizById(id);
    }
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer>Submit(@PathVariable Integer id,@RequestBody List<response> res)
    {
        return quizService.submitQuiz(id,res);
    }

}
