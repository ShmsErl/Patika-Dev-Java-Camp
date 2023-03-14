package com.kodlama.io.RentACar.core.utilities.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelMapparManager implements ModelMapperService {
	
	private ModelMapper mapper;
	
	
	@Override
	public ModelMapper forResponse() {
		this.mapper.getConfiguration().
		setAmbiguityIgnored(true).
		setMatchingStrategy(MatchingStrategies.LOOSE);
		return this.mapper;
	}

	@Override
	public ModelMapper forRequest() {
		this.mapper.getConfiguration().
		setAmbiguityIgnored(true).
		setMatchingStrategy(MatchingStrategies.STANDARD);
		return this.mapper;
	}

	

}
