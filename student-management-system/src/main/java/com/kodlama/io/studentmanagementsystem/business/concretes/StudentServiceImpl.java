package com.kodlama.io.studentmanagementsystem.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlama.io.studentmanagementsystem.business.abstracts.IStudentService;
import com.kodlama.io.studentmanagementsystem.business.requests.CreateStudentRequest;
import com.kodlama.io.studentmanagementsystem.business.requests.UpdateStudentRequest;
import com.kodlama.io.studentmanagementsystem.business.responses.GetAllStudentResponse;
import com.kodlama.io.studentmanagementsystem.business.rules.IStudentBusinessRules;
import com.kodlama.io.studentmanagementsystem.core.utilities.mappers.ModelMapperService;
import com.kodlama.io.studentmanagementsystem.entities.Student;
import com.kodlama.io.studentmanagementsystem.repository.IStudentRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements IStudentService {
	private IStudentRepository iStudentRepository;
	private ModelMapperService mapperService;
	private IStudentBusinessRules businessRules;

	@Override
	public List<GetAllStudentResponse> getAllStudent() {

		List<Student> listAll = this.iStudentRepository.findAll();

		List<GetAllStudentResponse> reList = listAll.stream()
				.map(student -> this.mapperService.forResponse().map(student, GetAllStudentResponse.class))
				.collect(Collectors.toList());

		return reList;
	}

	@Override
	public void addStudent(CreateStudentRequest createStudentRequest) {
		Student student = this.mapperService.forRequest().map(createStudentRequest, Student.class);
		this.businessRules.checkIfStudentNameExits(createStudentRequest.getName());
		this.businessRules.checkIfStudentEmailExits(createStudentRequest.getEmail());
		this.iStudentRepository.save(student);
		
		

	}

	@Override
	public void updateStudent(UpdateStudentRequest request) {
		Student student = this.mapperService.forRequest().map(request, Student.class);
		this.businessRules.checkIfStudentEmailExits(request.getEmail());
		this.iStudentRepository.save(student);

	}

	@Override
	public void deleteStudent(Long id) {
		this.iStudentRepository.deleteById(id);

	}

	@Override
	public Student getById(Long id) {
		Student student = this.iStudentRepository.getReferenceById(id); //this.iStudentRepository.findById(id).get();
		
		return student;
	}

}
