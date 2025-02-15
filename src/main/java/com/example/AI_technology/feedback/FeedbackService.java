package com.example.AI_technology.feedback;

import com.example.AI_technology.utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class FeedbackService {

    @Autowired
    FeedbackRepository feedbackRepository;

    public Boolean saveFeedback(Feedback feedback){
        if(Validator.validateEmail(feedback.getEmail())){
            feedbackRepository.save(feedback);
            return true;
        }
        else{
            return false;
        }

    }


}
