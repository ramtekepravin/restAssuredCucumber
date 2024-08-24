package utility;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;


public class SendEmailUtility {
	
	public static void sendEmailWithAttachment(List<String> recipients, String subject, String body, String attachmentPath)
            throws MessagingException, IOException {

        // Gmail SMTP server configuration
        String host = "smtp.gmail.com";
        String port = "587";
        String username = "ramtekepravin80@gmail.com";
        String password = "12345";

        // Set SMTP properties
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", 587);
        prop.put("mail.smtp.ssl.trust", host);

        // Create a Session with authentication
        Session session = Session.getInstance(prop, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        // Create the email message
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));

        // Add multiple recipients
        for (String recipient : recipients) {
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        }

        message.setSubject(subject);

        // Create the message body part
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText(body);

        // Create the multipart message
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        // Attach the file
        if (attachmentPath != null && !attachmentPath.isEmpty()) {
            MimeBodyPart attachmentBodyPart = new MimeBodyPart();
            attachmentBodyPart.attachFile(attachmentPath);
            multipart.addBodyPart(attachmentBodyPart);
        }

        // Set the content of the message to the multipart message
        message.setContent(multipart);

        // Send the email
        Transport.send(message);
        System.out.println("Email sent successfully!");
    }
    
    public static void sendEmailWithAttachments(List<String> recipients, String subject, String body, List<String> attachmentPaths)
            throws MessagingException, IOException {

        // Gmail SMTP server configuration
        String host = "smtp.gmail.com";
        String port = "587";
        String username = "ramtekepravin80@gmail.com";
        String password = "12345";

        // Set SMTP properties
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", 587);
        prop.put("mail.smtp.ssl.trust", host);

        // Create a Session with authentication
        Session session = Session.getInstance(prop, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        // Create the email message
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));

        // Add multiple recipients
        for (String recipient : recipients) {
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        }

        message.setSubject(subject);

        // Create the message body part
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText(body);

        // Create the multipart message
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        // Attach the files
        if (attachmentPaths != null && !attachmentPaths.isEmpty()) {
            for (String attachmentPath : attachmentPaths) {
                MimeBodyPart attachmentBodyPart = new MimeBodyPart();
                attachmentBodyPart.attachFile(attachmentPath);
                multipart.addBodyPart(attachmentBodyPart);
            }
        }

        // Set the content of the message to the multipart message
        message.setContent(multipart);

        // Send the email
        Transport.send(message);
        System.out.println("Email sent successfully!");
    }



}
