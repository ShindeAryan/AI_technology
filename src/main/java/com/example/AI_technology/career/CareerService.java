package com.example.AI_technology.career;
import com.example.AI_technology.utils.Validator;
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
                        String coverLetter, MultipartFile resumeFile){

        if(Validator.validateEmail(email) && Validator.validateMobileNumber(mobile)){

            String FileType;
            byte[] data;

            try {
                FileType = resumeFile.getContentType();
                data = resumeFile.getBytes();
            }catch(Exception e){
                return false;
            }
            Job job = new Job();
            job.setName(name);
            job.setEmail(email);
            job.setMno(mobile);
            job.setRole(role);
            job.setCoverletter(coverLetter);
            Job savedJob = jobRepository.save(job);


            Resume resume = new Resume();


            resume.setId(savedJob.getId());
            resume.setFileType(FileType);
            resume.setData(data);

            resumeRepository.save(resume);
            return true;
        }
        else{
            return false;
        }

    }




}
