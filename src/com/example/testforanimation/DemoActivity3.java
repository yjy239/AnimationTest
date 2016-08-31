package com.example.testforanimation;

import javax.security.auth.PrivateCredentialPermission;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.IntEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

public class DemoActivity3 extends Activity{

	private ImageView img;
	private Button button;
	private Button changeSize;
	private Button VchangeSize;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demo3);
		img = (ImageView)findViewById(R.id.img3);
		button = (Button)findViewById(R.id.controllbycode);
		//��������Ȼ��ȡ��������ֵ������������Ĵ����з�������ͬ�����ԣ�����Ĵ�����ƾ�Ȼ����ʹ�á�
		AnimatorSet set = (AnimatorSet)AnimatorInflater.loadAnimator(this, R.animator.animtor);
		set.setTarget(button);
		set.start();
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				objectAnimator();
			}
		});
		//�ı�ͼƬ���ڵ�view�Ŀ��
		changeSize = (Button)findViewById(R.id.changeSize);
		changeSize.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ViewWrapper wrapper = new ViewWrapper(img);
				ObjectAnimator.ofInt(wrapper, "width", 500).setDuration(5000).start();
			}
		});
		//�ı䰴ť�ĳ���
		VchangeSize = (Button)findViewById(R.id.changesize1);
		VchangeSize.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				performAnimate(VchangeSize, VchangeSize.getWidth(), 500);
			}
		});
		
	}
	
	private void objectAnimator(){
		AnimatorSet set = new AnimatorSet();
		set.playTogether(
				ObjectAnimator.ofFloat(img, "rotationX", 0.0f,306.0f),
				ObjectAnimator.ofFloat(img, "rotationY", 0.0f,180.0f),
				ObjectAnimator.ofFloat(img, "rotation", 0.0f,-90.0f),
				ObjectAnimator.ofFloat(img, "translationX", 0.0f,90.0f)
				);
		set.setDuration(5000).start();
				
	}
	
	private void performAnimate(final View target,final int start,final int end){
		//valueAnimator������������Χ
		ValueAnimator valueAnimator = ValueAnimator.ofInt(1,100);
		valueAnimator.addUpdateListener(new AnimatorUpdateListener() {
			//���β�ֵ��������
			private IntEvaluator mEvaluator = new IntEvaluator();
			@Override
			public void onAnimationUpdate(ValueAnimator anim) {
				// TODO Auto-generated method stub
				//��ȡ��ʱ�����Ľ�����
				int currentvalue = (Integer)anim.getAnimatedValue();
				Log.e("currentvalue", ""+currentvalue);
				//��ȡ��ʱ������ռ�ܽ������İٷֱ�
				float fraction = anim.getAnimatedFraction();
				//��Ӧ���Եı仯
				target.getLayoutParams().width = mEvaluator.evaluate(fraction, start, end);
				//ˢ�¶���UI
				target.requestLayout();
			}
		});
		valueAnimator.setDuration(5000).start();
	}
	
	
	
	private static class ViewWrapper{
		private View mTarget;
		public ViewWrapper(View target){
			mTarget = target;
		}
		
		public int getWidth(){
			return mTarget.getLayoutParams().width;
		}
		
		public void setWidth(int width){
			mTarget.getLayoutParams().width = width;
			mTarget.requestLayout();
		}
	}
}
