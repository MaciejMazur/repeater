package com.example.repeater;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

import com.example.repeater.GetTopics.TopicsLoadedListener;

public class MainActivity extends Activity implements TopicsLoadedListener{

	private RepeaterDataSource datasource;
	
	private ListView listView;
	private TopicArrayAdapter adapter;
	private ArrayList<Topic> l = new ArrayList<Topic>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		listView = (ListView) findViewById(R.id.list);
		

		adapter = new TopicArrayAdapter(this,l);
		
		listView.setAdapter(adapter);
		datasource = new RepeaterDataSource(this);
		datasource.open();
		loadTopics();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onResume() {
		datasource.open();
		super.onResume();
	}
	
	@Override
	protected void onPause() {
		datasource.close();
		super.onPause();
	}

	
	private void loadTopics(){
		new GetTopics(this, datasource).execute();
	}
	
	@Override
	public void topicsLoaded(List<Topic> topics) {

		l.clear();
		l.addAll(topics);
		adapter.notifyDataSetChanged();
	}
}
