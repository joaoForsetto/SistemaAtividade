package br.com.sistemaAtividade.dao;

import br.com.sistemaAtividade.domain.Atividade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository

public class AtividadeDaoImpl implements  AtividadeDao {

    @Autowired private EntityManager entityManager;

    @Override
    public void salvar(Atividade atividade) {
        entityManager.persist(atividade);

    }

    @Override
    public void atualizar(Atividade atividade) {

        entityManager.merge(atividade);
    }

    @Override
    public void deletar(long id) {
        entityManager.remove(entityManager.getReference(Atividade.class,id));

    }

    @Override
    public List<Atividade> findAll() {
        return entityManager.createQuery("select a from Atividade a").getResultList();
    }

    @Override
    public Atividade findBy(Long id) {
        return entityManager.createQuery("select a from Atividade a where a.id= :id", Atividade.class).setParameter("id",id).getSingleResult();

    }


}
