package com.example.AI_technology.demo;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.beancontext.BeanContext;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class DemoService {

    @Autowired
    DemoRepository demoRepository;

    public Demo saveDemo(Demo demo){
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        //Compile regular expression to get the pattern
        Pattern pattern = Pattern.compile(regex);

        String emailid = demo.getEmail();
        Matcher matcher = pattern.matcher(emailid);

        String mno = (String.valueOf(demo.getMno()));

        if(matcher.matches() && mno.length() == 10){
            return demoRepository.save(demo);
        }
        else{
            return null;
        }
    }

}
