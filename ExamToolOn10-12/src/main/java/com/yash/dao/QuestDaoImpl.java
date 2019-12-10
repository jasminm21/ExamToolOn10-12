package com.yash.dao;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yash.model.Question;
import com.yash.model.Topic;
import com.yash.repository.QuestRepository;

@Repository
public class QuestDaoImpl implements QuestDao{

	@Autowired
	private QuestRepository questRepo;
	
	@Autowired
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Question> getAllQuestions() {
		return questRepo.findAllQuestions();
	}

	@Override
	public Question getById(Integer questId) {
		return questRepo.getOne(questId);
	}

	@Override
	@Transactional
	public Boolean addQuestion(Question question) {
		questRepo.save(question);
		return true;
	}

	@Override
	public Boolean deleteQuestion(Integer questId) {
		Boolean result=false;
		Question quest=questRepo.getOne(questId);
		quest.setDelFlg('Y');
		Question q=questRepo.saveAndFlush(quest);
		if(q!=null) {
			result=true;
		}
		return result;
	}

	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean updateQuestion(Question question) {
		try {
			entityManager.merge(question);
			entityManager.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}


	@Override
	public Integer searchIdByName(String topicName) {
		TypedQuery<Topic> topicQuery = entityManager
				.createQuery("SELECT t.topicId FROM Topic t WHERE t.topicName= :topicName", Topic.class);
		topicQuery.setParameter("topicName", topicName);
		return topicQuery.getFirstResult();
	}

}
