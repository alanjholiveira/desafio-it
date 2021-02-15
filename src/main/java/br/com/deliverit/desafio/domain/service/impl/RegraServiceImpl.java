package br.com.deliverit.desafio.domain.service.impl;

import br.com.deliverit.desafio.domain.entity.ContaPagar;
import br.com.deliverit.desafio.domain.entity.Regra;
import br.com.deliverit.desafio.domain.service.RegraService;
import br.com.deliverit.desafio.infrastructure.repository.RegraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

/**
 * Classe contendo implementação da Interface {@link RegraService}
 */
@Service
@RequiredArgsConstructor
public class RegraServiceImpl implements RegraService {

    private final RegraRepository repository;

    /**
     * Método para calcular Multas e Juros
     * @param contaPagar
     * @return Double
     */
    @Override
    public Double calcularMultaJuros(ContaPagar contaPagar) {
        int diasAtraso = calcularDiasAtraso(contaPagar);
        List<Regra> regras = repository.findAll();

            Optional<Regra> regra = regras.stream().filter(r -> r.getDiasMin() <= diasAtraso && r.getDiasMax() > diasAtraso)
                    .findFirst();

            if (regra.isPresent()) {
                double valorMulta = contaPagar.getValorOriginal() * regra.get().getMulta();
                double valorJuros = contaPagar.getValorOriginal() * regra.get().getJuros();

                return valorMulta + (valorJuros * diasAtraso) + contaPagar.getValorOriginal();
            }
        return 0d;
    }

    /**
     * Método para calcular quntidade de dias vencido
     * @param contaPagar
     * @return
     */
    @Override
    public Integer calcularDiasAtraso(ContaPagar contaPagar) {
        return Math.toIntExact(ChronoUnit.DAYS.between(contaPagar.getDtVencimento(),
                contaPagar.getDtPagamento()));
    }
}
