package org.miage.m2.demo.email;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.Message;
import java.util.*;

@Service
public class ReceiveMessage {


        @Autowired
        Compte compte;

        public ArrayList<org.miage.m2.demo.email.Message> check() {

            ArrayList<org.miage.m2.demo.email.Message> listMail = new ArrayList<org.miage.m2.demo.email.Message>();

            try {

                //create properties field
                Properties properties = new Properties();

                properties.put("mail.pop3.host", compte.getHost());
                properties.put("mail.pop3.port", "1100");
                properties.put("mail.pop3.starttls.enable", "true");

                Session emailSession = Session.getInstance(properties);

                //create the POP3 store object and connect with the pop server
                Store store = emailSession.getStore("pop3");

                store.connect(compte.getHost(), compte.getUserName(), compte.getPasseword());

                //create the folder object and open it
                Folder emailFolder = store.getFolder("INBOX");
                emailFolder.open(Folder.READ_ONLY);

                // retrieve the messages from the folder in an array and print it
                Message[] messages = emailFolder.getMessages();


                System.out.println("messages.length---" + messages.length);

                for (int i = 0, n = messages.length; i < n; i++) {
                    Message message = messages[i];
                    System.out.println("---------------------------------");
                    System.out.println("Email Number " + (i + 1));
                    System.out.println("Subject: " + message.getSubject());
                    System.out.println("From: " + message.getFrom()[0]);
                    System.out.println("Text: " + message.getContent().toString());

                    listMail.add(new org.miage.m2.demo.email.Message(message.getFrom()[0].toString(), message.getSubject(), message.getContent().toString(), message.getReceivedDate()));

                }

                //close the store and folder objects
                emailFolder.close(false);
                store.close();

            } catch (NoSuchProviderException e) {
                e.printStackTrace();
            } catch (MessagingException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return listMail;


        }





}
