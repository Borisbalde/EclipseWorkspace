package com.example.mobileindustrycast;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void sendMessage(View v)
	{
    	//Here we should have a request sending to XMPP server
    	//EditText chatLog=(EditText) findViewById(R.id.chatLog);
    	//CharSequence newMessage=((EditText) findViewById(R.id.messageTxt)).getText();
    	//response from xmpp server goes to chatLog field
    	//chatLog.setText(chatLog.getText().append("\n").append(newMessage));  	
	} 
   
}
