package br.com.deliverit.desafio.application.web.rest;

import br.com.deliverit.desafio.domain.dto.ContaPagarDTO;
import br.com.deliverit.desafio.domain.dto.ContaPagarListagemDTO;
import br.com.deliverit.desafio.domain.service.ContaPagarService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Classe Rest Conta a Pagar
 */
@Slf4j
@RestController
@Api(tags = "Conta a Pagar")
@Tag(name = "Conta a Pagar", description = "Recursos referente a Conta a Pagar")
@RequestMapping("/api/contas")
@RequiredArgsConstructor
public class ContaPagarRest {

    private final ContaPagarService service;

    private static final String IDENTIFICADOR = "Identificador único da Categoria";

    /**
     * Método Get responsavel por listar as contas cadastrada
     * @return
     */
    @GetMapping
    @Operation(description = "Recurso para listar uma(s) conta(s)", summary = "Listar Conta", responses = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<List<ContaPagarListagemDTO>> getAll() {
        log.debug("Requisição REST para listar onta");
        List<ContaPagarListagemDTO> result = service.getAll();

        return ResponseEntity.ok(result);
    }

    /**
     * Método responsável em persistir uma conta no banco
     * @param dto
     * @return
     * @throws Exception
     */
    @PostMapping
    @Operation(description = "Recurso para Salvar uma nova conta", summary = "Salvar Conta", responses = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<ContaPagarDTO> save(@Valid @RequestBody ContaPagarDTO dto) throws Exception {
        log.debug("Requisição REST para salvar conta: {}", dto);
        ContaPagarDTO result = service.save(dto);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

}
