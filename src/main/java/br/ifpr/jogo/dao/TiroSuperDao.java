package br.ifpr.jogo.dao;

import java.util.List;
import br.ifpr.jogo.modelo.TiroSuper;

public interface TiroSuperDao{
    public List<TiroSuper> buscarTodos();
    public TiroSuper buscarPorId(Integer id);
    public void atualizar(TiroSuper tiroSuper);
    public void excluir(TiroSuper tiroSuper);
    public void inserir(TiroSuper tiroSuper);
}