package com.JT_project.GradingSystem.Controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.JT_project.GradingSystem.Models.*;
import com.JT_project.GradingSystem.Service.ProfessorService;
import com.JT_project.GradingSystem.Service.RolesService;
import com.JT_project.GradingSystem.Service.StudentService;
import com.JT_project.GradingSystem.Service.UserService;
@RestController
@RequestMapping("/api")
public class GradeSystemControl {
	
	@Autowired
	UserService userService;
	
	@Autowired
	RolesService rolesService;
	
	@Autowired
	ProfessorService professorService;
	
	@Autowired 
	StudentService studentService;
	
	
	
	
// endpoint acceseable by only prof
	
	
    @PostMapping("/add_profDetails/{user_id}")
	public Professor add_profDetails(@PathVariable Long user_id,@RequestBody Professor prof)
	{
    	Professor p=prof;
    	User u = userService.getUserById(user_id);
    	p.setUser(u);
        p.setJoined_date(new java.sql.Date(System.currentTimeMillis()));
    	return professorService.add_profDetails(p);
	}
//	@PutMapping("/update_profDetails")
//	public Professor update_profDetails()
//	{
//		
//	}
//	
//	//student related 
//	@DeleteMapping("/delete_student")
//	public Student delete_student()
//	{
//		
//	}
//	
//	@GetMapping("/classroom_students")
//	public List<Student> classroom_students()
//	{
//		
//	}
//	
//	@GetMapping("/course_studets")
//	public List<Student> course_students()
//	{
//		
//	}
//	
//	//Grade related
//	@PostMapping("/add_studentGrade")
//	public Grade add_studentGrade()
//	{
//		
//	}
//	
//	@PutMapping("/update_studentGrade")
//	public Grade update_studentGrade()
//	{
//		
//	}
//	
//	@DeleteMapping("/delete_studentGrade")
//	public Grade delete_studentGrade()
//	{
//		
//	}
//	
//	//analysis by classroom and course 
//	@GetMapping("/analysis_classroom")
//	public Result analysis_classroom()
//	{
//		
//	}
//	
//	@GetMapping("/analysis_course")
//	public Result analysis_course()
//	{
//		
//	}
//	
//
//	//endpoints for student 
//	@GetMapping("/show_grades")
//	public List<Grade> show_grades()
//	{
//		
//	}
//	
//	@GetMapping("/show_courseGrade")
//	public Grade show_courseGrade()
//	{
//		
//	}
//	
	@PostMapping("/add_studentDetails/{user_id}")
	public Student add_studentDetails(@PathVariable Long user_id,@RequestBody Student student)
	{
    	Student s=student;
    	User u = userService.getUserById(user_id);
    	s.setUser(u);
        s.setDate_of_birth(new java.sql.Date(System.currentTimeMillis()));
    	return studentService.add_studentDetails(s);
	}
//	
//	@PutMapping("/update_studentDetails")
//	public Student update_studentDetails()
//	{
//		
//	}
	
	
	//for every user 
	@PostMapping("/add_studentUser")
	public User add_studentUser(@RequestBody User user)
	{
		User u = userService.add_user(user);
		roles userRole = new roles();
		userRole.setUser_id(u);
		userRole.setRole("ROLE_STUDENT");
		rolesService.add_role(userRole);
		return u;
	}
	@PostMapping("/add_professorUser")
	public User add_professorUser(@RequestBody User user)
	{
		User u = userService.add_user(user);
		roles userRole = new roles();
		userRole.setUser_id(u);
		userRole.setRole("ROLE_PROF");
		rolesService.add_role(userRole);
		return u;
	}
	
	
}
