package br.com.fiap.coletalixo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DadoNaoEncontradoException extends RuntimeException {

    public DadoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
