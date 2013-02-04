package com.example.mobileindustrycast;


import android.app.Activity;
import android.os.Bundle;
import org.jivesoftware.smack.Connection;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;



/**
 * Gather the xmpp settings and create an XMPPConnection
 */
public class XMPP_Connect extends Activity  {
   
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		ConnectionConfiguration config = new ConnectionConfiguration("http://velington-pc", 5222,"conference.velington-pc");
		Connection connection = new XMPPConnection(config);
		try
		{connection.connect();}
		catch (XMPPException ex)
		{}//To be developed. Proposing Pop-up window "Cannot connect to the server"
		
		try
		{connection.login("Andrey", "123");}
		catch (XMPPException ex)
		{}//To be developed. Proposing Pop-up window "Cannot accept user login/password"
		
		connection.disconnect();
	}
	
}