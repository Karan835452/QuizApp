package com.karanyadav.quizdemo.Service;

import com.karanyadav.quizdemo.model.questiondb;
import com.karanyadav.quizdemo.daoLayer.questionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired

    public questionDao repo;
    public ResponseEntity<List<questiondb>> getAllQuestions(){
       try{
           return new ResponseEntity<>(repo.findAll(),HttpStatus.OK);
       }
       catch(Exception e){
           e.getStackTrace();
       };
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.OK);
    }


    public ResponseEntity<List<questiondb>> getAllquestionsByCategory(String category) {
        try{
            return new ResponseEntity<>(repo.findByCategory(category),HttpStatus.OK);
        }
        catch(Exception e){
            e.getStackTrace();
        };
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.OK);
    }


    public ResponseEntity<Optional<questiondb>> getQuestionByid(Integer num) {
        try{
            return new ResponseEntity<>(repo.findById(num),HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getStackTrace();
        }
        return new ResponseEntity<>(repo.findById(num),HttpStatus.OK);
    }

    public ResponseEntity<String>uploadThequestion(questiondb que) {
        try{
            repo.save(que);
            return new ResponseEntity<>("succes", HttpStatus.ACCEPTED);
        }
        catch(Exception e){
            e.getStackTrace();

        }
        return new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Void> deleteById(Integer id) {
        try{
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        catch(Exception e) {
            e.getStackTrace();
        }
        return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }


//    public void deleteById(Integer id) {
//    }
}
