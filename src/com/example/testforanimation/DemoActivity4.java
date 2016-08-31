package com.example.testforanimation;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DemoActivity4 extends Activity{
	
	private MyFloatMenu fMenu;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demo4);
		fMenu = new MyFloatMenu(this);
		fMenu = (MyFloatMenu)findViewById(R.id.floatmenu);
	}

}
