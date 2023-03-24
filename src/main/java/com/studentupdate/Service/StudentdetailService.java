package com.studentupdate.Service;
//import java.util.List;

import com.studentupdate.Model.Students;

public interface StudentdetailService {
	Students updateStudent(Students student,String student_email);
//	List<Students> getAllStudents();
	Students getStudentById(String student_email);
	
	
}
