package com.kodlama.io.RentACar.business.rules;

import org.springframework.stereotype.Service;

import com.kodlama.io.RentACar.core.exceptions.BusinessException;
import com.kodlama.io.RentACar.dataAccess.concretes.IBrandRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BrandBusineesRules implements IBrandBusineesRules {
	private IBrandRepository brandRepository;

	public void checkIfBrandNameExists(String name) {

		if (brandRepository.existsByName(name)) {
			throw new BusinessException("Brand AllReady Exists");// Java exception type
		}
	}

}
