package com.yash.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yash.model.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic,Integer>{
	
	//get by id
	 @Query("select t from Topic t where t.topicId= :topicId")
	  public Optional<Topic> findById(@Param("topicId") Integer topicId);
}