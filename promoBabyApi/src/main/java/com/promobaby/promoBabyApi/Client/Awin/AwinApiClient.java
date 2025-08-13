package com.promobaby.promoBabyApi.Client.Awin;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.promobaby.promoBabyApi.Model.ProgramasFiliados;

@Component
public interface AwinApiClient {

	List<ProgramasFiliados> programasFiliados() throws RuntimeException, IOException;
}
