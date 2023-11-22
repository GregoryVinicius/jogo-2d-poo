package br.ifpr.jogo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;

@Entity()
@Table(name = "tb_teste")
public class ModelTeste {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_teste")
    private long idTeste;

    @Column(name = "coluna_nome")
    private String colunaNome;
}
