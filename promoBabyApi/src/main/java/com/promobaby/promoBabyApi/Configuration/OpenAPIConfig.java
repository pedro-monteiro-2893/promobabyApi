package com.promobaby.promoBabyApi.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {
	
	@Bean
	public OpenAPI customOpenAPI() {
        return new OpenAPI()
                		.info(new Info()
                        .title("PromoBaby-Api")
                        .version("1.0") //TODO pegar do pacote gerado
                        .description("Api do PromoBaby"));
    }

}
