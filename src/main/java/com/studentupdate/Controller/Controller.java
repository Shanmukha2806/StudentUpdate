package com.studentupdate.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentupdate.Model.Students;
import com.studentupdate.Service.StudentdetailService;

@CrossOrigin(origins ="http://localhost:3000/" )
@RestController
@RequestMapping("/api")
public class Controller {
	@Autowired
	private StudentdetailService studentdetailService;

	public Controller(StudentdetailService studentdetailService) {
		super();
		this.studentdetailService = studentdetailService;
	}

	//	@GetMapping("/student")
	//	public List<Students> getAllStudents(){
	//		return studentdetailService.getAllStudents();
	//		
	//	}
	@GetMapping("/student/{student_email}") 
	public ResponseEntity<Students> getStudentById(@PathVariable("student_email") String student_email){
		return new ResponseEntity<Students>(studentdetailService.getStudentById(student_email), HttpStatus.OK);
	}


	@PutMapping("/student/{student_email}")
	public ResponseEntity<Students> updateStudent(@PathVariable("student_email") String student_email, @RequestBody Students students){

		return new ResponseEntity<Students>(studentdetailService.updateStudent(students,student_email), HttpStatus.OK);

	}
}
