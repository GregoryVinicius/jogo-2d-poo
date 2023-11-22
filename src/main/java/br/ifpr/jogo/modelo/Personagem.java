package br.ifpr.jogo.modelo;

import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_personagem")
public class Personagem{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_personagem")
    private Integer idPersonagem;

    @Column(name="deslocamento_em_x")
    private int deslocamentoEmX;
    
    @Column(name="deslocamento_em_y")
    private int deslocamentoEmY;

    @Column(name="pontuação")
    private int pontuacao;
    
    @OneToMany(mappedBy = "personagem")
    private ArrayList<Tiro> tiros;
}