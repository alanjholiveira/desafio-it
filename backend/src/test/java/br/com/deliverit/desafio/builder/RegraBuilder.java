package br.com.deliverit.desafio.builder;

import br.com.deliverit.desafio.domain.entity.Regra;
import br.com.deliverit.desafio.domain.service.RegraService;
import br.com.deliverit.desafio.infrastructure.repository.RegraRepository;
import br.com.deliverit.desafio.infrastructure.util.TestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;

@Component
public class RegraBuilder extends ConstrutorDeEntidade<Regra> {

    @Autowired
    private RegraService service;

    @Autowired
    private RegraRepository repository;

    @Override
    public Regra construirEntidade() throws ParseException {
        Regra entity = new Regra();
        entity.setId(TestUtil.ID);
        entity.setDescricao(TestUtil.DESCRICAO);
        entity.setDiasMin(TestUtil.DIAS_MIN);
        entity.setDiasMax(TestUtil.DIAS_MAX);
        entity.setJuros(TestUtil.JUROS);
        entity.setMulta(TestUtil.MULTA);

        return entity;
    }

    @Override
    public Regra persistir(Regra entidade) {
        return repository.save(entidade);
    }

    @Override
    protected Collection<Regra> obterTodos() {
        return repository.findAll();
    }

    @Override
    protected Regra obterPorId(Integer id) {
        return repository.findById(id.longValue()).orElse(null);
    }
}
