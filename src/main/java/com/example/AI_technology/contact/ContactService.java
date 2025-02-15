package com.example.AI_technology.contact;

import com.example.AI_technology.utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    public boolean saveContact(Contact contact){

        if(Validator.validateEmail(contact.getEmail()) && Validator.validateMobileNumber(contact.getMno())){
            contactRepository.save(contact);
            return true;

        }
        else{
            return false;
        }
    }
}
