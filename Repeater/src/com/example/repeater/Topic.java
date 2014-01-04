package com.example.repeater;

import java.util.Date;
import java.util.LinkedList;

public class Topic {
	private long id;
	private String name;
	private Date lastRepetition;
	private double correctAnswers;
	
	private LinkedList<Question> questions;
	
	public LinkedList<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(LinkedList<Question> questions) {
		this.questions = questions;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getLastRepetition() {
		return lastRepetition;
	}
	public void setLastRepetition(Date lastRepetition) {
		this.lastRepetition = lastRepetition;
	}
	public double getCorrectAnswers() {
		return correctAnswers;
	}
	public void setCorrectAnswers(double correctAnswers) {
		this.correctAnswers = correctAnswers;
	}

}
