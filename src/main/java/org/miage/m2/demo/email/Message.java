package org.miage.m2.demo.email;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import java.util.Date;

public class Message {

    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String sender;
    private String subject;
    private String content;
    private java.util.Date date;

    public Message(String sender, String subject, String content, Date date) {
        this.sender = sender;
        this.subject = subject;
        this.content = content;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
