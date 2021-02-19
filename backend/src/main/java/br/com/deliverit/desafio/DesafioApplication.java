package br.com.deliverit.desafio;

import br.com.deliverit.desafio.infrastructure.util.DefaultProfileUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DesafioApplication.class);
        DefaultProfileUtil.addDefaultProfile(app);
        app.run(args);
    }

}
