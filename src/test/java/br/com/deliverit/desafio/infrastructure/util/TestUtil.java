package br.com.deliverit.desafio.infrastructure.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

public class TestUtil {

    public static final Long ID = 1L;
    public static final Long ID2 = 2L;
    public static final String NOME = "Nome Teste Conta";
    public static final Double VALOR = 120.00;
    public static final Double VALOR_CORRIGIDO = 122.10;
    public static final Double VALOR_SEM_CORRECAO = 0.0;
    public static final Double VALOR_SEM_CORRECAO_2_REGRA = 122.76;
    public static final LocalDate DT_VENCIMENTO = LocalDate.now();
    public static final LocalDate DT_PAGAMENTO = LocalDate.now();
    public static final LocalDate DT_PAGAMENTO_3_DIAS = LocalDate.now().plusDays(3);
    public static final int DIAS_ATRASO = 3;
    public static final int DIAS_ATRASO_SEM = 0;
    public static final String DESCRICAO = "Descrição TESTE";
    public static final int DIAS_MIN = 1;
    public static final int DIAS_MIN_4 = 4;
    public static final int DIAS_MAX = 3;
    public static final int DIAS_MAX_5 = 5;
    public static final Double JUROS = 0.001;
    public static final Double JUROS_2 = 0.002;
    public static final Double MULTA = 0.02;
    public static final Double MULTA_2 = 0.03;

    /**
     * MediaType for JSON UTF8
     */
    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(
            MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), StandardCharsets.UTF_8);

    /**
     * Convert an object to JSON byte array.
     *
     * @param object the object to convert
     * @return the JSON byte array
     * @throws IOException Exceção a ser lançada
     */
    public static byte[] convertObjectToJsonBytes(Object object)
            throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        JavaTimeModule module = new JavaTimeModule();
        mapper.registerModule(module);

        return mapper.writeValueAsBytes(object);
    }

}
