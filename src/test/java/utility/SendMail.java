package utility;

import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public class SendMail {
	
	String ReportPath = "./Reports/report.html";

	String from = "ramtekepravin80@gmail.com";

//send email method
	public static void send(String path) throws NoSuchAlgorithmException {
		System.out.println("File path :"+path);
		String message = "My Report Report";
		String subject = "My Report report";
		//String to = "";
		String from = "ramtekepravin80@gmail.com";

		// Variable for gmail
		String host = "smtp.gmail.com";
		// get the system properties

		Properties properties = System.getProperties();
		System.out.println("PROPERTIES :" + properties);

		
		SSLContext sslContext = SSLContext.getDefault();

		// Get the default SSLSocketFactory from the SSL context
		SSLSocketFactory socketFactory = sslContext.getSocketFactory();

		
		// setting important information to properties object
		// host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		
		properties.put("mail.smtp.ssl.socketFactory", socketFactory);


		// To get the Session object..
		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("ramtekepravin80@gmail.com", "12345");
			}

		});
		session.setDebug(true);
		// compose the message[text,attachement,multi media,images etc]
		MimeMessage messageobjet = new MimeMessage(session);

		try {
			// from email
			messageobjet.setFrom(new InternetAddress("ramtekepravin80@gmail.com"));
			// adding message to recipient to
			messageobjet.addRecipients(Message.RecipientType.TO, InternetAddress.parse("ramtekepraavin80@gmail.com"));// if we want to pass multi
																							// email then
			// used array

			// adding subject
			messageobjet.setSubject(subject);
			// adding text to message
			// messageobjet.setText(message);

			
			//file path
			MimeMultipart mimeMultipart = new MimeMultipart();
			// text
			// file
			MimeBodyPart textMime = new MimeBodyPart();

			MimeBodyPart fileMime = new MimeBodyPart();
			try {
			
				System.out.println("File path :"+path);
				textMime.setText(message);
				File file=new File(path);
				fileMime.attachFile(file);
				mimeMultipart.addBodyPart(textMime);
				mimeMultipart.addBodyPart(fileMime);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("html file is not found"+e.getMessage());
			}
			messageobjet.setContent(mimeMultipart);
			// send the message using transport class
			Transport.send(messageobjet);
			System.out.println("Sent Success...............");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}



}
