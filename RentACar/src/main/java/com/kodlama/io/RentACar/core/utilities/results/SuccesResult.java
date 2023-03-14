package com.kodlama.io.RentACar.core.utilities.results;

public class SuccesResult extends Result {
	
	public SuccesResult() {
		super(true);
	}
	
	public SuccesResult(String message) {
		super(true,message);
	}
}
