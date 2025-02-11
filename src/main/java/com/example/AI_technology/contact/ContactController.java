package com.example.AI_technology.contact;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/submit")
    public RedirectView submit(@RequestParam("name") String name, @RequestParam("mobile") Long phone, @RequestParam("email") String email, @RequestParam("message") String message){
        Contact contact = new Contact();

        contact.setName(name);
        contact.setEmail(email);
        contact.setMno(phone);
        contact.setMessage(message);

        contactService.saveContact(contact);

        return new RedirectView("/contact.html");
    }
}
