package br.ifpr.jogo.modelo;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

import br.ifpr.jogo.principal.Principal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_personagem")
public class Personagem extends ElementoGrafico{
    private static final int DESLOCAMENTO = 8;
    private static final int POSICAO_INICIAL_EM_X = 100;
    private static final int POSICAO_INICIAL_EM_Y = 100;

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

    private ArrayList<TiroSuper> tiroSupers;
    private int vidas = 3;
    
    

    public Personagem(){
        setPosicaoEmX(POSICAO_INICIAL_EM_X);
        setPosicaoEmY(POSICAO_INICIAL_EM_Y);
        this.tiros = new ArrayList<Tiro>();
        this.tiroSupers = new ArrayList<TiroSuper>();
    }

    public void carregar(){
        ImageIcon carregando = new ImageIcon(getClass().getResource("/personagem.png"));
        super.imagem = carregando.getImage();
        this.larguraImagem = this.imagem.getWidth(null);
        this.alturaImagem = this.imagem.getHeight(null);
    }

    public void atualizar(){
        setPosicaoEmX(getPosicaoEmX() + this.deslocamentoEmX);
        setPosicaoEmY(getPosicaoEmY() + this.deslocamentoEmY);
    }

    public void atirar(){
        int frenteDaNave = getPosicaoEmX() + this.larguraImagem - 15;
        int meioDaNave = getPosicaoEmY() + (this.larguraImagem / 2) - 23;
        Tiro tiro = new Tiro(frenteDaNave, meioDaNave);
        this.tiros.add(tiro);
    }

    public void atirarSuper(){
        int frenteDaNave = getPosicaoEmX() + this.larguraImagem;
        int meioDaNave = getPosicaoEmY() + (this.larguraImagem / 2);
        TiroSuper tiroSuper = new TiroSuper(frenteDaNave, meioDaNave);
        this.tiroSupers.add(tiroSuper);
    }

    public void mover(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();
        switch (codigo) {
            case KeyEvent.VK_UP:
                this.deslocamentoEmY = -DESLOCAMENTO;
                break;
            case KeyEvent.VK_DOWN:
                this.deslocamentoEmY = DESLOCAMENTO;
                break;
            case KeyEvent.VK_LEFT:
                this.deslocamentoEmX = -DESLOCAMENTO;
                break;
            case KeyEvent.VK_RIGHT:
                this.deslocamentoEmX = DESLOCAMENTO;
                break;
            case KeyEvent.VK_W:
                this.deslocamentoEmY = -DESLOCAMENTO;
                break;
            case KeyEvent.VK_S:
                this.deslocamentoEmY = DESLOCAMENTO;
                break;
            case KeyEvent.VK_A:
                this.deslocamentoEmX = -DESLOCAMENTO;
                break;
            case KeyEvent.VK_D:
                this.deslocamentoEmX = DESLOCAMENTO;
                break;
            default:
                break;
    }
}

    public void parar(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();
        switch (codigo) {
            case KeyEvent.VK_UP:
                this.deslocamentoEmY = 0;
                break;
            case KeyEvent.VK_DOWN:
                this.deslocamentoEmY = 0;
                break;
            case KeyEvent.VK_LEFT:
                this.deslocamentoEmX = 0;
                break;
            case KeyEvent.VK_RIGHT:
                this.deslocamentoEmX = 0;
                break;
            case KeyEvent.VK_W:
                this.deslocamentoEmY = 0;
                break;
            case KeyEvent.VK_S:
                this.deslocamentoEmY = 0;
                break;
            case KeyEvent.VK_D:
                this.deslocamentoEmX = 0;
                break;
            case KeyEvent.VK_A:
                this.deslocamentoEmX = 0;
                break;
            default:
                break;
        }
    }

    public void colisaoParede(){
        Rectangle formaPersonagem = this.getRectangle();
        if(this.getPosicaoEmX() < 0){
            this.setPosicaoEmX(this.getPosicaoEmX() + 8);
        }else if(this.getPosicaoEmX() > Principal.LARGURA_DA_JANELA - this.imagem.getWidth(null) - 3){
            this.setPosicaoEmX(this.getPosicaoEmX() - 8);
        }
        if(this.getPosicaoEmY() < 0){
            this.setPosicaoEmY(this.getPosicaoEmY() + 8);
        } else if (this.getPosicaoEmY() > Principal.ALTURA_DA_JANELA - this.imagem.getHeight(null) - 60){
            this.setPosicaoEmY(this.getPosicaoEmY() - 8);
        }
    }

    public int getDeslocamentoEmX() {
        return this.deslocamentoEmX;
    }

    public void setDeslocamentoEmX(int deslocamentoEmX) {
        this.deslocamentoEmX = deslocamentoEmX;
    }

    public int getDeslocamentoEmY() {
        return this.deslocamentoEmY;
    }

    public void setDeslocamentoEmY(int deslocamentoEmY) {
        this.deslocamentoEmY = deslocamentoEmY;
    }

    public ArrayList<Tiro> getTiros() {
        return this.tiros;
    }

    public void setTiros(ArrayList<Tiro> tiros) {
        this.tiros = tiros;
    }
        public int getPontuacao() {
        return this.pontuacao;
    }

    public void setPontuacao(int pontos) {
        this.pontuacao = pontos;
    }

    public int getVidas(){
        return this.vidas;
    }

    public void setVidas(int vidas){
        this.vidas = vidas;
    }

    public Integer getIdPersonagem() {
        return idPersonagem;
    }

    public void setIdPersonagem(Integer idPersonagem) {
        this.idPersonagem = idPersonagem;
    }

    public ArrayList<TiroSuper> getTiroSupers() {
        return tiroSupers;
    }

    public void setTiroSupers(ArrayList<TiroSuper> tiroSupers) {
        this.tiroSupers = tiroSupers;
    }
}