package com.kodlama.io.studentmanagementsystem.business.rules;

import org.springframework.stereotype.Service;

import com.kodlama.io.studentmanagementsystem.core.utilities.exception.BusinessException;
import com.kodlama.io.studentmanagementsystem.repository.IStudentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentBusinessRulesImpl implements IStudentBusinessRules {
	
	private IStudentRepository iStudentRepository;
	
	@Override
	public void checkIfStudentNameExits(String name) {
		
		if( this.iStudentRepository.existsByName(name)) {
			throw new BusinessException("Girilen İsim Mevcut");
		}
		
	}

	@Override
	public void checkIfStudentEmailExits(String eMail) {
		if( this.iStudentRepository.existsByEmail(eMail)) {
			throw new BusinessException("Girilen E-posta Mevcut");
		}
		
	}

}
