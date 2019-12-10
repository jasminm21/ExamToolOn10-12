package com.yash.dao;

import java.util.List;

import com.yash.model.Question;

public interface QuestDao {
	List<Question> getAllQuestions();
	
	Question getById(Integer questId);

	Boolean addQuestion(Question question);
	
	Boolean deleteQuestion(Integer questId);
	
	Boolean updateQuestion(Question question);
	
	Integer searchIdByName(String topicName);
}
