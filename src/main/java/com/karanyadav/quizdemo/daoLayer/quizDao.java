package com.karanyadav.quizdemo.daoLayer;

import com.karanyadav.quizdemo.model.quizdb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public interface quizDao extends JpaRepository<quizdb,Integer> {

}
