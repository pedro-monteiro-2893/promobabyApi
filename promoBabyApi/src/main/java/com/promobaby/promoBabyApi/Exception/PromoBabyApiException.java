package com.promobaby.promoBabyApi.Exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PromoBabyApiException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int httpStatus;
	private String errorMessage;
	private String externalMessage;
	
	public PromoBabyApiException(int httpStatus, String errorMessage, String externalMessage) {
			
		this.httpStatus = httpStatus;
		this.errorMessage = errorMessage;
		this.externalMessage = externalMessage;
	}

}
