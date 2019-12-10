package com.yash.dao;

import java.util.Optional;

import com.yash.model.Topic;

public interface TopicDao {
	Optional<Topic> findById(Integer topicId);
}
