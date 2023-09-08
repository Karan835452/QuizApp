package com.karanyadav.quizdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class wrapperQuestions {
    @Id
    private Integer id;
    private String category;
    private String difficulty_level;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String question_title;

    public wrapperQuestions(Integer id,String category,String difficulty_level,String option1,String option2,String option3,String option4,String question_title) {
        this.id = id;
        this.category=category;
        this.difficulty_level=difficulty_level;
        this.option4=option4;
        this.option1=option1;
        this.option2=option2;
        this.option3=option3;
        this.question_title=question_title;
    }
}
