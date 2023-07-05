package br.ifpr.jogo.principal;

import javax.swing.JFrame;

import br.ifpr.jogo.modelo.Fase;
import br.ifpr.jogo.modelo.FaseUm;

public class Principal extends JFrame{
    public Principal(){
        Fase fase = new FaseUm();
        super.add(fase);
        setVisible(true);
        setSize(1920, 1080);
        setTitle("Jogo Bonzão");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args){
        Principal principal = new Principal(); 
    }
}
