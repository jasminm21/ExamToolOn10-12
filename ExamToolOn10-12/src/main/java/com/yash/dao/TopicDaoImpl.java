package com.yash.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yash.model.Topic;
import com.yash.repository.TopicRepository;

@Repository
public class TopicDaoImpl implements TopicDao{

	@Autowired
	private TopicRepository topicRepository;
	
	@Override
	public Optional<Topic> findById(Integer topicId) {
		
		Optional<Topic> topic=topicRepository.findById(topicId);
		return topic;
	}

}

