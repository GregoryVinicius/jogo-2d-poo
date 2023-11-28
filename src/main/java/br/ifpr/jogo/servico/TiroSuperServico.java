package br.ifpr.jogo.servico;

import br.ifpr.jogo.dao.TiroSuperDao;
import br.ifpr.jogo.daoimpl.TiroSuperDaoImpl;
import br.ifpr.jogo.modelo.TiroSuper;

import java.util.List;

public class TiroSuperServico {
    private static TiroSuperDao dao = new TiroSuperDaoImpl();

    public static List<TiroSuper> buscarTodos() {
        return dao.buscarTodos();
    }

    public static TiroSuper buscarPorId(Integer id) {
        return dao.buscarPorId(id);
    }

    public static void inserir(TiroSuper tiroSuper) {
        dao.inserir(tiroSuper);
    }

    public static void atualizar(TiroSuper tiroSuper) {
        dao.atualizar(tiroSuper);
    }

    public static void excluir(TiroSuper tiroSuper) {
        dao.excluir(tiroSuper);
    }
}
