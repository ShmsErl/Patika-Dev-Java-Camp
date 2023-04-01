package com.kodlama.io.studentmanagementsystem.business.abstracts;

import java.util.List;

import com.kodlama.io.studentmanagementsystem.business.requests.CreateStudentRequest;
import com.kodlama.io.studentmanagementsystem.business.requests.UpdateStudentRequest;
import com.kodlama.io.studentmanagementsystem.business.responses.GetAllStudentResponse;
import com.kodlama.io.studentmanagementsystem.entities.Student;

public interface IStudentService {
	
	List<GetAllStudentResponse> getAllStudent();
	
	void addStudent(CreateStudentRequest createStudentRequest);
	void updateStudent(UpdateStudentRequest request);
	void deleteStudent(Long id);
	
	Student getById(Long id);
	
	                                

}
