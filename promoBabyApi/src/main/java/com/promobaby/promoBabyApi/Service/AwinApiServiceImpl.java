package com.promobaby.promoBabyApi.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promobaby.promoBabyApi.Model.ProgramasDetalhes;
import com.promobaby.promoBabyApi.Model.ProgramasFiliados;
import com.promobaby.promoBabyApi.Model.PromocoesResponse;
import com.promobaby.promoBabyApi.Model.Requests.PromocoesRequest;
import com.promobaby.promoBabyApi.Repository.AwinApiRepository;

@Service
public class AwinApiServiceImpl implements AwinApiService{
	
	@Autowired
	private AwinApiRepository apiRepository;

	@Override
	public List<ProgramasFiliados> programasFiliados() throws RuntimeException, IOException {
		
		return apiRepository.programasFiliados();
	}

	@Override
	public ProgramasDetalhes programaDetalhes(Long advertiserId) throws RuntimeException, IOException {
		
		return apiRepository.programaDetalhes(advertiserId);
	}

	@Override
	public PromocoesResponse promocoes(PromocoesRequest request) throws RuntimeException, IOException, URISyntaxException {
		
		return apiRepository.promocoes(request);
	}

}
