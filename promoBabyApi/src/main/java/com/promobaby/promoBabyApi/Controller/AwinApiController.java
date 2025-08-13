package com.promobaby.promoBabyApi.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.promobaby.promoBabyApi.Model.ProgramasFiliados;
import com.promobaby.promoBabyApi.Service.AwinApiService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Api Awin", description = "Servico que disponibiliza os servicos da api awin" )
@RestController
@RequestMapping("/promobaby-api/awin")
public class AwinApiController {
	
	@Autowired
	private AwinApiService awinService;
	
	@Operation(summary = "Lista programas filiados", description = "O afiliado pode verificar, de forma programática, com quais programas eles atualmente possuem um relacionamento ativo, pendente, suspenso, rejeitado ou não aderido.\r\n"
			+ "Eles também podem consultar a lista completa de programas e filtrá-la por região/país do programa..")
	@GetMapping("/programas-filiados")
	public ResponseEntity<List<ProgramasFiliados>> programasFiliados() throws RuntimeException, IOException {

		List<ProgramasFiliados> response = awinService.programasFiliados();


		if (response == null) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(response);
	}
	

}
