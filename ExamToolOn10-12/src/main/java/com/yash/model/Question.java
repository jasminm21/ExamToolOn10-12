package com.yash.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="question")
public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "quest_id")
	private Integer questId;
	
	@Column
	private String quest;
	
	@Column
	private String op1,op2,op3,op4;
	
	@Column
	private String ans;
	
	@Column(name = "del_flg")
	private Character delFlg;
	
	//@JsonIgnore
	@ManyToOne(/* cascade=CascadeType.PERSIST, */fetch = FetchType.LAZY)
	@JoinColumn(name="topicId",nullable=false/*,referencedColumnName="topic_id"*/)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Topic topic;
	
	@JsonIgnore
	public Topic getTopic() {
		return topic;
	}

	@JsonIgnore
	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Question() {
	}

	public Question(Integer questId, String quest, String op1, String op2, String op3, String op4, String ans,
			Character delFlg, Topic topic) {
		this.questId = questId;
		this.quest = quest;
		this.op1 = op1;
		this.op2 = op2;
		this.op3 = op3;
		this.op4 = op4;
		this.ans = ans;
		this.delFlg = delFlg;
		this.topic=topic;
	}
	
	
	public Integer getQuestId() {
		return questId;
	}
	public void setQuestId(Integer questId) {
		this.questId = questId;
	}
	public String getQuest() {
		return quest;
	}
	public void setQuest(String quest) {
		this.quest = quest;
	}
	public String getOp1() {
		return op1;
	}
	public void setOp1(String op1) {
		this.op1 = op1;
	}
	public String getOp2() {
		return op2;
	}
	public void setOp2(String op2) {
		this.op2 = op2;
	}
	public String getOp3() {
		return op3;
	}
	public void setOp3(String op3) {
		this.op3 = op3;
	}
	public String getOp4() {
		return op4;
	}
	public void setOp4(String op4) {
		this.op4 = op4;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	public Character getDelFlg() {
		return delFlg;
	}
	public void setDelFlg(Character delFlg) {
		this.delFlg = delFlg;
	}
	
}
