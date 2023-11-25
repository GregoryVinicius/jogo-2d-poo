package br.ifpr.jogo.dao;

import java.util.List;
import br.ifpr.jogo.modelo.Jogador;
import br.ifpr.jogo.modelo.Tiro;
import br.ifpr.jogo.modelo.TiroSuper;

public interface TiroDao{
    public List<Tiro> buscarTodos();
    public Tiro buscarPorId(Integer id);
    public void atualizar(Tiro tiro);
    public void excluir(Tiro tiro);
    public void inserir(Tiro tiro);
}