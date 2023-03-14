package com.kodlama.io.RentACar.business.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateModelRequest {
	@NotNull
	@NotBlank
	@Size(min = 2 , max = 20)
	private String name;
	@NotNull
	@NotBlank
	private int brandId;

}
