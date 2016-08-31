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
	
	//构造器获取初始角度，变化都角度，获取中心的点的x,y,z坐标
	public Roate3dAnimation(float fromDegress,float toDegress,float centerX,
			float centerY,float depthZ,boolean reverse){
		mFromDegrees = fromDegress;
		mToDegress = toDegress;
		mCenterX = centerX;
		mCenterY = centerY;
		mDepthZ = depthZ;
		mReverse = reverse;
	}
	
	//初始化Camera
	@Override
	public void initialize(int width,int height,int parentWidth,int parentHeight){
		super.initialize(width, height, parentWidth, parentHeight);
		mCamera = new Camera();
	}
	
	@Override
	protected void applyTransformation(float interpolatedTime,Transformation t){
		final float fromDegress = mFromDegrees;
		//角度变化随着时间变化而变化：当前角度=起始角度+（（结束角度-起始角度）*角度/每秒）
		float degress = fromDegress + ((mToDegress - fromDegress) * interpolatedTime);
		
		final float centerX = mCenterX;
		final float centerY = mCenterY;
		final Camera camera = mCamera;
		//获取此时的矩阵
		final Matrix matrix = t.getMatrix();
		//camera保存此时camera状态
		camera.save();
		//mReverse是指是反向旋转还是正向旋转
		if(mReverse){
			camera.translate(0.0f, 0.0f, mDepthZ * interpolatedTime);
		}else {
			camera.translate(0.0f, 0.0f, mDepthZ * (1.0f - interpolatedTime));
		}
		//camera对象额旋转
		camera.rotateY(degress);
		//获取旋转后的矩阵
		camera.getMatrix(matrix);
		camera.restore();
		
		matrix.preTranslate(-centerX, -centerY);
		matrix.postTranslate(centerX, centerY);
		
		
	}
	
	
}
