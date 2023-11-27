package br.ifpr.jogo.principal;

import javax.swing.JFrame;

import org.hibernate.Session;

import br.ifpr.jogo.conexao.HibernateUtil;
import br.ifpr.jogo.controller.FaseController;
import br.ifpr.jogo.controller.FaseUmController;

public class Principal extends JFrame{
    public static int ALTURA_DA_JANELA = 1080; 
    public static int LARGURA_DA_JANELA = 1920;

    public Principal(){
        FaseController fase = new FaseUmController();
        super.add(fase);
        setVisible(true);
        setSize(LARGURA_DA_JANELA, ALTURA_DA_JANELA);
        setTitle("Jogo Bonzão");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public static void main(String[] args){
        Principal principal = new Principal();
        Session sessao = HibernateUtil.getSession();

    }
}