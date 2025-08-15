package com.promobaby.promoBabyApi.Client;

import java.io.IOException;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;

import com.promobaby.promoBabyApi.Configuration.PromoBabyApiAwinProperties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract class AwinClient<T extends PromoBabyApiAwinProperties> {

	
	protected final T config;

	protected final CloseableHttpClient clientHttp;
	
	
	public <E> E executarChamada(HttpGet httpGet, HttpClientResponseHandler<E> responseHandler) throws RuntimeException, IOException {

		try {
			return clientHttp.execute(httpGet, responseHandler);

		} catch (Exception e) {

			throw e;
		} 
		
	}
	
	public <E> E executarChamada(HttpPost httpPost, HttpClientResponseHandler<E> responseHandler)
			throws RuntimeException, IOException {

		try {
			return clientHttp.execute(httpPost, responseHandler);

		} catch (Exception e) {

			throw e;
		} 
	}
}
