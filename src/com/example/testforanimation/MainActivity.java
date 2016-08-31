package com.example.testforanimation;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity implements OnClickListener{
	
	private ListView listView;
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button)findViewById(R.id.test1);
        button2 = (Button)findViewById(R.id.test2);
        button3 = (Button)findViewById(R.id.test3);
        button4 = (Button)findViewById(R.id.test4);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.test1:
			Intent intent = new Intent(MainActivity.this,DemoActivity1.class);
			startActivity(intent);
			overridePendingTransition(R.anim.openactivity, R.anim.exitactivity);
			break;
			
		case R.id.test2:
			Intent intent1 = new Intent(this,DemoActivity2.class);
			startActivity(intent1);
			break;
			
		case R.id.test3:
			Intent intent2 = new Intent(this,DemoActivity3.class);
			startActivity(intent2);
			break;
			
		case R.id.test4:
			Intent intent3 = new Intent(this,DemoActivity4.class);
			startActivity(intent3);
			break;

		default:
			break;
		}
	}

    
}
