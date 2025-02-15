package com.example.AI_technology.feedback;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.AI_technology.feedback.Feedback;
import org.springframework.web.servlet.view.RedirectView;
//import java.util.logging.Logger;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/submit")
    public ResponseEntity submit(@RequestParam String name, @RequestParam String email, @RequestParam String feedback, @RequestParam int rating){
        Feedback feedback1 = new Feedback();

        feedback1.setName(name);
        feedback1.setEmail(email);
        feedback1.setMessage(feedback);
        feedback1.setRating(rating);

        if(feedbackService.saveFeedback(feedback1)){
            return new ResponseEntity("success", HttpStatus.OK);
        }
        else{
            return new ResponseEntity("error",HttpStatus.BAD_REQUEST);
        }


    }
}
