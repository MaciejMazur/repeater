package com.example.repeater;

import java.lang.ref.WeakReference;
import java.util.List;

import android.os.AsyncTask;

public class GetTopics extends AsyncTask<Void, Void, List<Topic>>{

	
	public interface TopicsLoadedListener{
		public void topicsLoaded(List<Topic> topics);
	}
	
	
	private WeakReference<RepeaterDataSource> dataSourceReference;
	
	private WeakReference<TopicsLoadedListener> activityReference;
	
	public GetTopics(TopicsLoadedListener activity, RepeaterDataSource dataSource){
		activityReference = new WeakReference<TopicsLoadedListener>(activity); 
		dataSourceReference = new WeakReference<RepeaterDataSource>(dataSource); 
	}
	
	@Override
	protected List<Topic> doInBackground(Void... params) {
		if(dataSourceReference != null){
			RepeaterDataSource dataSource = dataSourceReference.get();
			if(dataSource != null){
				return dataSource.getTopics();
			}
		}
		return null;
	}

	
	@Override
	protected void onPostExecute(List<Topic> result) {
		if(activityReference!=null){
			TopicsLoadedListener listener = activityReference.get();
			if(listener != null){
				listener.topicsLoaded(result);
			}
		}
	}
}
