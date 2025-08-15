package com.promobaby.promoBabyApi.Response;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.OffsetDateTime;

import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;

import com.fasterxml.jackson.datatype.jsr310.deser.key.OffsetDateTimeKeyDeserializer;
import com.google.gson.GsonBuilder;
import com.promobaby.promoBabyApi.Exception.PromoBabyApiException;
import com.promobaby.promoBabyApi.Exception.PromoBabyApiExceptionMessages;
import com.promobaby.promoBabyApi.Model.Auxiliares.OffsetDateTimeTypeAdapter;

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
				
				var adapter = new OffsetDateTimeTypeAdapter();
				
				var gson = new GsonBuilder()
                        .registerTypeAdapter(OffsetDateTime.class, adapter)
                        .create();
                
                String responseBody = EntityUtils.toString(response.getEntity());
                
                return gson.fromJson(responseBody, responseType);
				
				
			} else {
				return null;
			}
		}else {
			throw new PromoBabyApiException(statusCode,PromoBabyApiExceptionMessages.ERRO_COMUNICACAO_AWIN, response.toString());
		}

	}

}
