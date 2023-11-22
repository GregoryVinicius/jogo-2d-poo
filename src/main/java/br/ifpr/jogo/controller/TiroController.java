package br.ifpr.jogo.controller;

import br.ifpr.jogo.controller.PersonagemController;
import br.ifpr.jogo.modelo.Personagem;

import javax.swing.*;

public class TiroController extends ElementoGraficoController{
    private static final int VELOCIDADE = 10;
    public TiroController(int posicaoPersonagemEmX, int posicaoPersonagemEmY){
        setPosicaoEmX(posicaoPersonagemEmX);
        setPosicaoEmY(posicaoPersonagemEmY);
    }

    public void carregar(){
        ImageIcon carregando = new ImageIcon(getClass().getResource("/tiro.png"));
        super.imagem = carregando.getImage();
        this.alturaImagem = this.imagem.getWidth(null);
        this.larguraImagem = this.imagem.getHeight(null);
    }


    public void atualizar(){
        this.posicaoEmX = this.posicaoEmX + VELOCIDADE;
    }
}
