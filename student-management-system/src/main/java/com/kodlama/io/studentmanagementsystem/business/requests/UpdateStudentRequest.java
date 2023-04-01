package com.kodlama.io.studentmanagementsystem.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStudentRequest {

	private long id;
	private String name;
	private String lastName;
	private String email;
}
