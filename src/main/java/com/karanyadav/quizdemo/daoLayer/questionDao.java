package com.karanyadav.quizdemo.daoLayer;

import com.karanyadav.quizdemo.model.questiondb;
import jakarta.persistence.Id;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Repository
public interface questionDao extends JpaRepository<questiondb,Integer> {


    List<questiondb> findByCategory(String category);

    @Query(value ="SELECT * FROM questiondb q where q.category=:category ORDER BY RANDOM() LIMIT :noOfQuestion",nativeQuery = true)
    List<questiondb> findRandomQuestionByCategory(String category, Integer noOfQuestion);
}
