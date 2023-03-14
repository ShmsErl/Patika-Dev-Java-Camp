package com.kodlama.io.RentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlama.io.RentACar.business.abstracts.IModelService;
import com.kodlama.io.RentACar.business.requests.CreateModelRequest;
import com.kodlama.io.RentACar.business.requests.GetModelById;
import com.kodlama.io.RentACar.business.requests.UpdateModelRequest;
import com.kodlama.io.RentACar.business.responses.GetAllModelResponse;
import com.kodlama.io.RentACar.core.utilities.mappers.ModelMapperService;
import com.kodlama.io.RentACar.core.utilities.results.DataResult;
import com.kodlama.io.RentACar.core.utilities.results.Result;
import com.kodlama.io.RentACar.core.utilities.results.SuccesDataResult;
import com.kodlama.io.RentACar.core.utilities.results.SuccesResult;
import com.kodlama.io.RentACar.dataAccess.concretes.IModelRepository;
import com.kodlama.io.RentACar.entities.concretes.Model;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements IModelService {

	private IModelRepository iModelRepository;
	private ModelMapperService mapperService;

	@Override
	public DataResult<List<GetAllModelResponse>> getAll() {
		List<Model> allList = iModelRepository.findAll();

		List<GetAllModelResponse> allBrandResponse = allList.stream()
				.map(model -> this.mapperService.forResponse().map(model, GetAllModelResponse.class))
				.collect(Collectors.toList());

		return new SuccesDataResult<List<GetAllModelResponse>>(allBrandResponse, "İşlem Başarılı");
	}

	@Override
	public Result add(CreateModelRequest modelRequest) {

		Model model = this.mapperService.forRequest().map(modelRequest, Model.class);
		

		this.iModelRepository.save(model);

		return new SuccesResult("İşlem Başarılı");

	}

	@Override
	public Result update(UpdateModelRequest modelRequest) {

		Model model = this.mapperService.forRequest().map(modelRequest, Model.class);

		this.iModelRepository.save(model);

		return new SuccesResult("işlem Başarılı");
	}

	@Override
	public Result delete(int id) {
		this.iModelRepository.deleteById(id);
		return new SuccesResult("İşlem Başarılı ");
	}

	@Override
	public DataResult<GetAllModelResponse> getElementById(GetModelById elementById) {

		Model model = this.iModelRepository.getReferenceById(elementById.getId());

		GetAllModelResponse allBrandResponse = this.mapperService.forResponse().map(model, GetAllModelResponse.class);

		return new SuccesDataResult<GetAllModelResponse>(allBrandResponse, "İşlem Başarılı");
	}

}
