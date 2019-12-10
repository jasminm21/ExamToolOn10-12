package com.yash.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yash.dao.QuestDao;
import com.yash.dao.TopicDao;
import com.yash.model.Question;
import com.yash.model.Topic;

@Component
public class QuestServiceImpl implements QuestService {

	@Autowired
	private QuestDao questDao;

	@Autowired
	private TopicDao topicDao;

	@Override
	public List<Question> getAllQuestions() {
		List<Question> qlist = null;
		try {
			qlist = questDao.getAllQuestions();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qlist;
	}

	@Override
	public Question getById(Integer questId) {
		Question quest = new Question();
		try {
			quest = questDao.getById(questId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return quest;
	}

	@Override
	public Question addQuestion(Integer topicId, Question question) {
		try {
			// List<Question> questList=new ArrayList<Question>();

			Optional<Topic> topicOp = topicDao.findById(topicId);
			Topic topic = topicOp.get();
			// tie topic to quest
			question.setTopic(topic);
			question.setDelFlg('N');
			questDao.addQuestion(question);

			// tie quest to topic
			/*
			 * questList.add(question); topic.setQuestList(questList);
			 * question.setTopic(topic);
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
		return question;

	}

	@Override
	public Boolean deleteQuestion(Integer questId) {
		Boolean result = false;
		try {
			result = questDao.deleteQuestion(questId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Boolean updateQuestion(Question question) {
		Boolean result = false;
		try {
			result = questDao.updateQuestion(question);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Integer searchIdByName(String topicName) {
		return questDao.searchIdByName(topicName);
	}

}
