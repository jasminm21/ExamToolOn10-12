package com.yash.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yash.model.Question;

@Repository
public interface QuestRepository extends JpaRepository<Question,Integer>{
	
	 @Query("select q from Question q where q.delFlg= 'N'")
	  public List<Question> findAllQuestions();

}
