package br.ifpr.jogo.dao.impl;

import java.util.List;
import br.ifpr.jogo.dao.ElementoGraficoDao;
import br.ifpr.jogo.modelo.ElementoGrafico;
import org.hibernate.Session;
import org.hibernate.query.Query;
import br.ifpr.jogo.conexao.HibernateUtil;

public class ElementoGraficoDaoImpl implements ElementoGraficoDao{
    private Session sessao;

    public ElementoGraficoDaoImpl() {this.sessao = HibernateUtil.getSession();}

    @Override
    public List<ElementoGrafico> buscarTodos() {
        Query<ElementoGrafico> query = this.sessao.createQuery("from ElementoGrafico", ElementoGrafico.class);
        List<ElementoGrafico> elementoGraficos = query.getResultList();
        return elementoGraficos;
    }

    @Override
    public ElementoGrafico buscarPorId(Integer id) {
        return this.sessao.find(ElementoGrafico.class, id);
    }

    @Override
    public void inserir(ElementoGrafico elementoGrafico) {
        try {
            sessao.beginTransaction();
            sessao.persist(elementoGrafico);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(ElementoGrafico elementoGrafico) {
        try {
            sessao.beginTransaction();
            sessao.merge(elementoGrafico);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(ElementoGrafico elementoGrafico) {
        try {
            sessao.beginTransaction();
            sessao.remove(elementoGrafico);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}