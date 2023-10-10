package br.ifpr.jogo.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.swing.ImageIcon;

@Entity
@Table(name = "tb_inimigo")
public class Inimigo extends ElementoGrafico{
    private static final int VELOCIDADE = 5;
    
    public Inimigo(int xAleatior, int yAleatorio){
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