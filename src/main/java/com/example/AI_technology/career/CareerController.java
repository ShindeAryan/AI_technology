package com.example.AI_technology.career;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/career")
public class CareerController {

    @Autowired
    private CareerService careerService;


    @PostMapping("/submit")
    public RedirectView submit(@RequestParam("name") String name, @RequestParam("mobile") long mobile,@RequestParam("email") String email, @RequestParam("resume") MultipartFile file, @RequestParam("coverLetter") String letter,@RequestParam("jobTitle") String jobtitle){

        try {
            careerService.save(name, email, mobile, jobtitle, letter, file);
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
        return new RedirectView("/Career.html");
    }

}
