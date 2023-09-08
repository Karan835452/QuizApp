package com.karanyadav.quizdemo.Service;

import com.karanyadav.quizdemo.daoLayer.questionDao;
import com.karanyadav.quizdemo.daoLayer.quizDao;
import com.karanyadav.quizdemo.model.questiondb;
import com.karanyadav.quizdemo.model.quizdb;
import com.karanyadav.quizdemo.model.response;
import com.karanyadav.quizdemo.model.wrapperQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

//    quizdb quizquestiondb;
    @Autowired
    questionDao questionJpa;
    @Autowired
    quizDao quizJpa;

    public ResponseEntity<List<questiondb>> createQuiz(String quizTitle, Integer noOfQuestion, String category) {
        quizdb quizdbobj= new quizdb();

        List<questiondb> quiz_questions=questionJpa.findRandomQuestionByCategory(category,noOfQuestion);

       quizdbobj.setQuizTitle(quizTitle);
       quizdbobj.setQuestions(quiz_questions);
       quizJpa.save(quizdbobj);


       return new ResponseEntity<>(quiz_questions,HttpStatus.OK);

    }

    public ResponseEntity<List<wrapperQuestions>> showQuizById(Integer id) {

        List<questiondb> questions=quizJpa.findById(id).get().getQuestions();
        List<wrapperQuestions>returnQuestions = new ArrayList<>();
        for(questiondb que:questions)
        {
            wrapperQuestions wQ=new wrapperQuestions(que.getId(),que.getCategory(),que.getDifficulty_level(),que.getOption1(),que.getOption2(),que.getOption3(),que.getOption4(),que.getQuestion_title());
            returnQuestions.add(wQ);
        }
//        ResponseEntity<List<wrapperQuestions>> ResponseEntity;
        return new ResponseEntity<>(returnQuestions,HttpStatus.CREATED);

    }

    public ResponseEntity<Integer> submitQuiz(Integer id, List<response>res) {
        int i=0;
        int count=0;
        List<questiondb>questions=quizJpa.findById(id).get().getQuestions();
//        List<questiondb>questions=quiz.getQuestions();
        for(response temp:res)
        {
            if(temp.getAnswer().equals(questions.get(i).getAnswer()))
            {
                count++;
            }
            i++;
        }
        return new ResponseEntity<>(count,HttpStatus.OK);

    }
}
