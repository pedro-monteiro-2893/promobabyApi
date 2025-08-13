package com.promobaby.promoBabyApi.Client;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.springframework.web.util.UriComponentsBuilder;

import com.promobaby.promoBabyApi.Configuration.PromoBabyApiAwinProperties;

public class AwinApiHttpGet {

	private AwinApiHttpGet() {
		
	};
	
	public static HttpGet getProgramasFiliados(PromoBabyApiAwinProperties config) {

		UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(config.getBaseUrl())
                .path(config.getAfiliadoId())
                .path(config.getProgramasFiliados())
                .queryParam("accessToken", config.getApiKey())
                .queryParam("countryCode", config.getCountryCode())
                .queryParam("relationship", config.getRelationship());

        return configureHttpGet(builder, config);

	}
	
	
	public static HttpGet configureHttpGet(UriComponentsBuilder builder, PromoBabyApiAwinProperties config) {
		
		HttpGet httpGet = new HttpGet(builder.toUriString());
        httpGet.addHeader("accept", "*/*");
        return httpGet;
	}
	
	
}
