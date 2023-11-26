package br.ifpr.jogo.controller;

import javax.swing.*;

public class TiroSuperController extends ElementoGraficoController{
    private static final int VELOCIDADE = 20;

    public TiroSuperController(int posicaoPersonagemEmX, int posicaoPersonagemEmY){
        setPosicaoEmX(posicaoPersonagemEmX);
        setPosicaoEmY(posicaoPersonagemEmY);
    }

    public void carregar(){
        ImageIcon carregando = new ImageIcon(getClass().getResource("/tiroSuper.gif"));
        super.imagem = carregando.getImage();
        this.alturaImagem = this.imagem.getWidth(null);
        this.larguraImagem = this.imagem.getHeight(null);
    }

    public void atualizar(){
        this.posicaoEmX = this.posicaoEmX + VELOCIDADE;
    }
}