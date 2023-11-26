package br.ifpr.jogo.controller;

import br.ifpr.jogo.principal.Principal;

import javax.swing.*;

public class AsteroideController extends ElementoGraficoController{
    private static int VELOCIDADE = 2;

    public AsteroideController() {

    }

    public AsteroideController(int xAleatorio, int yAleatorio) {
        this.carregar();
        super.setPosicaoEmX(xAleatorio);
        super.setPosicaoEmY(yAleatorio);
    }

    public void carregar() {
        ImageIcon carregando = new ImageIcon(getClass().getResource("/asteroide.png"));
        super.setImagem(
                carregando.getImage());
    }

    @Override
    public void atualizar() {
        if (this.getPosicaoEmX() < 0) {
            int y = (int) (Math.random() * Principal.ALTURA_DA_JANELA);
            super.setPosicaoEmX(Principal.LARGURA_DA_JANELA);
            super.setPosicaoEmY(y);
        } else {
            super.setPosicaoEmX(super.getPosicaoEmX() - VELOCIDADE);
        }
    }
}