package com.example.androidtut;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class QRScanner extends Activity  {
	private Button b1;
	private TextView  textContent;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		b1 = (Button) findViewById(R.id.button1);
		textContent = (TextView)findViewById(R.id.scan_content);
		

	
		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0){
			/*	Intent intent = new Intent(MainActivity.this,
						CaptureActivity.class);
				intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
				startActivityForResult(intent, 0);*/
				IntentIntegrator scanIntegrator = new IntentIntegrator(QRScanner.this);
				scanIntegrator.initiateScan();
				
			}
		});

	}
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		 IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
		 
	 
	        if(scanResult != null) {
	            String scanContent = " ";
	 
	            scanContent += scanResult.getContents();
	            textContent.setText(scanContent);
	            Intent i = new Intent(QRScanner.this, ChooseChat.class);
				  startActivity(i); // brings up the second activity

	}
	}}
	/*	if (requestCode == 0) {    IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);

		if (resultCode == 1) {
		// Handle successful scan
		String capturedQrValue = intent.getStringExtra("RESULT");
		
		Toast.makeText(MainActivity.this,
		"Scan Result:" + capturedQrValue, Toast.LENGTH_LONG)
		.show();
//-----------------------------------------------------------------------------------------------------------
		//	String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
		//	t1=(TextView)findViewById(R.id.t1);
			//t1.setText(format);
	//	  Intent i = new Intent(this, MainActivity.class);
//		  i.putExtra("username", "foobar"); 

		

		} else if (resultCode == RESULT_CANCELED) {
		// Handle cancel
		}
		} else {

		}
		}
	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void scanNow(View view) {
		Log.d("test", "button works!"); 
		
		Intent intent = new Intent("com.google.zxing.client.android.SCAN");
		intent.putExtra("com.google.zxing.client.android.SCAN.SCAN_MODE", "QR_CODE_MODE"); 
		startActivityForResult(intent, 0);
		}
	public void onActivityResult(int requestCode, int resultCode, Intent intent){    
		 if(requestCode == 0)     {  
			        if(resultCode == RESULT_OK)         {        
						     String contents = intent.getStringExtra("SCAN_RESULT");  
							 String format = intent.getStringExtra("SCAN_RESULT_FORMAT"); 
							 Log.i("xZing", "contents: "+contents+" format: "+format);   
							            // Handle successful scan      
									   }         else if(resultCode == RESULT_CANCELED)         {      
										           // Handle cancel            
												    Log.i("xZing", "Cancelled");         }     }*/
	



