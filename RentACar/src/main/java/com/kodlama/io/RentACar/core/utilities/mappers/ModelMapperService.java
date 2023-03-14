package com.kodlama.io.RentACar.core.utilities.mappers;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {

		ModelMapper forResponse();
		ModelMapper forRequest();
}
