package com.kodlama.io.RentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlama.io.RentACar.business.abstracts.IBrandService;
import com.kodlama.io.RentACar.business.requests.CreateBrandRequest;
import com.kodlama.io.RentACar.business.requests.GetBrandById;
import com.kodlama.io.RentACar.business.requests.UpdateBrandRequest;
import com.kodlama.io.RentACar.business.responses.GetAllBrandResponse;
import com.kodlama.io.RentACar.business.rules.IBrandBusineesRules;
import com.kodlama.io.RentACar.core.utilities.mappers.ModelMapperService;
import com.kodlama.io.RentACar.core.utilities.results.DataResult;
import com.kodlama.io.RentACar.core.utilities.results.Result;
import com.kodlama.io.RentACar.core.utilities.results.SuccesDataResult;
import com.kodlama.io.RentACar.core.utilities.results.SuccesResult;
import com.kodlama.io.RentACar.dataAccess.concretes.IBrandRepository;
import com.kodlama.io.RentACar.entities.concretes.Brand;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class BrandManager implements IBrandService {
	

	private IBrandRepository brandRepository;
	private ModelMapperService mapperService;
	private IBrandBusineesRules brandBusineesRules;

	@Override
	public DataResult<List<GetAllBrandResponse>> getAll() {
		List<Brand> allList = this.brandRepository.findAll();
		List<GetAllBrandResponse> allBrandResponse = allList.stream()
				.map(brand -> this.mapperService.forResponse().map(brand, GetAllBrandResponse.class))
				.collect(Collectors.toList());

		return new SuccesDataResult<List<GetAllBrandResponse>>(allBrandResponse, "Http 200");
	}

	@Override
	public Result add(CreateBrandRequest brandRequest) {

		this.brandBusineesRules.checkIfBrandNameExists(brandRequest.getName());

		Brand brand = this.mapperService.forRequest().map(brandRequest, Brand.class);
		brand.setName(brandRequest.getName());

		brandRepository.save(brand);

		return new SuccesResult("İşlem Başarılı");

	}

	@Override
	public Result update(UpdateBrandRequest brandRequest) {

		Brand brand = this.mapperService.forRequest().map(brandRequest, Brand.class);

		brandRepository.save(brand);

		return new SuccesResult("İşlem Başarılı");
	}

	@Override
	public Result delete(int id) {
		brandRepository.deleteById(id);
		return new SuccesResult("İşlem Başarılı ");
	}

	@Override
	public DataResult<GetAllBrandResponse> getElementById(GetBrandById elementById) {
		Brand brand = brandRepository.findById(elementById.getId()).orElseThrow();

		GetAllBrandResponse allBrandResponse = this.mapperService.forResponse().map(brand, GetAllBrandResponse.class);

		return new SuccesDataResult<GetAllBrandResponse>(allBrandResponse, "İşlem Başarılı");
	}

}
