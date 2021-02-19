package br.com.deliverit.desafio.domain.service;

import br.com.deliverit.desafio.builder.ContaPagarBuilder;
import br.com.deliverit.desafio.domain.dto.ContaPagarDTO;
import br.com.deliverit.desafio.domain.dto.ContaPagarListagemDTO;
import br.com.deliverit.desafio.domain.entity.ContaPagar;
import br.com.deliverit.desafio.domain.service.mapper.ContaPagarListagemMapper;
import br.com.deliverit.desafio.domain.service.mapper.ContaPagarMapper;
import br.com.deliverit.desafio.infrastructure.exception.RegraNegocioException;
import br.com.deliverit.desafio.infrastructure.repository.ContaPagarRepository;
import br.com.deliverit.desafio.infrastructure.util.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ContaPagarServiceTests {

    @MockBean
    private ContaPagarRepository repository;

    @Autowired
    private ContaPagarService service;

    @Autowired
    private ContaPagarListagemMapper listagemMapper;

    @Autowired
    private ContaPagarMapper mapper;

    @Autowired
    private ContaPagarBuilder builder;

    private List<ContaPagar> contaspagar;
    private ContaPagar entity1;
    private ContaPagar entity2;

    /**
     * Setup Initial
     */
    @BeforeEach
    void init() throws Exception {
        builder.setCustomizacao(null);
        entity1 = builder.construirEntidade();
        entity1.setId(TestUtil.ID);

        entity2 = builder.construirEntidade();
        entity2.setId(TestUtil.ID2);
        entity2.setDtPagamento(TestUtil.DT_PAGAMENTO_3_DIAS);

        contaspagar = new ArrayList<>();
        contaspagar.addAll(Arrays.asList(entity1, entity2));
    }

    @Test
    void testSave() throws RegraNegocioException {
        Mockito.when(repository.save(ArgumentMatchers.any(ContaPagar.class))).thenReturn(entity2);

        ContaPagarDTO result = service.save(mapper.toDto(entity2));

        Assertions.assertNotNull(result);
        Assertions.assertEquals(mapper.toDto(entity2), result);
    }

    @Test
    void testSaveException() throws RegraNegocioException {
        Mockito.doReturn(null).when(repository).save(ArgumentMatchers.any());
        AtomicReference<ContaPagarDTO> result = new AtomicReference<ContaPagarDTO>();

        Exception exception = Assertions.assertThrows(RegraNegocioException.class, () ->
            result.set(service.save(null))
        );

        Assertions.assertNull(result.get());
        Assertions.assertEquals("Erro ao Salvar os dados", exception.getMessage());
    }

    @Test
    void testGetAll() {
        Mockito.when(repository.findAll(Sort.by(Sort.Direction.DESC, "id"))).thenReturn(contaspagar);

        List<ContaPagarListagemDTO> result = service.getAll();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(listagemMapper.toDto(contaspagar), result);
    }

}
