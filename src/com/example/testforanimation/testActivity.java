package com.example.testforanimation;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class testActivity extends Activity{
	
	private TextView text;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test);
		text = (TextView)findViewById(R.id.hello);
	}
}
