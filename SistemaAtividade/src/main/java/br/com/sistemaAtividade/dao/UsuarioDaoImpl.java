package br.com.sistemaAtividade.dao;

import br.com.sistemaAtividade.dao.Usuariodao;
import br.com.sistemaAtividade.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

// anotacao que denomina que somente essa class irá ter comunicacao com o banco de dados
@Repository
public class UsuarioDaoImpl implements Usuariodao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void salvar(Usuario usuario) {
        //persist é utilizado para salvar
        entityManager.persist(usuario);
    }

    @Override
    public void atualizar(Usuario usuario) {
        // merge é responsavel por atualizar
        entityManager.merge(usuario);
    }

    @Override
    public void deletar(long id) {

        entityManager.remove(entityManager.getReference(Usuario.class, id));
    }

    @Override
    public List<Usuario> findAll() {

        return entityManager.createQuery("select u from Usuario u", Usuario.class).getResultList();
    }

    @Override
    public Usuario findBy(Long id) {
        return entityManager.createQuery("select u from Usuario u where u.id=:id",Usuario.class).setParameter("id",id).getSingleResult();
    }
}
