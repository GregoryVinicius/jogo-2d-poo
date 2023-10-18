package br.ifpr.jogo.teste.hibernate;

import br.ifpr.jogo.conexao.HibernateUtil;
import br.ifpr.jogo.modelo.Jogador;
import org.hibernate.Session;

public class TesteHibernate {
    public static void main(String[] args) {
        Session sessao = HibernateUtil.getSession();
        sessao.beginTransaction();
        Jogador local = new Jogador("Joãozinho");
        sessao.save(local);
        sessao.getTransaction().commit();
        HibernateUtil.encerraSession();
    }
}