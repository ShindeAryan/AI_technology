package com.example.AI_technology.career;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CareerService {

    @Autowired
    ResumeRepository resumeRepository;

    @Autowired
    JobRepository jobRepository;

    @Transactional
    public boolean save(String name, String email, long mobile, String role,
                        String coverLetter, MultipartFile resumeFile) throws IOException {
        // Save Job first
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        //Compile regular expression to get the pattern
        Pattern pattern = Pattern.compile(regex);


        Matcher matcher = pattern.matcher(email);

        String mno = (String.valueOf(mobile));

        if(matcher.matches() && mno.length() == 10){
            Job job = new Job();
            job.setName(name);
            job.setEmail(email);
            job.setMno(mobile);
            job.setRole(role);
            job.setCoverletter(coverLetter);
            Job savedJob = jobRepository.save(job); // This generates the auto-increment ID

            // Save Resume with the same ID as Job
            Resume resume = new Resume();
            resume.setId(savedJob.getId());

            resume.setFileType(resumeFile.getContentType());
            resume.setData(resumeFile.getBytes());
            resumeRepository.save(resume);
            return true;
        }
        else{
            return false;
        }

    }




}
