package br.ifpr.jogo.servico;

import java.util.List;
import br.ifpr.jogo.dao.ElementoGraficoDao;
import br.ifpr.jogo.daoimpl.ElementoGraficoDaoImpl;
import br.ifpr.jogo.modelo.ElementoGrafico;

public class ElementoGraficoServico {
        private static ElementoGraficoDao dao = new ElementoGraficoDaoImpl();

    public static List<ElementoGrafico> buscarTodos() {
        return dao.buscarTodos();
    }

    public static ElementoGrafico buscarPorId(Integer id) {
        return dao.buscarPorId(id);
    }

    public static void inserir(ElementoGrafico elementoGrafico) {
        dao.inserir(elementoGrafico);
    }

    public static void atualizar(ElementoGrafico elementoGrafico) {
        dao.atualizar(elementoGrafico);
    }

    public static void excluir(ElementoGrafico elementoGrafico) {
        dao.excluir(elementoGrafico);
    }
}
