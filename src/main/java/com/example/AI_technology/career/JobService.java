package com.example.AI_technology.career;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class JobService {

    JobRepository jobRepository;

    public JobService(JobRepository jobRepository){
        this.jobRepository = jobRepository;
    }

    public Job saveJob(Job job){

        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        //Compile regular expression to get the pattern
        Pattern pattern = Pattern.compile(regex);

        String emailid = job.getEmail();
        Matcher matcher = pattern.matcher(emailid);

        String mno = (String.valueOf(job.getMno()));

        if(matcher.matches() && mno.length() == 10){
            return jobRepository.save(job);
        }
        else{
            return null;
        }

    }

}
