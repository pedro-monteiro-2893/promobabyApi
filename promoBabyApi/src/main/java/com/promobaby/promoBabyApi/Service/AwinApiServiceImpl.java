package com.promobaby.promoBabyApi.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promobaby.promoBabyApi.Model.ProgramasFiliados;
import com.promobaby.promoBabyApi.Repository.AwinApiRepository;

@Service
public class AwinApiServiceImpl implements AwinApiService{
	
	@Autowired
	private AwinApiRepository apiRepository;

	@Override
	public List<ProgramasFiliados> programasFiliados() throws RuntimeException, IOException {
		
		return apiRepository.programasFiliados();
	}

}
