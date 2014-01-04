package com.example.repeater;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TopicArrayAdapter extends ArrayAdapter<Topic> {
	private final Context context;
	private final ArrayList<Topic> values;

	public TopicArrayAdapter(Context context, ArrayList<Topic> values) {
		super(context, R.layout.title_row, values);
		this.context = context;
		this.values = values;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		final Topic topic = values.get(position);
		View rowView = inflater.inflate(R.layout.title_row, parent, false);
		TextView textView = (TextView) rowView.findViewById(R.id.text);
		textView.setText(topic.getName());
		textView = (TextView) rowView.findViewById(R.id.rank);
		textView.setText(String.format("%.2f", topic.getCorrectAnswers()));
		
		double correct = topic.getCorrectAnswers();
		ImageView imageView = (ImageView) rowView.findViewById(R.id.status);
		
		if(correct > 0.80){
			imageView.setImageResource(R.drawable.ic_great);
		} else if(correct > 0.50){
			imageView.setImageResource(R.drawable.ic_ok);
		} else if(correct > 0.30){
			imageView.setImageResource(R.drawable.ic_bad);
		} else {
			imageView.setImageResource(R.drawable.ic_terrible);
		}
		Date date = topic.getLastRepetition();
		textView = (TextView) rowView.findViewById(R.id.date);

		DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(context);
		textView.setText(dateFormat.format(date));
		
		
		
		rowView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(context, "Clicked on " + topic.getName(), Toast.LENGTH_LONG).show();
			}
		});
		return rowView;
	}

}
