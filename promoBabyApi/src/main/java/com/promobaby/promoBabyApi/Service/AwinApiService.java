package com.promobaby.promoBabyApi.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.promobaby.promoBabyApi.Model.ProgramasDetalhes;
import com.promobaby.promoBabyApi.Model.ProgramasFiliados;
import com.promobaby.promoBabyApi.Model.PromocoesResponse;
import com.promobaby.promoBabyApi.Model.Auxiliares.Promocoes;
import com.promobaby.promoBabyApi.Model.Requests.PromocoesRequest;

@Service
public interface AwinApiService {
	
	List<ProgramasFiliados> programasFiliados() throws RuntimeException, IOException;
	
	ProgramasDetalhes programaDetalhes(Long advertiserId) throws RuntimeException, IOException;
	
	PromocoesResponse promocoes(PromocoesRequest request) throws RuntimeException, IOException, URISyntaxException;

}
