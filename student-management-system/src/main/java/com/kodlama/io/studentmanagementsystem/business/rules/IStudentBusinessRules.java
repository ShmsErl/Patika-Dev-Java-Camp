package com.kodlama.io.studentmanagementsystem.business.rules;

public interface IStudentBusinessRules {
	
	void checkIfStudentNameExits(String name);
	void checkIfStudentEmailExits(String eMail);

}
