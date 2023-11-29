package br.ifpr.jogo.dao;

import java.util.List;
import br.ifpr.jogo.modelo.Asteroide;

public interface AsteroideDao {
    public List<Asteroide> buscarTodos();
    public Asteroide buscarPorId(Integer id);
    public void atualizar(Asteroide asteroide);
    public void excluir(Asteroide asteroide);
    public void inserir(Asteroide asteroide);
}