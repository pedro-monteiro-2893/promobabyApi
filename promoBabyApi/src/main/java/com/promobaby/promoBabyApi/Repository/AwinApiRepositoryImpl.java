package com.promobaby.promoBabyApi.Repository;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.promobaby.promoBabyApi.Client.Awin.AwinApiClient;
import com.promobaby.promoBabyApi.Client.Awin.AwinApiClientImpl;
import com.promobaby.promoBabyApi.Model.ProgramasDetalhes;
import com.promobaby.promoBabyApi.Model.ProgramasFiliados;
import com.promobaby.promoBabyApi.Model.PromocoesResponse;
import com.promobaby.promoBabyApi.Model.Requests.PromocoesRequest;

@Repository
public class AwinApiRepositoryImpl implements AwinApiRepository{
	
	@Autowired
	private AwinApiClient awinClient;

	@Override
	public List<ProgramasFiliados> programasFiliados() throws RuntimeException, IOException {
		return awinClient.programasFiliados();
	}

	@Override
	public ProgramasDetalhes programaDetalhes(Long advertiserId) throws RuntimeException, IOException {
		return awinClient.programaDetalhes(advertiserId);
	}

	@Override
	public PromocoesResponse promocoes(PromocoesRequest request) throws RuntimeException, IOException, URISyntaxException {
		return awinClient.promocoes(request);
	}

}
