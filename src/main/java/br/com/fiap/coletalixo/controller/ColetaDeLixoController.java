package br.com.fiap.coletalixo.controller;

import br.com.fiap.coletalixo.dto.ColetaDeLixoCadastroDto;
import br.com.fiap.coletalixo.dto.ColetaDeLixoExibicaoDto;
import br.com.fiap.coletalixo.model.ColetaDeLixo;
import br.com.fiap.coletalixo.service.ColetaDeLixoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ColetaDeLixoController {

    @Autowired
    private ColetaDeLixoService service;

    @PostMapping("/coletas")
    @ResponseStatus(HttpStatus.CREATED)
    public ColetaDeLixoExibicaoDto agendar(@RequestBody @Valid ColetaDeLixoCadastroDto coletaDeLixoCadastroDto) {
        return service.agendar(coletaDeLixoCadastroDto);
    }

    @GetMapping("/coletas")
    @ResponseStatus(HttpStatus.OK)
    public List<ColetaDeLixoExibicaoDto> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/coletas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ColetaDeLixoExibicaoDto buscarPorId(@PathVariable Long id) {return service.buscarPorId(id);
    }

    @GetMapping(value = "/coletas", params = "regiao")
    @ResponseStatus(HttpStatus.OK)
    public ColetaDeLixoExibicaoDto buscarPelaRegiao(@RequestParam String regiao) {
        return service.buscarPelaRegiao(regiao);
    }

    @GetMapping("/coletas/{dataInicial}/{dataFinal}")
    @ResponseStatus(HttpStatus.OK)
    public List<ColetaDeLixo> buscarAgendamentoPorData(
            @PathVariable LocalDate dataInicial,
            @PathVariable LocalDate dataFinal) {
        return service.buscarAgendamentoPorData(dataInicial, dataFinal);
    }

    @DeleteMapping("/coletas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }

    @PutMapping("/coletas")
    @ResponseStatus(HttpStatus.OK)
    public ColetaDeLixo atualizar(@RequestBody ColetaDeLixo contato) {
        return service.atualizar(contato);
    }

}
