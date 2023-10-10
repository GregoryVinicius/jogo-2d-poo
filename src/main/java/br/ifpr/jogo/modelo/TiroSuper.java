package br.ifpr.jogo.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.swing.ImageIcon;

@Entity
@Table(name = "tb_tiro_super")
public class TiroSuper extends ElementoGrafico{
    private static final int VELOCIDADE = 5;

    public TiroSuper(int posicaoPersonagemEmX, int posicaoPersonagemEmY){
        setPosicaoEmX(posicaoPersonagemEmX);
        setPosicaoEmY(posicaoPersonagemEmY);
    }

    public void carregar(){
        ImageIcon carregando = new ImageIcon(getClass().getResource("/tiroSuper.png"));
        super.imagem = carregando.getImage();
        this.alturaImagem = this.imagem.getWidth(null);
        this.larguraImagem = this.imagem.getHeight(null);
    }

    
    public void atualizar(){
        this.posicaoEmX = this.posicaoEmX + VELOCIDADE;
    }
}