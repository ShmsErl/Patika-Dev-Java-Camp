package com.kodlama.io.studentmanagementsystem.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllStudentResponse {
	private long id;
	private String name;
	private String lastName;
	private String email;

}
