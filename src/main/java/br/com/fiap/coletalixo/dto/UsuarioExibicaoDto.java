package br.com.fiap.coletalixo.dto;

import br.com.fiap.coletalixo.model.Usuario;
import br.com.fiap.coletalixo.model.UsuarioRole;

public record UsuarioExibicaoDto(
        Long usuarioId,
        String nome,
        String email,
        UsuarioRole role
) {
    public UsuarioExibicaoDto(Usuario usuario) {
        this(
                usuario.getUsuarioId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getRole());
    }
}
