package br.ifpr.jogo.controller;

import javax.swing.*;

public class InimigoController extends ElementoGraficoController{
    private static final int VELOCIDADE = 5;

    public InimigoController(int xAleatior, int yAleatorio){
        super.setPosicaoEmX(xAleatior);
        super.setPosicaoEmY(yAleatorio);
    }

    public void carregar(){
        ImageIcon carregando = new ImageIcon(getClass().getResource("/inimigo.png"));
        super.imagem = carregando.getImage();
        this.larguraImagem = this.imagem.getWidth(null);
        this.alturaImagem = this.imagem.getHeight(null);
    }

    public void atualizar(){
        this.posicaoEmX = this.posicaoEmX - VELOCIDADE;
    }
}
