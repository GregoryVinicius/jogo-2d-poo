package br.ifpr.jogo.modelo;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.swing.ImageIcon;

@Entity
@Table(name = "tb_tiro")
public class Tiro extends ElementoGrafico{
    private static final int VELOCIDADE = 10;

    @ManyToOne
    @JoinColumn(name = "fk_personagem")
    private Personagem personagem;

    public Tiro(int posicaoPersonagemEmX, int posicaoPersonagemEmY){
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

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }
}