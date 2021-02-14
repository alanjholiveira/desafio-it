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

@Configuration
public class SwaggerConfig {

    private final static String PACKAGEREST = "br.com.codeflix.videos.application.web";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage(PACKAGEREST))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Desafio DeliverIT")
                .description("API Rerferente ao Desafio DeliverIT")
                .version("1.0.0")
                .contact(contact())
                .build();
    }

    private Contact contact() {
        return new Contact(
                "Alan Oliveira",
                "https://github.com/alanjholiveira",
                "alanjhone@gmail.com");
    }

}
