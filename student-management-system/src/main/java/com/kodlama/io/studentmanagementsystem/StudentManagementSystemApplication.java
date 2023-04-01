package com.kodlama.io.studentmanagementsystem;

import java.util.HashMap;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import com.kodlama.io.studentmanagementsystem.core.utilities.exception.BusinessException;
import com.kodlama.io.studentmanagementsystem.core.utilities.exception.ProblemDetails;
import com.kodlama.io.studentmanagementsystem.core.utilities.exception.ValidationProblemDetails;

@SpringBootApplication
@RestControllerAdvice
public class StudentManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}
	
	
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handlerBusinessException(BusinessException businessException) {
		ProblemDetails details = new ProblemDetails();
		details.setMessage(businessException.getMessage());
		
		return details;
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handlerValidationException(MethodArgumentNotValidException validationException) {
		ValidationProblemDetails details = new ValidationProblemDetails();
		details.setMessage("Validation Exception");
		details.setValidationErrors(new HashMap<String, String>());

		for (FieldError field : validationException.getBindingResult().getFieldErrors()) {
			details.getValidationErrors().put(field.getField(), field.getDefaultMessage());

		}

		return details;
	}

	
	@Bean
	public ModelMapper modelMapper() {
		
		return new ModelMapper();
	}

}
