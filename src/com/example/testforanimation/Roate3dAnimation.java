package com.example.testforanimation;

import android.R.integer;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class Roate3dAnimation extends Animation{

	private final float mFromDegrees;
	private final float mToDegress;
	private final float mCenterX;
	private final float mCenterY;
	private final float mDepthZ;
	private final boolean mReverse;
	private Camera mCamera;
	
	//��������ȡ��ʼ�Ƕȣ��仯���Ƕȣ���ȡ���ĵĵ��x,y,z����
	public Roate3dAnimation(float fromDegress,float toDegress,float centerX,
			float centerY,float depthZ,boolean reverse){
		mFromDegrees = fromDegress;
		mToDegress = toDegress;
		mCenterX = centerX;
		mCenterY = centerY;
		mDepthZ = depthZ;
		mReverse = reverse;
	}
	
	//��ʼ��Camera
	@Override
	public void initialize(int width,int height,int parentWidth,int parentHeight){
		super.initialize(width, height, parentWidth, parentHeight);
		mCamera = new Camera();
	}
	
	@Override
	protected void applyTransformation(float interpolatedTime,Transformation t){
		final float fromDegress = mFromDegrees;
		//�Ƕȱ仯����ʱ��仯���仯����ǰ�Ƕ�=��ʼ�Ƕ�+���������Ƕ�-��ʼ�Ƕȣ�*�Ƕ�/ÿ�룩
		float degress = fromDegress + ((mToDegress - fromDegress) * interpolatedTime);
		
		final float centerX = mCenterX;
		final float centerY = mCenterY;
		final Camera camera = mCamera;
		//��ȡ��ʱ�ľ���
		final Matrix matrix = t.getMatrix();
		//camera�����ʱcamera״̬
		camera.save();
		//mReverse��ָ�Ƿ�����ת����������ת
		if(mReverse){
			camera.translate(0.0f, 0.0f, mDepthZ * interpolatedTime);
		}else {
			camera.translate(0.0f, 0.0f, mDepthZ * (1.0f - interpolatedTime));
		}
		//camera�������ת
		camera.rotateY(degress);
		//��ȡ��ת��ľ���
		camera.getMatrix(matrix);
		camera.restore();
		
		matrix.preTranslate(-centerX, -centerY);
		matrix.postTranslate(centerX, centerY);
		
		
	}
	
	
}
