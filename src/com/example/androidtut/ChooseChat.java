package com.example.androidtut;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ChooseChat extends Activity {
	private Button onetoone;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_chat);
	onetoone = (Button) findViewById(R.id.button1);
		

	
		onetoone.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0){
				  Intent i = new Intent(ChooseChat.this, ChatPageOne.class);
				  startActivity(i); // brings up the second activity

	}
		});
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.choose_chat, menu);
		return true;
	}

}
