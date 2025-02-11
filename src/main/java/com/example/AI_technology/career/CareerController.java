package com.example.AI_technology.career;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/career")
public class CareerController {

    private JobService jobService;
    private ResumeService resumeService;

    public CareerController(JobService jobService, ResumeService resumeService) {
        this.jobService = jobService;
        this.resumeService = resumeService;
    }

    @PostMapping("/submit")
    public RedirectView submit(@RequestParam("name") String name, @RequestParam("mobile") long mobile,@RequestParam("email") String email, @RequestParam("resume") MultipartFile file, @RequestParam("coverletter") String letter){

        Job job = new Job();
        job.setName(name);
        job.setEmail(email);
        job.setMno(mobile);
        job.setCoverletter(letter);

        Job newJob = jobService.saveJob(job);

        System.out.println(newJob.getId());

        return new RedirectView("/Career.html");
    }

}
