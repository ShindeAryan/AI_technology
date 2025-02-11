package com.example.AI_technology.demo;

import com.example.AI_technology.feedback.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @PostMapping("/submit")
    public RedirectView submit(@RequestParam("name") String name, @RequestParam("phone") Long phone, @RequestParam("email") String email){
        Demo demo = new Demo();

        demo.setName(name);
        demo.setEmail(email);
        demo.setMno(phone);

        demoService.saveDemo(demo);

        return new RedirectView("/Trainning.html");
    }


}
