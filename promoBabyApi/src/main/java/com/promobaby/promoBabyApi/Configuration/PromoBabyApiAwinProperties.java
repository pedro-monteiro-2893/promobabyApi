package com.promobaby.promoBabyApi.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class PromoBabyApiAwinProperties {
	
	private Integer requestTimeout;

	private Integer connectionTimeOut;

	private Integer maxConnections;

	private Integer connectionRequestFromPoolTimeout;

	private Integer retryCount;

	private Integer retryInterval;

	private String autentication;

	private String userName;

	private String passWord;
	
	private String versao;
	
	private String baseUrl;
	
	private String afiliadoId;
	
	private String countryCode;
	
	private String apiKey;
	
	private String relationship;
	
	private String programasFiliados;
	
	private String programasDetalhes;
	
	private String promocoes;
	
	private String linkBuilderQuota;
	
	private String linkBuilder;
	
	private String linkBuilderBatch;
	
	private String comissoes;
	
	private String comissoesCompartilhamento;
	
	private String reportsAdvertiser;
	
	private String reportsCampaign;
	
	private String reportsCreative;
}
