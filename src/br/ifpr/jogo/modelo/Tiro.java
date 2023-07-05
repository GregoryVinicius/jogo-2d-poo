package br.ifpr.jogo.modelo;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Tiro extends ElementoGrafico{
    private static final int VELOCIDADE = 5;

    public Tiro(int posicaoPersonagemEmX, int posicaoPersonagemEmY){
        setPosicaoEmX(posicaoPersonagemEmX);
        setPosicaoEmY(posicaoPersonagemEmY);
    }

    public void carregar(){
        ImageIcon carregando = new ImageIcon("recursos\\tiro.png");
        super.imagem = carregando.getImage();
        this.alturaImagem = this.imagem.getWidth(null);
        this.larguraImagem = this.imagem.getHeight(null);
    }

    
    public void atualizar(){
        this.posicaoEmX = this.posicaoEmX + VELOCIDADE;
    }
}
