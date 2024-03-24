package com.JT_project.GradingSystem.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JT_project.GradingSystem.Models.Student;

public interface StudentRepo extends JpaRepository<Student,Long> {

}
