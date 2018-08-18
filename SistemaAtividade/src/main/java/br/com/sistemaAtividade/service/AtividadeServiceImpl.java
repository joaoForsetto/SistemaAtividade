package br.com.sistemaAtividade.service;

import br.com.sistemaAtividade.dao.AtividadeDao;
import br.com.sistemaAtividade.domain.Atividade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AtividadeServiceImpl implements  AtividadeService {

    @Autowired
    private AtividadeDao atividadeDao;

    @Override
    public void salvar(Atividade atividade) {
        atividadeDao.salvar(atividade);
    }

    @Override
    public void atualizar(Atividade atividade) {
        atividadeDao.atualizar(atividade);
    }

    @Override
    public void deletar(long id) {
        atividadeDao.deletar(id);
    }

    @Override
    public List<Atividade> findAll() {
        return atividadeDao.findAll();
    }

    @Override
    public Atividade findBy(Long id) {
        return atividadeDao.findBy(id);
    }
}
