package br.com.deliverit.desafio.domain.entity;

import br.com.deliverit.desafio.builder.ContaPagarBuilder;
import br.com.deliverit.desafio.infrastructure.util.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;

@SpringBootTest
class ContaPagarTests {

    @Autowired
    private ContaPagarBuilder builder;

    private ContaPagar entity1;
    private ContaPagar entity2;

    /**
     * Setup Initial
     */
    @BeforeEach
    void init() throws ParseException {

        entity1 = builder.construirEntidade();
        entity1.setId(TestUtil.ID);

        entity2 = builder.construirEntidade();
        entity2.setId(TestUtil.ID);

    }

    /**
     * Test Método Equals.
     */
    @Test
    void testEquals() {
        Assertions.assertEquals(entity1, entity2);

        entity2.setId(TestUtil.ID2);
        Assertions.assertNotEquals(entity1, entity2);
    }

    /**
     * Test Método hashCode.
     */
    @Test
    void testHashCode() {
        Assertions.assertEquals(entity1.hashCode(), entity2.hashCode());

        entity2.setId(TestUtil.ID2);
        Assertions.assertNotEquals(entity1.hashCode(), entity2.hashCode());
    }

    /**
     * Test Método getId
     */
    @Test
    void getId() {
        Assertions.assertEquals(TestUtil.ID, entity1.getId());
    }

    /**
     * Test Método getNome
     */
    @Test
    void getName() {
        Assertions.assertEquals(TestUtil.NOME, entity1.getNome());
    }

    /**
     * Test Método getValorOriginal
     */
    @Test
    void getValorOriginal() {
        Assertions.assertEquals(TestUtil.VALOR, entity1.getValorOriginal());
    }

    /**
     * Test Método getValorCorrigido
     */
    @Test
    void getValorCorrigido() {
        Assertions.assertEquals(TestUtil.VALOR_CORRIGIDO, entity1.getValorCorrigido());
    }

    /**
     * Test Método getQtdAtraso
     */
    @Test
    void getQtdAtraso() {
        Assertions.assertEquals(TestUtil.DIAS_ATRASO, entity1.getDiasAtraso());
    }

    /**
     * Test Método getDtVencimento
     */
    @Test
    void getDtVencimento() {
        Assertions.assertEquals(TestUtil.DT_VENCIMENTO, entity1.getDtVencimento());
    }

    /**
     * Test Método getDtPagamento
     */
    @Test
    void getDtPagamento() {
        Assertions.assertEquals(TestUtil.DT_PAGAMENTO, entity1.getDtPagamento());
    }
}
