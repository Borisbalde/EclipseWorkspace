package com.mobileindustrycast.view;

import org.jivesoftware.smack.XMPPException;

import com.example.mobileindustrycast.R;
import com.mobileindustrycast.controller.XMPP_Connect;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends Activity  {


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
    
	public void sendMessage(View v) {
		
		switch (v.getId()) {
		
		case R.id.sendBtn:
			
			//Here we should have a request sending to XMPP server
			System.out.println("Button pressed event occured");
			
						
			new Thread(new Runnable(){
				public void run()
				{
					String message = ((EditText)findViewById(R.id.messageTxt)).getText().toString();
					XMPP_Connect xmpp = new XMPP_Connect();
					System.out.println("Connection successfully established");
					try
					{
						System.out.println(message);
						xmpp.login("andrey", "12345");
					}
					catch (XMPPException ex)
					{
						System.out.println("Unable to log in with credinals provided");
					}//To be developed. Proposing Pop-up window "Cannot connect to the server"
			 
					try 
					{
						xmpp.sendMessage(message); // (message, userTosent)
					} 
					catch (XMPPException e) 
					{
						System.out.println("Sending message failed");
					}

					xmpp.disconnect();
				}
			}).start();
	    	//EditText chatLog = (EditText) findViewById(R.id.chatBox);
	    	
	    	//chatLog.setText(chatLog.getText().append("\n").append(message));
	    	System.out.println("Error I passed the action");
			break;
		case R.id.broadcastBtn:
			
			break;
		
		}
    		
    	  	
	} 
   
}
