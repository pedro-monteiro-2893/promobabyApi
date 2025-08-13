package com.promobaby.promoBabyApi.Repository;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.promobaby.promoBabyApi.Client.Awin.AwinApiClientImpl;
import com.promobaby.promoBabyApi.Model.ProgramasFiliados;

@Repository
public class AwinApiRepositoryImpl implements AwinApiRepository{
	
	@Autowired
	private AwinApiClientImpl awinClient;

	@Override
	public List<ProgramasFiliados> programasFiliados() throws RuntimeException, IOException {
		return awinClient.programasFiliados();
	}

}
