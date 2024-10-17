package br.com.fiap.coletalixo.dto;

import br.com.fiap.coletalixo.model.ColetaDeLixo;

import java.time.LocalDate;

public record ColetaDeLixoExibicaoDto(
    Long id,
    String regiao,
    String motorista,
    String caminhao,
    LocalDate dataColeta
) {
    public ColetaDeLixoExibicaoDto(ColetaDeLixo coleta) {
        this(
                coleta.getId(),
                coleta.getRegiao(),
                coleta.getMotorista(),
                coleta.getCaminhao(),
                coleta.getDataColeta()
        );
    }
}
