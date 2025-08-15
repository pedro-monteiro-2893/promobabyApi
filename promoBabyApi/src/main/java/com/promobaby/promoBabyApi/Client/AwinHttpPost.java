package com.promobaby.promoBabyApi.Client;

import java.net.URISyntaxException;

import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.promobaby.promoBabyApi.Configuration.PromoBabyApiAwinProperties;
import com.promobaby.promoBabyApi.Model.Requests.PromocoesRequest;

public class AwinHttpPost {
	
	private AwinHttpPost() {
	}

	public static final ObjectMapper objectMapper = new ObjectMapper();

	public static HttpPost postPromocoesRequest(PromoBabyApiAwinProperties config, PromocoesRequest request) throws JsonProcessingException, URISyntaxException  {
		
		//request.setPagination(new Pagination(config.getPage(), config.getPageSize()));
		
		UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(config.getBaseUrl2())
                .path(config.getAfiliadoId())
                .path(config.getPromocoes())
                .queryParam("accessToken", config.getApiKey());

		return configureHttpPost(builder, config, request);
	}

	public static HttpPost configureHttpPost(UriComponentsBuilder builder, PromoBabyApiAwinProperties config,
			PromocoesRequest request) throws JsonProcessingException, URISyntaxException {

		var httpPost = new HttpPost(builder.toUriString());
		httpPost.setHeader("Content-Type", "application/json");

		var requestJson = objectMapper.writeValueAsString(request);

		httpPost.setEntity(new StringEntity(requestJson, ContentType.APPLICATION_JSON));
	
		return httpPost;
	}

}
