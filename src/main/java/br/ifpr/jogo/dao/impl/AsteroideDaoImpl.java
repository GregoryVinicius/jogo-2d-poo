package br.ifpr.jogo.dao.impl;

import java.util.List;
import br.ifpr.jogo.dao.AsteroideDao;
import br.ifpr.jogo.modelo.Asteroide;
import org.hibernate.Session;
import org.hibernate.query.Query;
import br.ifpr.jogo.conexao.HibernateUtil;

public class AsteroideDaoImpl implements AsteroideDao {
    private Session sessao;

    public AsteroideDaoImpl() {
        this.sessao = HibernateUtil.getSession();
    }

    @Override
    public List<Asteroide> buscarTodos() {
        Query<Asteroide> query = this.sessao.createQuery("from Asteroide", Asteroide.class);
        List<Asteroide> asteroide = query.getResultList();
        return asteroide;
    }

    @Override
    public Asteroide buscarPorId(Integer id) {
        return this.sessao.find(Asteroide.class, id);
    }

    @Override
    public void inserir(Asteroide asteroide) {
        try {
            sessao.beginTransaction();
            sessao.persist(asteroide);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Asteroide asteroide) {
        try {
            sessao.beginTransaction();
            sessao.merge(asteroide);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(Asteroide asteroide) {
        try {
            sessao.beginTransaction();
            sessao.remove(asteroide);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}