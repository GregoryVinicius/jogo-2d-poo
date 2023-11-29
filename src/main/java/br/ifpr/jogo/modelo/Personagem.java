package br.ifpr.jogo.modelo;

import br.ifpr.jogo.controller.TiroSuperController;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_personagem")
public class Personagem extends ElementoGrafico{
    @Column(name="pontuação")
    private int pontuacao;

    @OneToMany
    @JoinColumn(name = "fk_personagem")
    private List<Tiro> tiros;

    @OneToMany
    @JoinColumn(name = "fk_personagem")
    private List<TiroSuper> tiroSupers;

    @Column(name = "vidas")
    private int vidas = 3;

    @Column(name = "ativar_super")
    private int ativarSuperTiro = 0;

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public List<Tiro> getTiros() {
        return tiros;
    }

    public void setTiros(List<Tiro> tiros) {
        this.tiros = tiros;
    }

    public List<TiroSuper> getTiroSupers() {
        return tiroSupers;
    }

    public void setTiroSupers(List<TiroSuper> tiroSupers) {
        this.tiroSupers = tiroSupers;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public int getAtivarSuperTiro() {
        return ativarSuperTiro;
    }

    public void setAtivarSuperTiro(int ativarSuperTiro) {
        this.ativarSuperTiro = ativarSuperTiro;
    }
}