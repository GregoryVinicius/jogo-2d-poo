package br.ifpr.jogo.dao;

import java.util.List;

import br.ifpr.jogo.modelo.ElementoGrafico;
import br.ifpr.jogo.modelo.Jogador;

public interface ElementoGraficoDao{
    public List<ElementoGrafico> buscarTodos();
    public ElementoGrafico buscarPorId(Integer id);
    public void atualizar(ElementoGrafico elementoGrafico);
    public void excluir(ElementoGrafico elementoGrafico);
    public void inserir(ElementoGrafico elementoGrafico);
}