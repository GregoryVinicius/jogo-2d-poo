package br.ifpr.jogo.modelo;

import br.ifpr.jogo.controller.TiroController;
import br.ifpr.jogo.controller.TiroSuperController;

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

    @Column(name="pontuação")
    private int pontuacao;

    @OneToMany(mappedBy = "tiros")
    private ArrayList<Tiro> tiros;

    @OneToMany(mappedBy = "tiro_supers")
    private ArrayList<TiroSuperController> tiroSupers;

    @OneToMany(mappedBy = "vidas")
    private int vidas = 3;

    @Column(name = "ativar_super")
    private int ativarSuperTiro = 0;

}