package com.promobaby.promoBabyApi.Repository;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.promobaby.promoBabyApi.Model.ProgramasDetalhes;
import com.promobaby.promoBabyApi.Model.ProgramasFiliados;
import com.promobaby.promoBabyApi.Model.PromocoesResponse;
import com.promobaby.promoBabyApi.Model.Requests.PromocoesRequest;

@Repository
public interface AwinApiRepository {
	
	List<ProgramasFiliados> programasFiliados() throws RuntimeException, IOException;
	
	ProgramasDetalhes programaDetalhes(Long advertiserId) throws RuntimeException,IOException;
	
	PromocoesResponse promocoes(PromocoesRequest request) throws RuntimeException,IOException, URISyntaxException;

}
