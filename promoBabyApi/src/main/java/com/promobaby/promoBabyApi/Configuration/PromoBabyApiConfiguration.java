package com.promobaby.promoBabyApi.Configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class PromoBabyApiConfiguration {
	
	@Bean(name = "apiAwinHttpClient")
	@ConfigurationProperties(prefix = "promobaby.api.awin")
	public PromoBabyApiAwinProperties pfCnisHttpClientPropertiesParqueA() {
		return new PromoBabyApiAwinProperties() {
		};
	}

}
