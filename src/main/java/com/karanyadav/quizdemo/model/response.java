package com.karanyadav.quizdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class response {
    @Id
    private Integer id;
    private String answer;
}
