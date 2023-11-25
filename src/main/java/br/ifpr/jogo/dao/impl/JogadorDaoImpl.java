package br.ifpr.jogo.dao.impl;

import java.util.List;

import br.ifpr.jogo.dao.JogadorDao;
import org.hibernate.Session;
import org.hibernate.query.Query;
import br.ifpr.jogo.conexao.HibernateUtil;
import br.ifpr.jogo.modelo.Jogador;

public class JogadorDaoImpl implements JogadorDao {
    private Session sessao;

    public JogadorDaoImpl() {
        this.sessao = HibernateUtil.getSession();
    }

    @Override
    public List<Jogador> buscarTodos() {
        Query<Jogador> query = this.sessao.createQuery("from Jogador", Jogador.class);
        List<Jogador> jogadores = query.getResultList();
        return jogadores;
    }

    @Override
    public Jogador buscarPorId(Integer id) {
        return this.sessao.find(Jogador.class, id);
    }

    @Override
    public void inserir(Jogador jogador) {
        try {
            sessao.beginTransaction();
            sessao.persist(jogador);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Jogador jogador) {
        try {
            sessao.beginTransaction();
            sessao.merge(jogador);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(Jogador jogador) {
        try {
            sessao.beginTransaction();
            sessao.remove(jogador);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}