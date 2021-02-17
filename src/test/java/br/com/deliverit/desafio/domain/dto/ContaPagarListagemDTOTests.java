package br.com.deliverit.desafio.domain.dto;

import br.com.deliverit.desafio.builder.ContaPagarBuilder;
import br.com.deliverit.desafio.domain.service.mapper.ContaPagarListagemMapper;
import br.com.deliverit.desafio.infrastructure.util.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;

@SpringBootTest
class ContaPagarListagemDTOTests {

    @Autowired
    private ContaPagarBuilder builder;

    @Autowired
    private ContaPagarListagemMapper mapper;

    private ContaPagarListagemDTO dto1;
    private ContaPagarListagemDTO dto2;

    /**
     * Setup Initial
     */
    @BeforeEach
    void init() throws ParseException {

        dto1 = mapper.toDto(builder.construirEntidade());
        dto1.setId(TestUtil.ID);

        dto2 = mapper.toDto(builder.construirEntidade());
        dto2.setId(TestUtil.ID);

    }

    /**
     * Test Método Equals.
     */
    @Test
    void testEquals() {
        Assertions.assertEquals(dto1, dto2);

        dto2.setId(TestUtil.ID2);
        Assertions.assertNotEquals(dto1, dto2);
    }

    /**
     * Test Método hashCode.
     */
    @Test
    void testHashCode() {
        Assertions.assertEquals(dto1.hashCode(), dto2.hashCode());

        dto2.setId(TestUtil.ID2);
        Assertions.assertNotEquals(dto1.hashCode(), dto2.hashCode());
    }

    /**
     * Test Método getId
     */
    @Test
    void getId() {
        Assertions.assertEquals(TestUtil.ID, dto1.getId());
    }

    /**
     * Test Método getNome
     */
    @Test
    void getName() {
        Assertions.assertEquals(TestUtil.NOME, dto1.getNome());
    }

    /**
     * Test Método getValorOriginal
     */
    @Test
    void getValorOriginal() {
        Assertions.assertEquals(TestUtil.VALOR, dto1.getValorOriginal());
    }

    /**
     * Test Método getValorCorrigido
     */
    @Test
    void getValorCorrigido() {
        Assertions.assertEquals(TestUtil.VALOR_CORRIGIDO, dto1.getValorCorrigido());
    }

    /**
     * Test Método getDiasAtraso
     */
    @Test
    void getDiasAtraso() {
        Assertions.assertEquals(TestUtil.DIAS_ATRASO, dto1.getDiasAtraso());
    }

    /**
     * Test Método getDtVencimento
     */
    @Test
    void getDtVencimento() {
        Assertions.assertEquals(TestUtil.DT_VENCIMENTO, dto1.getDtVencimento());
    }

    /**
     * Test Método getDtPagamento
     */
    @Test
    void getDtPagamento() {
        Assertions.assertEquals(TestUtil.DT_PAGAMENTO, dto1.getDtPagamento());
    }
}
