package br.com.fiap.coletalixo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ColetaDeLixoCadastroDto(
        Long id,

        @NotBlank(message = "Campo região é obrigatório!")
        String regiao,

        @NotBlank(message = "Campo motorista é obrigatório!")
        String motorista,

        @NotBlank(message = "Campo caminhão é obrigatório!")
        String caminhao,

        @NotNull(message = "Campo data de coleta é obrigatório!")
        LocalDate dataColeta
) {
}
