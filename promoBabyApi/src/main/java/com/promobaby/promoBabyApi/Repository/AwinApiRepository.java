package com.promobaby.promoBabyApi.Repository;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.promobaby.promoBabyApi.Model.ProgramasFiliados;

@Repository
public interface AwinApiRepository {
	
	List<ProgramasFiliados> programasFiliados() throws RuntimeException, IOException;

}
