package com.kodlama.io.RentACar.webApi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.io.RentACar.business.abstracts.IBrandService;
import com.kodlama.io.RentACar.business.requests.CreateBrandRequest;
import com.kodlama.io.RentACar.business.requests.GetBrandById;
import com.kodlama.io.RentACar.business.requests.UpdateBrandRequest;
import com.kodlama.io.RentACar.business.responses.GetAllBrandResponse;
import com.kodlama.io.RentACar.core.utilities.results.DataResult;
import com.kodlama.io.RentACar.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RequestMapping("api/brands")
@RestController
@AllArgsConstructor
public class BrandController {
	
	private IBrandService brandService;
	
	
	@GetMapping("/getAll")
	public DataResult<List<GetAllBrandResponse>> getAll() {
		
		return brandService.getAll();
	}
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid   CreateBrandRequest brandRequest) {
		
		 brandService.add(brandRequest);
	}
	@PutMapping("/update")
	public Result update(UpdateBrandRequest brandRequest) {
		
		return brandService.update(brandRequest);
	}
	
	@DeleteMapping("/{id}")
	public Result delete(@PathVariable int id) {
		
		return this.brandService.delete(id);
	}
	@GetMapping("/getById")
	public DataResult<GetAllBrandResponse> getElementById(GetBrandById elementById) {
		
		return brandService.getElementById(elementById);
		
		
	}

}
