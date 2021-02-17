package br.com.deliverit.desafio.application.web.rest;

import br.com.deliverit.desafio.builder.ContaPagarBuilder;
import br.com.deliverit.desafio.domain.entity.ContaPagar;
import br.com.deliverit.desafio.domain.service.mapper.ContaPagarMapper;
import br.com.deliverit.desafio.infrastructure.util.TestUtil;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.text.ParseException;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
class ContaPagarRestTests {

    @Autowired
    private ContaPagarBuilder builder;

    @Autowired
    private ContaPagarMapper mapper;

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Rule
    public ExpectedException excecaoEsperada = ExpectedException.none();

    @BeforeEach
    public void inicializaTeste() throws ParseException {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        this.builder.setCustomizacao(null);
    }

    @Test
    void testSave() throws Exception {
        ContaPagar contaPagar = builder.construirEntidade();
        executarCadastrarContaPagar(contaPagar, status().isCreated());
    }

    @Test
    void testSaveComMultaJuros() throws Exception {
        ContaPagar contaPagar = builder.construirEntidade();
        contaPagar.setDtPagamento(TestUtil.DT_PAGAMENTO_3_DIAS);

        executarCadastrarContaPagar(contaPagar, status().isCreated());
    }

    @Test
    void testSaveException() throws Exception {
        ContaPagar contaPagar = new ContaPagar();

        executarCadastrarContaPagar(contaPagar, status().isBadRequest());
    }

    @Test
    void testGetAll() throws Exception {
        builder.construir();

        mockMvc.perform(get("/api/contas"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].id", hasSize(1)));
    }

    private void executarCadastrarContaPagar(ContaPagar contaPagar, ResultMatcher created) throws Exception {
        mockMvc.perform(post("/api/contas")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(mapper.toDto(contaPagar))))
                .andExpect(created);
    }

}
