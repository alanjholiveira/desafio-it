package br.com.deliverit.desafio.domain.service;

import br.com.deliverit.desafio.builder.ContaPagarBuilder;
import br.com.deliverit.desafio.builder.RegraBuilder;
import br.com.deliverit.desafio.domain.entity.ContaPagar;
import br.com.deliverit.desafio.domain.entity.Regra;
import br.com.deliverit.desafio.infrastructure.repository.RegraRepository;
import br.com.deliverit.desafio.infrastructure.util.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class RegraServiceTests {

    @MockBean
    private RegraRepository repository;

    @Autowired
    private RegraService service;

    @Autowired
    private RegraBuilder builder;

    @Autowired
    private ContaPagarBuilder contaPagarBuilder;

    private List<Regra> regras;
    private Regra entity1;
    private Regra entity2;
    private ContaPagar contaPagar;

    /**
     * Setup Initial
     */
    @BeforeEach
    void init() throws ParseException {

        entity1 = builder.construirEntidade();
        entity1.setId(TestUtil.ID);

        entity2 = builder.construirEntidade();
        entity2.setId(TestUtil.ID2);
        entity2.setDiasMin(TestUtil.DIAS_MIN_4);
        entity2.setDiasMax(TestUtil.DIAS_MAX_5);
        entity2.setJuros(TestUtil.JUROS_2);
        entity2.setMulta(TestUtil.MULTA_2);

        contaPagar = contaPagarBuilder.construirEntidade();
        contaPagar.setId(TestUtil.ID);

        regras = new ArrayList<>();
        regras.addAll(Arrays.asList(entity1, entity2));
    }

    @Test
    void testCalcularMultaJuros() {
        Mockito.when(repository.findAll()).thenReturn(regras);

        Double result = service.calcularMultaJuros(contaPagar);

        Assertions.assertEquals(TestUtil.VALOR_SEM_CORRECAO, result);
    }

    @Test
    void testCalcularMultaJurosComAtraso() {
        Mockito.when(repository.findAll()).thenReturn(regras);

        contaPagar.setDtPagamento(TestUtil.DT_PAGAMENTO_3_DIAS);
        Double result = service.calcularMultaJuros(contaPagar);

        Assertions.assertEquals(TestUtil.VALOR_SEM_CORRECAO_2_REGRA, result);
    }

    @Test
    void testCalcularDiasAtraso() {
        Mockito.when(repository.findAll()).thenReturn(regras);

        Integer result = service.calcularDiasAtraso(contaPagar);

        Assertions.assertEquals(TestUtil.DIAS_ATRASO_SEM, result);
    }

    @Test
    void testCalcularDiasAtrasoComAtraso() {
        Mockito.when(repository.findAll()).thenReturn(regras);

        contaPagar.setDtPagamento(TestUtil.DT_PAGAMENTO_3_DIAS);
        Integer result = service.calcularDiasAtraso(contaPagar);

        Assertions.assertEquals(TestUtil.DIAS_ATRASO, result);
    }

    @Test
    void testObterRegra() {
        Mockito.when(repository.findAll()).thenReturn(regras);

        Regra result = service.obterRegra(contaPagar);

        Assertions.assertEquals(new Regra(), result);
    }

    @Test
    void testObterRegraComAtraso() {
        Mockito.when(repository.findAll()).thenReturn(regras);

        contaPagar.setDtPagamento(TestUtil.DT_PAGAMENTO_3_DIAS);
        Regra result = service.obterRegra(contaPagar);

        Assertions.assertEquals(entity1, result);
    }

}
