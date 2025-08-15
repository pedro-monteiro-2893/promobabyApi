package com.promobaby.promoBabyApi.Controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.promobaby.promoBabyApi.Configuration.PromoBabyApiAwinProperties;
import com.promobaby.promoBabyApi.Model.ProgramasDetalhes;
import com.promobaby.promoBabyApi.Model.ProgramasFiliados;
import com.promobaby.promoBabyApi.Model.PromocoesResponse;
import com.promobaby.promoBabyApi.Model.Auxiliares.Promocoes;
import com.promobaby.promoBabyApi.Model.Requests.PromocoesRequest;
import com.promobaby.promoBabyApi.Model.Requests.PromocoesRequest.Filters;
import com.promobaby.promoBabyApi.Model.Requests.PromocoesRequest.Pagination;
import com.promobaby.promoBabyApi.Service.AwinApiService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Api Awin", description = "Servico que disponibiliza os servicos da api awin" )
@RestController
@RequestMapping("/promobaby-api/awin")
public class AwinApiController {
	
	@Autowired
	PromoBabyApiAwinProperties config;
	
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
	
	
	@Operation(
		    summary = "Detalhes de um programa filiado",
		    description = "Os publishers recebem um conjunto de KPIs dos programas com os quais estão trabalhando, junto com a descrição do programa e a faixa de comissão (abrangendo os grupos de comissão) que eles recebem nesses programas."
		)
		@GetMapping("/programas-detalhes/{advertiserId}")
		public ResponseEntity<ProgramasDetalhes> programaDetalhes(
		        @PathVariable Long advertiserId) throws RuntimeException, IOException {

		    ProgramasDetalhes response = awinService.programaDetalhes(advertiserId);

		    if (response == null) {
		        return ResponseEntity.noContent().build();
		    }

		    return ResponseEntity.ok(response);
		}
	
	
	@Operation(
		    summary = "Retorna Promocoes e cupons para lojas filiadas",
		    description = "A Offers API permite que os publishers recuperem detalhes de promoções e códigos de voucher oferecidos por anunciantes que fazem parte da rede Awin. Os publishers podem recuperar ofertas publicadas por anunciantes aos quais eles estão filiados (joined) ou não estão filiados.\r\n"
		    		+ "Os dados refletem as informações disponíveis na seção \"My Offers\" da interface da Awin.\r\n"
		    		+ "\r\n"
		    		+ "Devido à paginação implementada, não há limite para a quantidade de ofertas que podem ser recuperadas em uma única chamada da API."
		)
		@GetMapping("/promocoes/{advertiserId}")
		public ResponseEntity<PromocoesResponse> promocoes(
				@PathVariable Long advertiserId) throws RuntimeException, IOException, URISyntaxException {

		
		PromocoesRequest request = new PromocoesRequest();
		Filters requestFiltro = new Filters();
		Pagination paginacao = new Pagination();
		
		List<Long> idsParaSetar = new ArrayList<>();
		idsParaSetar.add(advertiserId);
		
		List<String> regioes = new ArrayList<>();
		regioes.add(config.getCountryCode());
		
		requestFiltro.setAdvertiserIds(idsParaSetar);
		requestFiltro.setExclusiveOnly(config.getExclusiveOnly());
		requestFiltro.setMembership(config.getRelationship());
		requestFiltro.setRegionCodes(regioes);
		requestFiltro.setStatus(config.getStatus());
		requestFiltro.setType(config.getType());
		
		paginacao.setPage(config.getPage());
		paginacao.setPageSize(config.getPageSize());
	
		
		request.setFilters(requestFiltro);
		request.setPagination(paginacao);
		
		
		PromocoesResponse response = awinService.promocoes(request);

		    if (response == null) {
		        return ResponseEntity.noContent().build();
		    }

		    return ResponseEntity.ok(response);
		
		}

	

}
