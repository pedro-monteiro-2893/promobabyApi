package com.promobaby.promoBabyApi.Response;

import java.io.IOException;
import java.lang.reflect.Type;

import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import com.google.gson.GsonBuilder;
import com.promobaby.promoBabyApi.Exception.PromoBabyApiException;
import com.promobaby.promoBabyApi.Exception.PromoBabyApiExceptionMessages;

import org.apache.hc.core5.http.io.entity.EntityUtils;

public class ResponseHandler<T> implements HttpClientResponseHandler<T> {
	
	private final Type responseType;
	
	public ResponseHandler(Type responseType) {
		this.responseType = responseType;
	}

	@Override
	public T handleResponse(ClassicHttpResponse response) throws HttpException, IOException {
		
		int statusCode = response.getCode();
		
		if(statusCode == 200 || statusCode == 204) {
			
			if (response.getEntity() != null) {
				
				var gson = new GsonBuilder().create();
				
				return gson.fromJson(EntityUtils.toString(response.getEntity()), responseType);
				
			} else {
				return null;
			}
		}else {
			throw new PromoBabyApiException(statusCode,PromoBabyApiExceptionMessages.ERRO_COMUNICACAO_AWIN, response.toString());
		}

	}

}
