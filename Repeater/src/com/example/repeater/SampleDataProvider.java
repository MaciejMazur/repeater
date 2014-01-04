package com.example.repeater;

import java.util.Date;
import java.util.LinkedList;

public class SampleDataProvider {

	public static LinkedList<Topic> topics = new LinkedList<Topic>();

	static{
		LinkedList<Question> questions = new LinkedList<Question>();
		Topic topic = new Topic();
		topic.setCorrectAnswers(0);
		topic.setId(1);
		topic.setLastRepetition(new Date());
		topic.setName("Computer Science and Programming");
		topic.setQuestions(questions);
		topics.add(topic);
		
		Question question = new Question();
		question.setAnswer("4");
		question.setId(1);
		question.setQuestion("2^2?");
		question.setSuccessRate(0.1);
		question.setTopic(topic);
		question.setTries(3);
		questions.add(question);
		
		question = new Question();
		question.setAnswer("Hewlett Packard");
		question.setId(2);
		question.setQuestion("Acronym HP stands for?");
		question.setSuccessRate(0.3);
		question.setTopic(topic);
		question.setTries(1);
		questions.add(question);
		
		question = new Question();
		question.setAnswer("No");
		question.setId(4);
		question.setQuestion("Multithread programming == parallel programming");
		question.setSuccessRate(0.5);
		question.setTopic(topic);
		question.setTries(5);
		questions.add(question);
		
		
		topic = new Topic();
		topic.setCorrectAnswers(0.5);
		topic.setId(2);
		topic.setLastRepetition(new Date(System.currentTimeMillis()-10000));
		topic.setName("Law");
		topic.setQuestions(questions);
		topics.add(topic);
		
		topic = new Topic();
		topic.setCorrectAnswers(0.7);
		topic.setId(3);
		topic.setLastRepetition(new Date(System.currentTimeMillis()-70000));
		topic.setName("Politics");
		topic.setQuestions(questions);
		topics.add(topic);
		
		topic = new Topic();
		topic.setCorrectAnswers(0.9);
		topic.setId(4);
		topic.setLastRepetition(new Date(System.currentTimeMillis()-990000));
		topic.setName("History");
		topic.setQuestions(questions);
		topics.add(topic);
	}
	
}
