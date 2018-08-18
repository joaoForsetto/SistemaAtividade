package br.com.sistemaAtividade.dao;

import br.com.sistemaAtividade.domain.Atividade;
import br.com.sistemaAtividade.domain.Usuario;

import java.util.List;

public interface AtividadeDao {

    void salvar(Atividade atividade);
    void atualizar(Atividade atividade);
    void deletar (long id);
    //metodo que ira retornar uma lista de usuários
    List<Atividade> findAll();
    Atividade findBy (Long id);
}
