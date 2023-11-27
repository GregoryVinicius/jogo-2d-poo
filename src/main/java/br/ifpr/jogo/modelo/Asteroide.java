package br.ifpr.jogo.modelo;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.swing.ImageIcon;

import br.ifpr.jogo.controller.ElementoGraficoController;
import br.ifpr.jogo.principal.Principal;

@Entity
@Table(name = "tb_asteroid")
public class Asteroide extends ElementoGrafico {

    @ManyToOne
    @JoinColumn(name = "fk_elementoGrafico")
    private ElementoGrafico elementoGrafico;
}