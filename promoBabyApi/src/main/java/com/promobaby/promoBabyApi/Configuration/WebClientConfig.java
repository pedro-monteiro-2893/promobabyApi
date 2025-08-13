package com.promobaby.promoBabyApi.Configuration;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.promobaby.promoBabyApi.Client.ClientBuilder;

@Configuration
public class WebClientConfig {
	
	@Bean(name = "awinClient")
	
	public CloseableHttpClient httpPfClientFactory(
			@Qualifier("apiAwinHttpClient") PromoBabyApiAwinProperties config) {

		var builder = new ClientBuilder(config);

		return builder.buidHttpClient();
	}

}
