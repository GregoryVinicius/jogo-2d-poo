package br.ifpr.jogo.servico;

import br.ifpr.jogo.dao.AsteroideDao;
import br.ifpr.jogo.daoimpl.AsteroideDaoImpl;
import br.ifpr.jogo.modelo.Asteroide;

import java.util.List;

public class AsteroideServico {
    private static AsteroideDao dao = new AsteroideDaoImpl();

    public static List<Asteroide> buscarTodos() {
        return dao.buscarTodos();
    }

    public static Asteroide buscarPorId(Integer id) {
        return dao.buscarPorId(id);
    }

    public static void inserir(Asteroide asteroide) {
        dao.inserir(asteroide);
    }

    public static void atualizar(Asteroide asteroide) {
        dao.atualizar(asteroide);
    }

    public static void excluir(Asteroide asteroide) {
        dao.excluir(asteroide);
    }
}
