package br.com.sistemaAtividade.service;

import br.com.sistemaAtividade.dao.Usuariodao;
import br.com.sistemaAtividade.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsuarioServiceImpl implements  UsuarioService {

    @Autowired
    private Usuariodao usuariodao;


    @Override
    public void salvar(Usuario usuario) {

        usuariodao.salvar(usuario);
    }

    @Override
    public void atualizar(Usuario usuario) {

        usuariodao.atualizar(usuario);
    }

    @Override
    public void deletar(long id) {

        usuariodao.deletar(id);
    }

    @Override
    public List<Usuario> findAll() {

        return usuariodao.findAll();
    }

    @Override
    public Usuario findBy(Long id) {

        return usuariodao.findBy(id);
    }
}
