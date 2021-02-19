package br.com.deliverit.desafio.builder;

import br.com.deliverit.desafio.domain.dto.ContaPagarDTO;
import br.com.deliverit.desafio.domain.entity.ContaPagar;
import br.com.deliverit.desafio.domain.entity.Regra;
import br.com.deliverit.desafio.domain.service.ContaPagarService;
import br.com.deliverit.desafio.domain.service.mapper.ContaPagarMapper;
import br.com.deliverit.desafio.infrastructure.repository.ContaPagarRepository;
import br.com.deliverit.desafio.infrastructure.util.TestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;

@Component
public class ContaPagarBuilder extends ConstrutorDeEntidade<ContaPagar> {

    @Autowired
    private ContaPagarService service;

    @Autowired
    private ContaPagarMapper mapper;

    @Autowired
    private ContaPagarRepository repository;

    @Autowired
    private RegraBuilder regraBuilder;

    @Override
    public ContaPagar construirEntidade() throws ParseException {

        Regra regra = regraBuilder.construirEntidade();
        regraBuilder.persistir(regra);

        ContaPagar entity = new ContaPagar();

        entity.setNome(TestUtil.NOME);
        entity.setValorOriginal(TestUtil.VALOR);
        entity.setValorCorrigido(TestUtil.VALOR_CORRIGIDO);
        entity.setDiasAtraso(TestUtil.DIAS_ATRASO);
        entity.setDtVencimento(TestUtil.DT_VENCIMENTO);
        entity.setDtPagamento(TestUtil.DT_PAGAMENTO);

        return entity;
    }

    @Override
    public ContaPagar persistir(ContaPagar entidade) {
        ContaPagarDTO dto = mapper.toDto(entidade);

        return mapper.toEntity(service.save(dto));
    }

    @Override
    public Collection<ContaPagar> obterTodos() {
        return repository.findAll();
    }

    @Override
    protected ContaPagar obterPorId(Integer id) {
        return null;
    }
}
