package com.promobaby.promoBabyApi.Client;

import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.core5.util.Timeout;

import com.promobaby.promoBabyApi.Configuration.PromoBabyApiAwinProperties;

public class ClientBuilder {
	
	private PromoBabyApiAwinProperties config;
	
	public ClientBuilder(PromoBabyApiAwinProperties config) {
		this.config = config;
	}

	public PoolingHttpClientConnectionManager connectionConfig() {

		var connectionManager = new PoolingHttpClientConnectionManager();
		connectionManager.setMaxTotal(config.getMaxConnections());
		connectionManager.setDefaultMaxPerRoute(config.getMaxConnections());//TODO Alterar Futuramente

		return connectionManager;
	}

	public RequestConfig requestConfig() {

		return RequestConfig.custom()
				.setConnectionRequestTimeout(Timeout.ofMilliseconds(config.getConnectionTimeOut()))
				.build();

	}

	public CustomRetryStrategy retryStrategyConfig() {

		return new CustomRetryStrategy(config.getRetryCount(), config.getRetryInterval());

	}


	public  CloseableHttpClient buidHttpClient() {
		
		var connectionManager = connectionConfig();
		var retryStrategy = retryStrategyConfig();
		var requestConfig = requestConfig();
		
		return HttpClientBuilder.create()
		        .setConnectionManager(connectionManager)
		        .setRetryStrategy(retryStrategy)
		        .setDefaultRequestConfig(requestConfig)  
		        .build();

	}

}
