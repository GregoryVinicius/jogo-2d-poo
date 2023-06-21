package br.ifpr.jogo.modelo;

public class Tiro {
    private int posicaoEmX;
    private int posicaoEmY;
    private Image image;
    private int larguraImagem;
    private int alturaImagem;
    private static int VELOCIDADE = 2;

    public Tiro(int posicaoPersonagemEmX, int posicaoPersonagemEmY){
        this.posicaoEmX = posicaoPersonagemEmX;
        this.posicaoEmX = posicaoPersonagemEmY;
    }
}
