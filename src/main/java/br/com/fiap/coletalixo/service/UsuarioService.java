package br.com.fiap.coletalixo.service;

import br.com.fiap.coletalixo.dto.UsuarioCadastroDto;
import br.com.fiap.coletalixo.dto.UsuarioExibicaoDto;
import br.com.fiap.coletalixo.exception.DadoNaoEncontradoException;
import br.com.fiap.coletalixo.model.Usuario;
import br.com.fiap.coletalixo.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioExibicaoDto salvarUsuario(UsuarioCadastroDto usuarioCadastroDto) {

        String senhaCriptografada = new BCryptPasswordEncoder().encode(usuarioCadastroDto.senha());

        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioCadastroDto, usuario);
        usuario.setSenha(senhaCriptografada);

        return new UsuarioExibicaoDto(usuarioRepository.save(usuario));
    }

    public UsuarioExibicaoDto buscarPorId(Long id) {

        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if (usuarioOptional.isPresent()) {
            return new UsuarioExibicaoDto(usuarioOptional.get());
        } else {
            throw new DadoNaoEncontradoException("Usuário não encontrado!");
        }
    }

    public List<UsuarioExibicaoDto> listarTodos() {

        return usuarioRepository
                .findAll()
                .stream()
                .map(UsuarioExibicaoDto::new)
                .toList();
    }

    public void excluir(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if (usuarioOptional.isPresent()) {
            usuarioRepository.delete(usuarioOptional.get());
        } else {
            throw new DadoNaoEncontradoException("Usuário não encontrado!");
        }
    }
    public Usuario atualizar(Usuario usuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuario.getUsuarioId());

        if (usuarioOptional.isPresent()) {
            return usuarioRepository.save(usuario);
        } else {
            throw new DadoNaoEncontradoException("Usuário não encontrado!");
        }
    }
}
