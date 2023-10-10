package br.ifpr.jogo.modelo;

import java.awt.Image;
import java.awt.Rectangle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ElementoGrafico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_elemento_gragico")
    protected Integer id_elemento_gragico;

    @Column(name = "posicao_em_x")
    protected int posicaoEmX;

    @Column(name = "posicao_em_y")
    protected int posicaoEmY;
    
    @Column(name = "largura_imagem")
    protected int larguraImagem;
    
    @Column(name = "altura_imagem")
    protected int alturaImagem;

    @Column(name = "eh_visivel")
    private boolean ehVisivel = true;

    protected Image imagem;

    public abstract void carregar();

    public abstract void atualizar();

    public boolean isEhVisivel() {
        return this.ehVisivel;
    }

    public boolean getEhVisivel() {
        return this.ehVisivel;
    }

    public void setEhVisivel(boolean ehVisivel) {
        this.ehVisivel = ehVisivel;
    }

    public Rectangle getRectangle(){
        return new Rectangle(posicaoEmX, posicaoEmY, larguraImagem, alturaImagem);
    }

    public int getPosicaoEmX() {
        return this.posicaoEmX;
    }

    public void setPosicaoEmX(int posicaoEmx) {
        this.posicaoEmX = posicaoEmx;
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