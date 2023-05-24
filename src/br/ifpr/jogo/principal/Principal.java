package br.ifpr.jogo.principal;

import javax.swing.JFrame;

public class Principal extends JFrame{
    public Principal(){
        setVisible(true);
        setSize(614, 335);
        setTitle("Jogo bom demaizi");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args){
        Principal principal = new Principal();
    }
}
