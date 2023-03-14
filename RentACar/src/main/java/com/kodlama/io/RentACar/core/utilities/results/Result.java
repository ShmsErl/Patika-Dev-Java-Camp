package com.kodlama.io.RentACar.core.utilities.results;

public abstract class Result {
	private boolean result;
	private String message;

	public Result(boolean result, String message) {

		this.result = result;
		this.message = message;
	}

	public Result(boolean result) {

		this.result = result;

	}

	public boolean isResult() {
		return result;
	}

	public String getMessage() {
		return message;
	}

}
