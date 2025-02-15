package com.example.AI_technology.demo;

import com.example.AI_technology.utils.Validator;
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

    public boolean saveDemo(Demo demo){


        if(Validator.validateEmail(demo.getEmail()) && Validator.validateMobileNumber(demo.getMno())){
            demoRepository.save(demo);
            return true;
        }
        else{
            return false;
        }
    }

}
