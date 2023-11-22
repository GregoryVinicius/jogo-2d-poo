package br.ifpr.jogo.modelo;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.swing.ImageIcon;

@Entity
@Table(name = "tb_tiro")
public class Tiro extends ElementoGrafico{
    @ManyToOne
    @JoinColumn(name = "fk_personagem")
    private Personagem personagem;
}