package com.kodlama.io.RentACar.webApi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.io.RentACar.business.abstracts.IModelService;
import com.kodlama.io.RentACar.business.requests.CreateModelRequest;
import com.kodlama.io.RentACar.business.requests.UpdateModelRequest;
import com.kodlama.io.RentACar.business.responses.GetAllModelResponse;
import com.kodlama.io.RentACar.core.utilities.results.DataResult;
import com.kodlama.io.RentACar.core.utilities.results.Result;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@RequestMapping("/api/models")
@RestController
@AllArgsConstructor
public class ModelController {

	private IModelService iModelService;

	@GetMapping("/getAll")
	public DataResult<List<GetAllModelResponse>> getAll() {

		return this.iModelService.getAll();

	}

	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Result add(@RequestBody @Valid CreateModelRequest createModelRequest) {

		return this.iModelService.add(createModelRequest);
	}

	@PostMapping("/update")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Result update(UpdateModelRequest updateModelRequest) {

		return this.iModelService.update(updateModelRequest);
	}
	@DeleteMapping("/{id}")
	public Result Delete(@PathVariable int id) {

		return this.iModelService.delete(id);
	}

}
