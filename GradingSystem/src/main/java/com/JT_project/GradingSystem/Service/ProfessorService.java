package com.JT_project.GradingSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JT_project.GradingSystem.Models.Professor;
import com.JT_project.GradingSystem.Repos.ProfessorRepo;
@Service
public class ProfessorService {
       @Autowired 
       ProfessorRepo professorRepo;
      public Professor add_profDetails(Professor professor)
      {
    	  return professorRepo.save(professor);
      }
       
}
