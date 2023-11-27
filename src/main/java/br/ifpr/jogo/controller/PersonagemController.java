package br.ifpr.jogo.controller;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import br.ifpr.jogo.principal.Principal;

public class PersonagemController extends ElementoGraficoController{
    private final static int DESLOCAMENTO = 8;
    private final static int POSICAO_INICIAL_EM_X = 100;
    private final static int POSICAO_INICIAL_EM_Y = 100;
    private int deslocamentoEmX;
    private int deslocamentoEmY;
    private int pontuacao;
    private ArrayList<TiroController> tiros;
    private ArrayList<TiroSuperController> tiroSupers;
    private int vidas = 3;
    private int ativarSuperTiro = 0;

    public PersonagemController(){
        setPosicaoEmX(POSICAO_INICIAL_EM_X);
        setPosicaoEmY(POSICAO_INICIAL_EM_Y);
        this.tiros = new ArrayList<TiroController>();
        this.tiroSupers = new ArrayList<TiroSuperController>();
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
        TiroController tiro = new TiroController(frenteDaNave, meioDaNave);
        this.tiros.add(tiro);
        ativarSuperTiro += 1;
    }

    public void atirarSuper(){
        if(ativarSuperTiro >= 10){
            int frenteDaNave = getPosicaoEmX() + this.larguraImagem;
            int meioDaNave = getPosicaoEmY() + (this.larguraImagem / 2) - 70;
            TiroSuperController tiroSuper = new TiroSuperController(frenteDaNave, meioDaNave);
            this.tiroSupers.add(tiroSuper);
            ativarSuperTiro -= 10;
        }
    }

    public void mover(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();
        switch (codigo) {
            case KeyEvent.VK_UP, KeyEvent.VK_W:
                this.deslocamentoEmY = -DESLOCAMENTO;
                break;
            case KeyEvent.VK_DOWN, KeyEvent.VK_S:
                this.deslocamentoEmY = DESLOCAMENTO;
                break;
            case KeyEvent.VK_LEFT, KeyEvent.VK_A:
                this.deslocamentoEmX = -DESLOCAMENTO;
                break;
            case KeyEvent.VK_RIGHT, KeyEvent.VK_D:
                this.deslocamentoEmX = DESLOCAMENTO;
                break;
            default:
                break;
    }
}

    public void parar(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();
        switch (codigo) {
            case KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_W, KeyEvent.VK_S:
                this.deslocamentoEmY = 0;
                break;
            case KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_D, KeyEvent.VK_A:
                this.deslocamentoEmX = 0;
                break;
            default:
                break;
        }
    }

    public void colisaoParede(){
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

    public ArrayList<TiroController> getTiros() {
        return this.tiros;
    }

    public void setTiros(ArrayList<TiroController> tiros) {
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

    public ArrayList<TiroSuperController> getTiroSupers() {
        return tiroSupers;
    }

    public void setTiroSupers(ArrayList<TiroSuperController> tiroSupers) {
        this.tiroSupers = tiroSupers;
    }
}