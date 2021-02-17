package br.com.deliverit.desafio.domain.entity;

import br.com.deliverit.desafio.builder.RegraBuilder;
import br.com.deliverit.desafio.infrastructure.util.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;

@SpringBootTest
class RegraTests {

    @Autowired
    private RegraBuilder builder;

    private Regra entity1;
    private Regra entity2;

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
     * Test Método getDescricao
     */
    @Test
    void getDescricao() {
        Assertions.assertEquals(TestUtil.DESCRICAO, entity1.getDescricao());
    }

    /**
     * Test Método getDiasMin
     */
    @Test
    void getDiasMin() {
        Assertions.assertEquals(TestUtil.DIAS_MIN, entity1.getDiasMin());
    }

    /**
     * Test Método getDiasMax
     */
    @Test
    void getDiasMax() {
        Assertions.assertEquals(TestUtil.DIAS_MAX, entity1.getDiasMax());
    }

    /**
     * Test Método getJuros
     */
    @Test
    void getJuros() {
        Assertions.assertEquals(TestUtil.JUROS, entity1.getJuros());
    }

    /**
     * Test Método getMulta
     */
    @Test
    void getMulta() {
        Assertions.assertEquals(TestUtil.MULTA, entity1.getMulta());
    }

}
