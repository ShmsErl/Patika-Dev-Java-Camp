package com.kodlama.io.RentACar;

import java.util.HashMap;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.kodlama.io.RentACar.core.exceptions.BusinessException;
import com.kodlama.io.RentACar.core.exceptions.ProblemDetails;
import com.kodlama.io.RentACar.core.exceptions.ValidationProblemDetails;

@SpringBootApplication
public class RentACarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handlerBusinessException(BusinessException businessException) {
		ProblemDetails details = new ProblemDetails();
		details.setMessage(businessException.getMessage());
		return details;
	}

	@ExceptionHandler()
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
	public ModelMapper getModelMapper() {

		return new ModelMapper();
	}

}
