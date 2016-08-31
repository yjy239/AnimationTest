package com.example.testforanimation;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class DemoActivity1 extends Activity{
	
	private ImageView Img;
	private Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demo1);
		Img = (ImageView)findViewById(R.id.img);
		button = (Button)findViewById(R.id.codecontroll);
		Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim1);
		Img.startAnimation(animation);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.e("click", "here");
				AlphaAnimation alphaAnimation = new AlphaAnimation(1, (float) 0.1);
				alphaAnimation.setDuration(3000);
				Img.startAnimation(alphaAnimation);
			}
		});
	}
}
