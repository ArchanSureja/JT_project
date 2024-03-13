package com.JT_project.GradingSystem.Models;
import jakarta.persistence.*;
@Entity
@Table(name="grades")
public class Grade {
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
      private Long grade_id;
	  
	  @Column(name="internal_marks")
      private Double internal_marks;
	  
	  @Column(name="external_marks")
      private Double external_marks;
	  
	  @Column(name="practical_marks")
      private Double practical_marks;
	  
	  @Column(name="grade_letter")
      private String Grade_letter;
	  
	  @Column(name="obtained_credit")
      private Double obtained_credit;
	  
	  @ManyToOne
	  @JoinColumn(name="belong_to_student")
      private Student belong_to_student;
	  @ManyToOne
	  @JoinColumn(name="for_course")
      private Course for_course;
      
      
}
