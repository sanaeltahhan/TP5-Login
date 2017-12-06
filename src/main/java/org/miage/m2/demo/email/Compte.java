package org.miage.m2.demo.email;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class Compte {

    private String host;
    private String portSMTP;
    private String portPop;
    private String userName;
    private String passeword;

    @PostConstruct
    public void initialize() {
        System.out.println("called");
        host = "smtp.mailtrap.io";
        userName = "c49b65d83760fb";
        passeword = "82d9e386805c6e";
        portSMTP = "25";
        portPop = "1100";
    }


    public Compte() {
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPortSMTP() {
        return portSMTP;
    }

    public void setPortSMTP(String portSMTP) {
        this.portSMTP = portSMTP;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasseword() {
        return passeword;
    }

    public void setPasseword(String passeword) {
        this.passeword = passeword;
    }

    public String getPortPop() {
        return portPop;
    }

    public void setPortPop(String portPop) {
        this.portPop = portPop;
    }
}
