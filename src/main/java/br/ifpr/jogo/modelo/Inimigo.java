package br.ifpr.jogo.modelo;

import javax.persistence.*;
import javax.swing.ImageIcon;

@Entity
@Table(name = "tb_inimigo")
public class Inimigo{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_inimigo")
    private Integer idinimigo;

}