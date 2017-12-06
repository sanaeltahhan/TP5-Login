package org.miage.m2.demo.controller;

import org.miage.m2.demo.email.Message;
import org.miage.m2.demo.email.ReceiveMessage;
import org.miage.m2.demo.email.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@org.springframework.stereotype.Controller
public class Controller {

    //@Value("${new.message:test}")
    //private String message = "Hello World";


   /* @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        return "new";
    }*/
   @Autowired
   ReceiveMessage receiveMessage;

    @GetMapping("/allMail" )
    public String getMails(Map<String, Object> model) {
        model.put("mails",receiveMessage.check());
        return "WEB-INF/allEmails";
    }

    @GetMapping("/sendEmail" )
    public String sendMail() {
        return "WEB-INF/formMail";
    }

    @Autowired
    SendEmail sendEmail;

    @PostMapping("/sendEmail")
    public String sendMail(String name, String email, String subject, String content){
        //System.out.println(name+" "+email+" "+content);
        //System.out.println(subject);
        sendEmail.send(email, subject, content);
        return "redirect:/allMail";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login( @RequestParam(value = "error", required = false) String error,@RequestParam(value = "logout", required = false) String logout) {
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error","Invalid username and password!");
        }
        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("WEB-INF/login");
        return model;
    }


   /* @GetMapping("/")
    public String defaultPage(Model model){
        ArrayList<fr.ul.m2sid.mailspringmvcapp.metier.Message> messages = mailReceiver.receive();
        model.addAttribute("messages", messages);
        return "index";
    }*/

}
