package br.com.deliverit.desafio.domain.service.impl;

import br.com.deliverit.desafio.domain.dto.ContaPagarDTO;
import br.com.deliverit.desafio.domain.dto.ContaPagarListagemDTO;
import br.com.deliverit.desafio.domain.entity.ContaPagar;
import br.com.deliverit.desafio.domain.service.ContaPagarService;
import br.com.deliverit.desafio.domain.service.RegraService;
import br.com.deliverit.desafio.domain.service.mapper.ContaPagarListagemMapper;
import br.com.deliverit.desafio.domain.service.mapper.ContaPagarMapper;
import br.com.deliverit.desafio.infrastructure.exception.NotFoundException;
import br.com.deliverit.desafio.infrastructure.repository.ContaPagarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * Classe com implementação da interface
 */
@Service
@RequiredArgsConstructor
@Transactional
public class ContaPagarServiceImpl implements ContaPagarService {

    private final RegraService regraService;
    private final ContaPagarRepository repository;
    private final ContaPagarMapper mapper;
    private final ContaPagarListagemMapper listagemMapper;

    /**
     * Método para listagem Conta a Pagar
     * @return {@link List<ContaPagarListagemDTO>} - retorna uma lista de conta a pagar
     * @throws NotFoundException - Exeception caso ocorra algum erro
     */
    @Override
    @Transactional(readOnly = true)
    public List<ContaPagarListagemDTO> getAll() throws NotFoundException {
        List<ContaPagar> result = repository.findAll();
        return listagemMapper.toDto(result);
    }

    /**
     * Método para salvar conta a pagar no banco
     * @param {@link ContaPagarDTO} - dto com dados a ser salvo na base
     * @return {@link ContaPagarDTO} - retorna com registro salvo na base de dados
     * @throws Exception - Exceção caso ocorra erro durante a gravação do dados
     */
    @Override
    public ContaPagarDTO save(@Valid ContaPagarDTO dto) throws Exception {
        ContaPagar contaPagar = mapper.toEntity(dto);
        Double calcular = regraService.calcularMultaJuros(contaPagar);



//        Long diasAtraso = ChronoUnit.DAYS.between(dto.getDtVencimento(), dto.getDtPagamento());

//        String calcular;
//        if (diasAtraso <= 3 && diasAtraso >= 1) {
//            calcular = "até 3 dias";
//        } else if (diasAtraso > 3 && diasAtraso <= 5 ) {
//            calcular = "superior a 3 dias";
//        } else if (diasAtraso > 5) {
//            calcular = "superior a 5 dias";
//        }

//        ContaPagar contaPagar = repository.save(mapper.toEntity(dto));

//        return mapper.toDto(contaPagar);
        return dto;
    }
}
