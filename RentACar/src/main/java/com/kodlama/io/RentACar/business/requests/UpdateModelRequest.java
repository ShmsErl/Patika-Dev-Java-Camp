package com.kodlama.io.RentACar.business.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateModelRequest {
	private int id;
	private  String name;
	private int brandId;
}
