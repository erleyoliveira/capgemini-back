package br.com.capgemini.desafio.configuracao;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguracao {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("br.com.capgemini.desafio.api")).paths(PathSelectors.ant("/api/**"))
				.build().apiInfo(apiInfo()).securityContexts(Arrays.asList(actuatorSecurityContext()))
				.securitySchemes(Arrays.asList(basicAuthScheme()));
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("API Capgemini service", "Descrição da API de comunicação do desafio", "API TOS",
				"Termos de serviço",
				new Contact("Erley da Silva Oliveira", "www.capgemini.com", "erleyoliveira@hotmail.com"), "", "",
				Collections.emptyList());
	}

	private SecurityContext actuatorSecurityContext() {
		return SecurityContext.builder().securityReferences(Arrays.asList(basicAuthReference()))
				.forPaths(PathSelectors.ant("/api/**")).build();
	}

	private SecurityScheme basicAuthScheme() {
		return new BasicAuth("basicAuth");
	}

	private SecurityReference basicAuthReference() {
		return new SecurityReference("basicAuth", new AuthorizationScope[0]);
	}

}
