package com.kodlama.io.RentACar.business.abstracts;

import java.util.List;

import com.kodlama.io.RentACar.business.requests.CreateBrandRequest;
import com.kodlama.io.RentACar.business.requests.GetBrandById;
import com.kodlama.io.RentACar.business.requests.UpdateBrandRequest;
import com.kodlama.io.RentACar.business.responses.GetAllBrandResponse;
import com.kodlama.io.RentACar.core.utilities.results.DataResult;
import com.kodlama.io.RentACar.core.utilities.results.Result;

public interface IBrandService {
	
	DataResult<List<GetAllBrandResponse>> getAll();
	
	Result add(CreateBrandRequest brandRequest);
	
	Result update(UpdateBrandRequest brandRequest);
	
	Result delete(int id);
	
	DataResult<GetAllBrandResponse> getElementById(GetBrandById  elementById);

}
