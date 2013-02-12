package com.mobileindustrycast.controller;


import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.packet.Message;



/**
 * Gather the xmpp settings and create an XMPPConnection
 */
public class XMPP_Connect implements MessageListener {
    //for final server use
	private static final String HOST = "192.168.1.116";//"http://velington-pc"
	private static final int PORT_NUMBER = 5222 ;
	private static final String SERVICE = "conference.velington-pc";
	private static final String RECIPIENT = "industrycast";
	
	XMPPConnection connection;
	
    
    public void login(String userName, String password) throws XMPPException {
    	
    	System.out.println("XMPP_Connect class' function 'login' started");
    	ConnectionConfiguration config = new ConnectionConfiguration(HOST ,PORT_NUMBER, SERVICE);
    	//config.setSASLAuthenticationEnabled(true);
    	System.out.println("XMPP_Connect class' function 'login' configuration compleate");
    	
        connection = new XMPPConnection(config);

        connection.connect();
        System.out.println("connection to the server established");
 
        connection.login(userName, password);
        System.out.println("XMPP_Connect class' function 'login' ended");
    }
 
    public void sendMessage(String message_body) throws XMPPException {
    	System.out.println("XMPP_Connect class' function 'sendMessage' started");
    	Message newMessage = new Message(RECIPIENT, Message.Type.groupchat);
    	newMessage.setBody(message_body);
    	connection.sendPacket(newMessage);
        System.out.println("XMPP_Connect class' function 'sendMessage' ended");
    }
    
    public void processMessage(Chat chat, Message message) {
        if (message.getType() == Message.Type.groupchat) {
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