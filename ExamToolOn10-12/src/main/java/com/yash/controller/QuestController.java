package com.yash.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yash.model.Question;
import com.yash.service.QuestService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/test")
public class QuestController {
	
	@Autowired 
	private QuestService questService;
	
	@RequestMapping(value="/get-all",method=RequestMethod.GET)
	public List<Question> getAllQuestions(){
		List<Question> list = new ArrayList<Question>();
		
		try {
			list = questService.getAllQuestions();
			if(list.size()<=0 || list==null) {
				System.out.println("empty list");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value="/get-by-id/{questId}",method=RequestMethod.GET)
	public Question getById(@PathVariable("questId") Integer questId){
		Question quest=new Question();
		quest=questService.getById(questId);
		if(quest==null) {
			System.out.println("empty object");
		}
		return quest;
	}
	
	@RequestMapping(value="{topicId}/add-quest",method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Question addQuestion(@PathVariable(value = "topicId") Integer topicId, @RequestBody Question question) {
		try {
			
			questService.addQuestion(topicId,question);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return question;
	}
	

	public Integer searchIdByName(String topicName) {
		return questService.searchIdByName(topicName);
	}
	
	@RequestMapping(value="/update/{questId}",method=RequestMethod.PUT)
	@ResponseBody
	public Boolean updateQuestion(@PathVariable("questId") Integer questId,
			@RequestBody Question question
			/*RedirectAttributes redirectAttributes*/){
		Boolean result=false;
		question.setQuestId(questId);
		result=questService.updateQuestion(question);
		return result;
	}
	
	@RequestMapping(value="/delete/{questId}",method=RequestMethod.DELETE)
	public Boolean deleteQuestion(@PathVariable("questId") Integer questId){
	Boolean result=false;
		
		result=questService.deleteQuestion(questId);
		return result;
	}
}
