package com.kodlama.io.RentACar.business.abstracts;

import java.util.List;

import com.kodlama.io.RentACar.business.requests.CreateModelRequest;
import com.kodlama.io.RentACar.business.requests.GetModelById;
import com.kodlama.io.RentACar.business.requests.UpdateModelRequest;
import com.kodlama.io.RentACar.business.responses.GetAllModelResponse;
import com.kodlama.io.RentACar.core.utilities.results.DataResult;
import com.kodlama.io.RentACar.core.utilities.results.Result;

public interface IModelService {
	
	
DataResult<List<GetAllModelResponse>> getAll();
	
	Result add(CreateModelRequest modelRequest);
	
	Result update(UpdateModelRequest modelRequest);
	
	Result delete(int id);
	
	DataResult<GetAllModelResponse> getElementById(GetModelById  elementById);


}
