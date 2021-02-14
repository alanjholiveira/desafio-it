package br.com.deliverit.desafio.infrastructure.util;

import org.springframework.boot.SpringApplication;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe responsável pela definição do profile DEV, caso nenhum perfil seja especificado
 */
public class DefaultProfileUtil {

    private static final String SPRING_PROFILE_DEFAULT = "spring.profiles.default";
    private static final String PROFILE_DEFAULT = "dev";

    private DefaultProfileUtil() {
    }

    /**
     * Método responsavel por adicionar profile padrão
     * @param app
     */
    public static void addDefaultProfile(SpringApplication app) {
        Map<String, Object> defProperties = new HashMap<>();
        defProperties.put(SPRING_PROFILE_DEFAULT, PROFILE_DEFAULT);
        app.setDefaultProperties(defProperties);
    }

}
