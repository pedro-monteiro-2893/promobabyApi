package com.promobaby.promoBabyApi.Client.Awin;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.springframework.stereotype.Component;

import com.promobaby.promoBabyApi.Client.AwinApiHttpGet;
import com.promobaby.promoBabyApi.Client.AwinClient;
import com.promobaby.promoBabyApi.Client.AwinHttpPost;
import com.promobaby.promoBabyApi.Configuration.PromoBabyApiAwinProperties;
import com.promobaby.promoBabyApi.Model.ProgramasDetalhes;
import com.promobaby.promoBabyApi.Model.ProgramasFiliados;
import com.promobaby.promoBabyApi.Model.PromocoesResponse;
import com.promobaby.promoBabyApi.Model.Requests.PromocoesRequest;
import com.promobaby.promoBabyApi.Response.ResponseHandler;
import com.google.gson.reflect.TypeToken;

@Component
public class AwinApiClientImpl extends AwinClient<PromoBabyApiAwinProperties> implements AwinApiClient{

	public AwinApiClientImpl(PromoBabyApiAwinProperties config, CloseableHttpClient clientHttp) {
		super(config, clientHttp);
	}

	@Override
	public List<ProgramasFiliados> programasFiliados() throws RuntimeException, IOException {
		
		var httpGet = AwinApiHttpGet.getProgramasFiliados(config);
		
		ResponseHandler<List<ProgramasFiliados>> responseHandler = new ResponseHandler<>(
				new TypeToken<List<ProgramasFiliados>>() {
				}.getType());

		return executarChamada(httpGet, responseHandler);
	}

	@Override
	public ProgramasDetalhes programaDetalhes(Long advertiserId) throws RuntimeException, IOException {
		
		var httpGet = AwinApiHttpGet.getProgramasDetalhes(config,advertiserId );

		ResponseHandler<ProgramasDetalhes> responseHandler = new ResponseHandler<>(
				new TypeToken<ProgramasDetalhes>() {
				}.getType());

		return executarChamada(httpGet, responseHandler);
	}

	@Override
	public PromocoesResponse promocoes(PromocoesRequest request) throws RuntimeException, IOException, URISyntaxException {
		
		
		var httpPost = AwinHttpPost.postPromocoesRequest(config,request );

		ResponseHandler<PromocoesResponse> responseHandler = new ResponseHandler<>(
				new TypeToken<PromocoesResponse>() {
				}.getType());

		return executarChamada(httpPost, responseHandler);
	}

}
