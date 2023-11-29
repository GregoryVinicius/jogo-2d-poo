package br.ifpr.jogo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ElementoGrafico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_elemento_grafico")
    protected Integer idElementoGrafico;

    @Column(name = "posicao_em_x")
    protected int posicaoEmX;

    @Column(name = "posicao_em_y")
    protected int posicaoEmY;

    @Column(name = "eh_visivel")
    private boolean ehVisivel = true;

    public Integer getIdElementoGrafico() {
        return idElementoGrafico;
    }

    public void setIdElementoGrafico(Integer idElementoGrafico) {
        this.idElementoGrafico = idElementoGrafico;
    }

    public int getPosicaoEmX() {
        return posicaoEmX;
    }

    public void setPosicaoEmX(int posicaoEmX) {
        this.posicaoEmX = posicaoEmX;
    }

    public int getPosicaoEmY() {
        return posicaoEmY;
    }

    public void setPosicaoEmY(int posicaoEmY) {
        this.posicaoEmY = posicaoEmY;
    }

    public boolean isEhVisivel() {
        return ehVisivel;
    }

    public void setEhVisivel(boolean ehVisivel) {
        this.ehVisivel = ehVisivel;
    }
}