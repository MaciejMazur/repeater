package com.example.repeater;

import java.util.LinkedList;
import java.util.List;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class RepeaterDataSource {

	private RepeaterSQLiteHelper sqliteHelper;
	private SQLiteDatabase database;
	
	public RepeaterDataSource(Context context){
		sqliteHelper = new RepeaterSQLiteHelper(context);
	}
	
	public void open() throws SQLException{
		database = sqliteHelper.getWritableDatabase();
	}
	
	public void close(){
		sqliteHelper.close();
	}
	
	public List<Topic> getTopics(){
		LinkedList<Topic> topics = new LinkedList<Topic>();
		return SampleDataProvider.topics;
	}
	
	public List<Question> getQuestions(Topic topic){
		LinkedList<Question> questions = new LinkedList<Question>();
		return topic.getQuestions();
		//return questions;
	}
	
	public void addTopic(Topic topic){
		//TODO
	}
	
	public void updateTopic(Topic topic){
		//TODO
	}
	
	public void removeTopic(Topic topic){
		//TODO
	}
	
	public void addQuestion(Topic topic, Question question){
		//TODO
	}
	
	public void updateQuestion(Question question){
		//TODO
	}
	
	public void removeQuestion(Question question){
		//TODO
	}
}
