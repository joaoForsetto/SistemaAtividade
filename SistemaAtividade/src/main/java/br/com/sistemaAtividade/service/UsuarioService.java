package br.com.sistemaAtividade.service;

import br.com.sistemaAtividade.domain.Usuario;

import java.util.List;

public interface UsuarioService {
    void salvar(Usuario usuario);
    void atualizar(Usuario usuario);
    void deletar (long id);
    //metodo que ira retornar uma lista de usuários
    List<Usuario> findAll();
    Usuario findBy(Long id);
}
