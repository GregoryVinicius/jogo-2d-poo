package br.ifpr.jogo.modelo;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.ImageIcon;

public class Inimigo extends ElementoGrafico{
    private static final int VELOCIDADE = 2;
    private ArrayList<Inimigo> inimigo;
    private static final int QTDE_DE_INIMIGOS = 40;

    public Inimigo(int xAleatior, int yAleatorio){
        super.setPosicaoEmX(xAleatior);
        super.setPosicaoEmY(yAleatorio);
    }

    public void carregar(){
        ImageIcon carregando = new ImageIcon("recursos\\inimigo.png");
        super.imagem = carregando.getImage();
        this.larguraImagem = this.imagem.getWidth(null);
        this.alturaImagem = this.imagem.getHeight(null);
    }

    

    public void atualizar(){
        this.posicaoEmX = this.posicaoEmX - VELOCIDADE;
    }
}