package com.example.testforanimation;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class DemoActivity2 extends Activity{
	private ImageView img;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demo2);
		img = (ImageView)findViewById(R.id.img1);
		Roate3dAnimation dAnimation = new Roate3dAnimation(0, 180, 50, 50, 1, true);
		dAnimation.setDuration(3000);
		img.startAnimation(dAnimation);
	}

}
