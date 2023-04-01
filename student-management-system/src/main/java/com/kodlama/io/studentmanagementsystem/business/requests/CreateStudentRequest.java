package com.kodlama.io.studentmanagementsystem.business.requests;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateStudentRequest {
	@NotEmpty(message = "Burası Boş Olamaz ")
	@Size(min = 5 , max = 50)
	
	private String name;
	@Size(min = 2, max = 25)
	private String lastName;
	@NotEmpty(message = "Email Alanı Boş Olamaz")
	@Email
	private String email;

}
