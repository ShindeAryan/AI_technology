package com.example.AI_technology.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class FeedbackService {

    @Autowired
    FeedbackRepository feedbackRepository;

    public Feedback saveFeedback(Feedback feedback){

        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        //Compile regular expression to get the pattern
        Pattern pattern = Pattern.compile(regex);

        String emailid = feedback.getEmail();
        Matcher matcher = pattern.matcher(emailid);

        if(matcher.matches()){
            return feedbackRepository.save(feedback);
        }
        else{
            return null;
        }

    }


}
