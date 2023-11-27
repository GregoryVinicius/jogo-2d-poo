package br.ifpr.jogo.modelo;

import javax.persistence.*;
import javax.swing.ImageIcon;

@Entity
@Table(name = "tb_tiro")
public class Tiro extends ElementoGrafico{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_tiro")
    private Integer idtiro;

    @ManyToOne
    @JoinColumn(name = "fk_personagem")
    private Personagem personagem;
}