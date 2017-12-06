package org.miage.m2.demo.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


@Service
public class SendEmail{

    @Autowired
    Compte compte;

    // Recipient's email ID needs to be mentioned.
    String to = "destinationemail@gmail.com";

    // Sender's email ID needs to be mentioned
    //String from = "fromemail@gmail.com";


        public void send(String mailFrom, String subject, String content){

            // Assuming you are sending email through relay.jangosmtp.net
            String host = "smtp.mailtrap.io";

            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", compte.getHost());
            props.put("mail.smtp.port", "25");

            // Get the Session object.
            Session session = Session.getInstance(props,
                    new Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(compte.getUserName(), compte.getPasseword());
                        }
                    });

            try {
                // Create a default MimeMessage object.
                Message message = new MimeMessage(session);

                // Set From: header field of the header.
                message.setFrom(new InternetAddress(mailFrom));

                // Set To: header field of the header.
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(to));

                // Set Subject: header field
                message.setSubject(subject);

                // Now set the actual message
                message.setText(content);

                // Send message
                Transport.send(message);

                System.out.println("Sent message successfully....");
                System.out.println(subject);

            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }

        }
    }