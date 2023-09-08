package com.karanyadav.quizdemo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

//@Setter
//@Getter
@Data
@Entity
public class quizdb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String quizTitle;
//    private String quizCategory;
//    private Integer noOfQuestion;

    @ManyToMany
    List<questiondb> questions;
}
