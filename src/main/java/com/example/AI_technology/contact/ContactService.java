package com.example.AI_technology.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    public Contact saveContact(Contact contact){
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        //Compile regular expression to get the pattern
        Pattern pattern = Pattern.compile(regex);

        String emailid = contact.getEmail();
        Matcher matcher = pattern.matcher(emailid);

        String mno = (String.valueOf(contact.getMno()));

        if(matcher.matches() && mno.length() == 10){
            return contactRepository.save(contact);
        }
        else{
            return null;
        }
    }
}
