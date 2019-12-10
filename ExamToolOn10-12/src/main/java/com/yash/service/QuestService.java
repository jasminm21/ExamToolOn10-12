package com.yash.service;

import java.util.List;

import com.yash.model.Question;

public interface QuestService {
	
	List<Question> getAllQuestions();
	
	Question getById(Integer questId);

	Question addQuestion(Integer topicId,Question question);
	
	Boolean deleteQuestion(Integer questId);
	
	Boolean updateQuestion(Question question);
	
	Integer searchIdByName(String topicName);
}
