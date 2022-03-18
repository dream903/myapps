package javaMailSender;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class sendEmailWithAttachments {
	public static void send () {
	String to ="eldream903@gmail.com";
	final String from="eldream903@gmail.com";
	final String password="ElhemNeon@2018";
	Properties prop=new Properties();
	prop.put("mail.smtp.host" , "smtp.gmail.com");
	prop.put("mail.smtp.port", "465");
	prop.put("mail.smtp.auth","true");
	prop.put("mail.smtp.socketFactory.port", "465");
	prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	Session session=Session.getInstance(prop,new javax.mail.Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(from,password);
		}
	}
	);
	try {
		Message message=new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		message.setSubject("message from Java Simplifying Tech");
		String msg="java mail api";
		MimeBodyPart mimeBodyPart=new MimeBodyPart();
		mimeBodyPart.setContent(msg,"text/html");
		
		Multipart multipart=new MimeMultipart();
		multipart.addBodyPart(mimeBodyPart);
		
		MimeBodyPart attachmentBodyPart=new MimeBodyPart();
		try {
			attachmentBodyPart.attachFile(new File("C://Tools//CODE ENVOI MAIL.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		multipart.addBodyPart(attachmentBodyPart);
		message.setContent(multipart);
		Transport.send(message);
		
		
		
	}
	catch (MessagingException e) {
		e.printStackTrace();
	}
	}
	
}
