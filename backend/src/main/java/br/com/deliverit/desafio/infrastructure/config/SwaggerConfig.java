package br.com.deliverit.desafio.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Classe responśavel pela configuração do Swagger
 */
@Configuration
public class SwaggerConfig {

    private static final String PACKAGE_REST = "br.com.deliverit.desafio.application.web.rest";

    /**
     * Método de configurações Swagger
     * @return {@link Docket}
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage(PACKAGE_REST))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    /**
     * Método contendo informações a ser inserida no Swagger
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Desafio DeliverIT")
                .description("API Rerferente ao Desafio DeliverIT")
                .version("1.0.0")
                .contact(contact())
                .build();
    }

    /**
     * Método contendo dados para contato
     * @return
     */
    private Contact contact() {
        return new Contact(
                "Alan Oliveira",
                "https://github.com/alanjholiveira",
                "alanjhone@gmail.com");
    }

}
