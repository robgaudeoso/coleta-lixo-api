package br.com.fiap.coletalixo.service;

import br.com.fiap.coletalixo.dto.ColetaDeLixoCadastroDto;
import br.com.fiap.coletalixo.dto.ColetaDeLixoExibicaoDto;
import br.com.fiap.coletalixo.exception.DadoNaoEncontradoException;
import br.com.fiap.coletalixo.model.ColetaDeLixo;
import br.com.fiap.coletalixo.repository.ColetaDeLixoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ColetaDeLixoService {

    @Autowired
    private ColetaDeLixoRepository coletaRepository;

    public ColetaDeLixoExibicaoDto agendar(ColetaDeLixoCadastroDto contatoCadastroDto) {
        ColetaDeLixo coleta = new ColetaDeLixo();
        BeanUtils.copyProperties(contatoCadastroDto, coleta);
        return new ColetaDeLixoExibicaoDto(coletaRepository.save(coleta));
    }

    public ColetaDeLixoExibicaoDto buscarPorId(Long id) {

        Optional<ColetaDeLixo> coletaOptional = coletaRepository.findById(id);

        if (coletaOptional.isPresent()) {
            return new ColetaDeLixoExibicaoDto(coletaOptional.get());
        } else {
            throw new DadoNaoEncontradoException("Agendamento não encontrado!");
        }
    }

    public List<ColetaDeLixoExibicaoDto> listarTodos() {

        return coletaRepository
                .findAll()
                .stream()
                .map(ColetaDeLixoExibicaoDto::new)
                .toList();
    }

    public void excluir(Long id) {
        Optional<ColetaDeLixo> coletaOptional = coletaRepository.findById(id);

        if (coletaOptional.isPresent()) {
            coletaRepository.delete(coletaOptional.get());
        } else {
            throw new DadoNaoEncontradoException("Agendamento não encontrado!");
        }
    }

    public List<ColetaDeLixo> buscarAgendamentoPorData(LocalDate dataInicial, LocalDate dataFinal) {
        return coletaRepository.findByDataColetaBetween(dataInicial, dataFinal);
    }

    public ColetaDeLixo atualizar(ColetaDeLixo coleta) {
        Optional<ColetaDeLixo> coletaOptional = coletaRepository.findById(coleta.getId());

        if (coletaOptional.isPresent()) {
            return coletaRepository.save(coleta);
        } else {
            throw new DadoNaoEncontradoException("Agendamento não encontrado!");
        }
    }

    public ColetaDeLixoExibicaoDto buscarPelaRegiao(String regiao) {

        Optional<ColetaDeLixo> coletaOptional = coletaRepository.findByRegiao(regiao);

        if (coletaOptional.isPresent()) {
            return new ColetaDeLixoExibicaoDto(coletaOptional.get());
        } else {
            throw new DadoNaoEncontradoException("Agendamento não encontrado!");
        }
    }
}
