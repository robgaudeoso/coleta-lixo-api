package br.com.fiap.coletalixo.controller;

import br.com.fiap.coletalixo.dto.UsuarioCadastroDto;
import br.com.fiap.coletalixo.dto.UsuarioExibicaoDto;
import br.com.fiap.coletalixo.model.Usuario;
import br.com.fiap.coletalixo.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @PostMapping("/usuarios")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioExibicaoDto salvar(@RequestBody @Valid UsuarioCadastroDto usuarioCadastroDto) {
        return service.salvarUsuario(usuarioCadastroDto);
    }

    @GetMapping("/usuarios")
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioExibicaoDto> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/usuarios/{usuarioId}")
    public UsuarioExibicaoDto buscarPorId(@PathVariable Long usuarioId) {
        return service.buscarPorId(usuarioId);
    }

    @DeleteMapping("/usuarios/{usuarioId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long usuarioId) {
        service.excluir(usuarioId);
    }

    @PutMapping("/usuarios")
    @ResponseStatus(HttpStatus.OK)
    public Usuario atualizar(@RequestBody Usuario usuario) {
        return service.atualizar(usuario);
    }

}

