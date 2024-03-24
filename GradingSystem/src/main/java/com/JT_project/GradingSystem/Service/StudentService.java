package com.JT_project.GradingSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JT_project.GradingSystem.Models.Student;
import com.JT_project.GradingSystem.Repos.StudentRepo;

@Service
public class StudentService {
       @Autowired 
       StudentRepo studentRepo;
       
       public Student  add_studentDetails(Student s)
       {
    	   return studentRepo.save(s);
       }
}
