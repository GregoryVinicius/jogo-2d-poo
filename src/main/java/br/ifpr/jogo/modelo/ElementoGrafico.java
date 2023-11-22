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
}