package com.example.AI_technology.career;
import com.example.AI_technology.career.Resume;
import org.springframework.stereotype.Service;

@Service
public class ResumeService {

    ResumeRepository resumeRepository;

    public ResumeService(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    public Resume saveResume(Resume resume){
        return resumeRepository.save(resume);
    }

}
