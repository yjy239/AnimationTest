package com.example.testforanimation;

import android.R.integer;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MyFloatMenu extends RelativeLayout{
	
	private ImageView menu;
	private ImageView bell;
	private ImageView wallet;
	private ImageView shopping;
	private ImageView wait_use;
	private View bellView;
	private View waitView;
	private View walletView;
	private View shopView;
	private boolean isOpen = false;
	
	public MyFloatMenu(Context context){
		super(context);
		init(context);
	}
	
	public MyFloatMenu(Context context,AttributeSet attr){
		super(context,attr);
		init(context);
	}
	
	public MyFloatMenu(Context context,AttributeSet attr,int defStyle){
		super(context, attr, defStyle);
		init(context);
	}
	
	private void init(final Context context){
		LayoutInflater inflater = LayoutInflater.from(context);
		View view = inflater.inflate(R.layout.menu, this);
		menu = (ImageView)view.findViewById(R.id.plus_menu);
		bellView = inflater.inflate(R.layout.bell, null);
		waitView = inflater.inflate(R.layout.wait, null);
		walletView = inflater.inflate(R.layout.wallet, null);
		shopView = inflater.inflate(R.layout.shopping, null);
		this.addView(bellView);
		this.addView(waitView);
		this.addView(walletView);
		this.addView(shopView);
		bellView.setVisibility(View.GONE);
		waitView.setVisibility(View.GONE);
		walletView.setVisibility(View.GONE);
		shopView.setVisibility(View.GONE);
		menu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setVisible();
				if(isOpen == false){
					perform();
					isOpen = true;
				}else if (isOpen == true) {
					backperform();
					isOpen = false;
				}
				
			}
		});
		
		bellView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(context, testActivity.class);
				context.startActivity(intent);
			}
		});
	}
	
	
	private void setVisible(){
		bellView.setVisibility(View.VISIBLE);
		waitView.setVisibility(View.VISIBLE);
		walletView.setVisibility(View.VISIBLE);
		shopView.setVisibility(View.VISIBLE	);
	}
	
	public void perform(){
		AnimatorSet set = new AnimatorSet();
		set.playTogether(
				ObjectAnimator.ofFloat(menu, "rotation", 45.0f),
				ObjectAnimator.ofFloat(bellView, "translationX", 300f),
				ObjectAnimator.ofFloat(waitView, "rotationZ", 30.0f),
				ObjectAnimator.ofFloat(waitView, "translationY", 150.0f),
				ObjectAnimator.ofFloat(waitView, "translationX", 259.8f),
				ObjectAnimator.ofFloat(walletView, "rotationZ", 60.0f),
				ObjectAnimator.ofFloat(walletView, "translationX", 150.0f),
				ObjectAnimator.ofFloat(walletView, "translationY", 259.8f),
				ObjectAnimator.ofFloat(shopView, "translationY", 300f));
		set.setDuration(500).start();
	}
	
	public void backperform(){
		AnimatorSet set = new AnimatorSet();
		set.playTogether(
				ObjectAnimator.ofFloat(menu, "rotation", 90.0f),
				ObjectAnimator.ofFloat(bellView, "translationX", -300f),
				ObjectAnimator.ofFloat(waitView, "rotationZ", -30.0f),
				ObjectAnimator.ofFloat(waitView, "translationY", -150.0f),
				ObjectAnimator.ofFloat(waitView, "translationX", -259.8f),
				ObjectAnimator.ofFloat(walletView, "rotationZ", -60.0f),
				ObjectAnimator.ofFloat(walletView, "translationX", -150.0f),
				ObjectAnimator.ofFloat(walletView, "translationY", -259.8f),
				ObjectAnimator.ofFloat(shopView, "translationY", -300f));
		set.setDuration(500).start();
	}

	@Override
	protected void onLayout(boolean change, int l, int t, int r, int b) {
		// TODO Auto-generated method stub
		super.onLayout(change, l, t, r, b);
	}

}
