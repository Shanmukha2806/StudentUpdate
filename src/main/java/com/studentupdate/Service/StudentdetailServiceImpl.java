package com.studentupdate.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.studentupdate.ExceptionHandler.ResourceNotFoundException;
import com.studentupdate.Model.Students;
import com.studentupdate.Repository.StudentDetailsRepository;


@Service
public class StudentdetailServiceImpl implements StudentdetailService{

	private StudentDetailsRepository studentDetailsRepository;

	public StudentdetailServiceImpl(StudentDetailsRepository studentDetailsRepository) {
		super();
		this.studentDetailsRepository = studentDetailsRepository;
	}
	//	@Override
	//	public List<Students> getAllStudents() {
	//		return studentDetailsRepository.findAll();
	//	}
	@Override
	public Students  getStudentById(String student_email) {
		Optional<Students> student = studentDetailsRepository.findById(student_email);
		if(student.isPresent()) {
			return student.get();
		}else {
			throw new ResourceNotFoundException("Student", "Id", student_email);
		}
	}

	@Override
	public Students updateStudent(Students student, String student_email) {
		Students existingStudent = studentDetailsRepository.findById(student_email).orElseThrow(
				() -> new ResourceNotFoundException("Student", "Id", student_email));;

				existingStudent.setStudent_firstname(student.getStudent_firstname());
				existingStudent.setStudent_lastname(student.getStudent_lastname());
				existingStudent.setDob(student.getDob());
				existingStudent.setGender(student.getGender());
				existingStudent.setStudent_class(student.getStudent_class());
				existingStudent.setFathername(student.getFathername());
				existingStudent.setMothername(student.getMothername());
				existingStudent.setTeacher_email(student.getTeacher_email());
				existingStudent.setFees(student.getFees());
				studentDetailsRepository.save(existingStudent);
				return existingStudent;
	}

}
