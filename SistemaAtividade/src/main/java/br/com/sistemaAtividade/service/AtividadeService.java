package br.com.sistemaAtividade.service;

import br.com.sistemaAtividade.domain.Atividade;

import java.util.List;

public interface AtividadeService {

    void salvar(Atividade atividade);
    void atualizar(Atividade atividade);
    void deletar (long id);
    //metodo que ira retornar uma lista de usuários
    List<Atividade> findAll();
    Atividade findBy(Long id);
}
