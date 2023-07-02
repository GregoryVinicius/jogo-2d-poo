package br.ifpr.jogo.modelo;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Inimigo {
    private int posicaoEmX;
    private int posicaoEmY;
    private Image imagem;
    private int larguraImagem;
    private int alturaImagem;
    private static final int VELOCIDADE = 2;
    private ArrayList<Inimigo> inimigo;
    private static final int QTDE_DE_INIMIGOS = 40;

    public Inimigo(int xAleatior, int yAleatorio){
        this.posicaoEmX = xAleatior;
        this.posicaoEmY = yAleatorio;
    }

    public void carregar(){
        ImageIcon carregando = new ImageIcon("recursos\\inimigo.png");
        this.imagem = carregando.getImage();
        this.larguraImagem = this.imagem.getWidth(null);
        this.alturaImagem = this.imagem.getHeight(null);
    }

    public void atualizar(){
        this.posicaoEmX = this.posicaoEmX - VELOCIDADE;
    }


    public int getPosicaoEmX() {
        return this.posicaoEmX;
    }

    public void setPosicaoEmX(int posicaoEmX) {
        this.posicaoEmX = posicaoEmX;
    }

    public int getPosicaoEmY() {
        return this.posicaoEmY;
    }

    public void setPosicaoEmY(int posicaoEmY) {
        this.posicaoEmY = posicaoEmY;
    }

    public Image getImagem() {
        return this.imagem;
    }

    public void setImagem(Image imagem) {
        this.imagem = imagem;
    }

    public int getLarguraImagem() {
        return this.larguraImagem;
    }

    public void setLarguraImagem(int larguraImagem) {
        this.larguraImagem = larguraImagem;
    }

    public int getAlturaImagem() {
        return this.alturaImagem;
    }

    public void setAlturaImagem(int alturaImagem) {
        this.alturaImagem = alturaImagem;
    }

}
