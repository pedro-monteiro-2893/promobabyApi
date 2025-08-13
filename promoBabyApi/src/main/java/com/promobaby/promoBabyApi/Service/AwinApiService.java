package com.promobaby.promoBabyApi.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.promobaby.promoBabyApi.Model.ProgramasFiliados;

@Service
public interface AwinApiService {
	
	List<ProgramasFiliados> programasFiliados() throws RuntimeException, IOException;

}
