package br.com.deliverit.desafio.domain.service.impl;

import br.com.deliverit.desafio.domain.dto.ContaPagarDTO;
import br.com.deliverit.desafio.domain.dto.ContaPagarListagemDTO;
import br.com.deliverit.desafio.domain.entity.ContaPagar;
import br.com.deliverit.desafio.domain.entity.Regra;
import br.com.deliverit.desafio.domain.service.ContaPagarService;
import br.com.deliverit.desafio.domain.service.RegraService;
import br.com.deliverit.desafio.domain.service.mapper.ContaPagarListagemMapper;
import br.com.deliverit.desafio.domain.service.mapper.ContaPagarMapper;
import br.com.deliverit.desafio.infrastructure.exception.NotFoundException;
import br.com.deliverit.desafio.infrastructure.exception.RegraNegocioException;
import br.com.deliverit.desafio.infrastructure.repository.ContaPagarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
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
    public List<ContaPagarListagemDTO> getAll(){
        List<ContaPagar> result = repository.findAll();
        return listagemMapper.toDto(result);
    }

    /**
     * Método para salvar conta a pagar no banco
     * @param dto {@link ContaPagarDTO} - dto com dados a ser salvo na base
     * @return {@link ContaPagarDTO} - retorna com registro salvo na base de dados
     * @throws RegraNegocioException - Exceção caso ocorra erro durante a gravação do dados
     */
    @Override
    public ContaPagarDTO save(@Valid ContaPagarDTO dto) throws RegraNegocioException {
       try {
           ContaPagar contaPagar = preencherEntidade(dto);

           ContaPagar result = repository.save(contaPagar);

           return mapper.toDto(result);
       } catch (Exception e) {
           throw new RegraNegocioException("Erro ao Salvar os dados");
       }
    }


    /**
     * Método responsável por retornar a entidade preenchida para
     * persistir na base de dados
     * @param dto - {@link ContaPagarDTO}
     * @return {@link ContaPagar}
     */
    private ContaPagar preencherEntidade(ContaPagarDTO dto) {

        ContaPagar contaPagar = mapper.toEntity(dto);
        Regra regra = regraService.obterRegra(contaPagar);
        contaPagar.setValorCorrigido(regraService.calcularMultaJuros(contaPagar));
        contaPagar.setDiasAtraso(regraService.calcularDiasAtraso(contaPagar));
        contaPagar.setJuros(regra.getJuros());
        contaPagar.setMulta(regra.getMulta());
        contaPagar.setDescricaoRegra(regra.getDescricao());

        return contaPagar;
    }
}
