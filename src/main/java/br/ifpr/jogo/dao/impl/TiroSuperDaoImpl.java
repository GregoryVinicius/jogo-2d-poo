package br.ifpr.jogo.dao.impl;

import java.util.List;

import br.ifpr.jogo.dao.TiroSuperDao;
import br.ifpr.jogo.modelo.TiroSuper;
import org.hibernate.Session;
import org.hibernate.query.Query;
import br.ifpr.jogo.conexao.HibernateUtil;

public class TiroSuperDaoImpl implements TiroSuperDao {
    private Session sessao;

    public TiroSuperDaoImpl() {
        this.sessao = HibernateUtil.getSession();
    }

    @Override
    public List<TiroSuper> buscarTodos() {
        Query<TiroSuper> query = this.sessao.createQuery("from Jogador", TiroSuper.class);
        List<TiroSuper> tiroSupers = query.getResultList();
        return tiroSupers;
    }

    @Override
    public TiroSuper buscarPorId(Integer id) {
        return this.sessao.find(TiroSuper.class, id);
    }

    @Override
    public void inserir(TiroSuper tiroSuper) {
        try {
            sessao.beginTransaction();
            sessao.persist(tiroSuper);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(TiroSuper tiroSuper) {
        try {
            sessao.beginTransaction();
            sessao.merge(tiroSuper);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(TiroSuper tiroSuper) {
        try {
            sessao.beginTransaction();
            sessao.remove(tiroSuper);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
