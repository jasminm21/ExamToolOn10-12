package com.yash.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "subject")
public class Topic {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "topic_id")
	private Integer topicId;

	@Column(name = "topic_name")
	private String topicName;

	public Topic() {
	}

	public Topic(Integer topicId, String topicName, List<Question> question) {
		this.topicId = topicId;
		this.topicName = topicName;

	}

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@OneToMany(mappedBy = "topic", fetch = FetchType.LAZY/*, cascade = CascadeType.ALL, targetEntity = Question.class*/)
	private List<Question> questList=new ArrayList<Question>();

	/*
	 * @OneToMany(cascade={CascadeType.ALL})
	 * 
	 * @Fetch(FetchMode.JOIN)
	 * 
	 * @JoinColumn(name="topic_id", referencedColumnName="topic_id") private
	 * List<Question> questList;
	 */

	public Integer getTopicId() {
		return topicId;
	}

	public List<Question> getQuestList() {
		return questList;
	}

	public void setQuestList(List<Question> questList) {
		this.questList = questList;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

}
