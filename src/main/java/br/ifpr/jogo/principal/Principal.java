package br.ifpr.jogo.principal;

import javax.swing.JFrame;
import br.ifpr.jogo.modelo.Fase;
import br.ifpr.jogo.modelo.FaseUm;

public class Principal extends JFrame{
    public static int ALTURA_DA_JANELA = 1080; 
    public static int LARGURA_DA_JANELA = 1920;

    public Principal(){
        Fase fase = new FaseUm();
        super.add(fase);
        setVisible(true);
        setSize(LARGURA_DA_JANELA, ALTURA_DA_JANELA);
        setTitle("Jogo Bonzão");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args){
        Principal principal = new Principal();
    }
}