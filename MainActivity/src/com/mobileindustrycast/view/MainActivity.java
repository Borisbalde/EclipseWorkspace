package com.mobileindustrycast.view;

import com.example.mobileindustrycast.R;
import com.mobileindustrycast.controller.XMPP_Connect;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends Activity  {

	XMPP_Connect xmppchat = new XMPP_Connect();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
	public void clickListener(View v) {
		switch (v.getId()) {
		//Here we should have a request sending to XMPP server
		case R.id.sendBtn:
			String message = findViewById(R.id.messageTxt).toString();
			String sendTo = "dahernandez.89@gmail.com";
	    	xmppchat.conectXMPP(message,sendTo);
	    	
	    	EditText chatLog = (EditText) findViewById(R.id.chatBox);
	    	
	    	chatLog.setText(chatLog.getText().append("\n").append(message));
			
			break;
		case R.id.broadcastBtn:
			
			break;
		
		}
    		
    	  	
	} 
   
}
