package com.testvagrant.newspapersubscriptions;

public class NegativeInputException extends RuntimeException {
	public String getMessage() {
		return "Please,Enter positive input to proceed...";
	}

}
