package com.mobileindustrycast.controller;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.SASLAuthentication;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.packet.Message;


/**
 * Gather the xmpp settings and create an XMPPConnection
 */
public class XMPP_Connect implements MessageListener {
    //for final server use
//	private static final int PORT_NUMBER = 5222 ;
//	private static final String HOST = "openfire.orchestrate";
//	private static final String SERVICE = "jabber.con";
	
	XMPPConnection connection;

	/**
	 * Prepares a XMPP client and sends a message
	 * @param m
	 */
	public void conectXMPP(String message, String sendTo)
	{
		
		XMPP_Connect xmpp = new XMPP_Connect();
		try{
			xmpp.login("Andrey", "123");	
		}catch (XMPPException ex){
			
		}//To be developed. Proposing Pop-up window "Cannot connect to the server"
		 
		try {
			xmpp.sendMessage(message ,sendTo); // (message, userTosent)
		} catch (XMPPException e) {
			e.printStackTrace();
		}

		 xmpp.disconnect();
	}
	
	 
    public void login(String userName, String password) throws XMPPException {
    	//ConnectionConfiguration config = new ConnectionConfiguration("http://velington-pc", 5222,"conference.velington-pc");
    	//ConnectionConfiguration config = new ConnectionConfiguration(HOST ,PORT_NUMBER, SERVICE);
    	ConnectionConfiguration config = new ConnectionConfiguration("jabber.org", 5222, "jabber.org");
        connection = new XMPPConnection(config);
 
        connection.connect();
        SASLAuthentication.supportSASLMechanism("PLAIN", 0);
        connection.login(userName, password);
    }
 
    public void sendMessage(String message, String to) throws XMPPException {
        Chat chat = connection.getChatManager().createChat(to, this);
        chat.sendMessage(message);
    }
    
    public void processMessage(Chat chat, Message message) {
        if (message.getType() == Message.Type.chat) {
            System.out.println(chat.getParticipant() + " says: " + message.getBody());
            

            
            //change for activity message
            try {
                chat.sendMessage(message.getBody() + " echo");
            } catch (XMPPException ex) {
                
            }
        }
    }

    public void disconnect() {
        connection.disconnect();
    }
	
}