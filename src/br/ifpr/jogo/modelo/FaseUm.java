package br.ifpr.jogo.modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import br.ifpr.jogo.principal.Principal;

public class FaseUm extends Fase {

    public FaseUm() { 
        super(); 
        ImageIcon carregando = new ImageIcon("recursos\\fundo.png");
        fundo = carregando.getImage();

        personagem = new Personagem(3);
        personagem.carregar();

        this.inicializaElementosGraficosAdicionais();

        this.inicializaInimigos();
        timer = new Timer(DELAY, this); 
        timer.start(); 
    }

    @Override
    public void inicializaInimigos() {
        inimigos = new ArrayList<Inimigo>();

        for (int i = 0; i < QTDE_DE_INIMIGOS; i++) {
            int x = (int) (Math.random() * 8000 + 1024);
            int y = (int) (Math.random() * 650 + 30);
            Inimigo inimigo = new Inimigo(x, y);
            inimigos.add(inimigo);
        }
    }

    @Override
    public void desenhaPontuacao(Graphics2D graficos) {
        String textoPontuacao = "PONTOS: " + personagem.getPontuacao();
        graficos.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 22));
        graficos.setColor(new java.awt.Color(255, 255, 255));
        graficos.drawString(textoPontuacao, 20, 25);
    }

    @Override
    public void desenhaVidas(Graphics2D graficos){
        String textoVidas = "vidas: " + personagem.getVidas();
        graficos.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 22));
        graficos.setColor(new java.awt.Color(255, 255, 255));
        graficos.drawString(textoVidas, 20, 50);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D graficos = (Graphics2D) g;
        if(emJogo){
            graficos.drawImage(fundo, 0, 0, null);

            for (Asteroide asteroide : asteroides) {

                graficos.drawImage(asteroide.getImagem(), asteroide.getPosicaoEmX(), asteroide.getPosicaoEmY(), this);
            }

            graficos.drawImage(personagem.getImagem(), personagem.getPosicaoEmX(), personagem.getPosicaoEmY(), this);

            ArrayList<Tiro> tiros = personagem.getTiros();

            for (Tiro tiro : tiros) {
                tiro.carregar();
                graficos.drawImage(tiro.getImagem(), tiro.getPosicaoEmX(), tiro.getPosicaoEmY(), this);
            }

            for (Inimigo inimigo : inimigos) {
                inimigo.carregar();
                graficos.drawImage(inimigo.getImagem(), inimigo.getPosicaoEmX(), inimigo.getPosicaoEmY(), this);
            }
            
            desenhaPontuacao(graficos);

            desenhaVidas(graficos);
        }else{
            ImageIcon fimDeJogo = new ImageIcon("recursos\\fimdejogo.jpg");
            graficos.drawImage(fimDeJogo.getImage(), 600, 200, null);
        }

        g.dispose();
    }

    @Override
    public void verificarColisoes(){
        Rectangle formaPersonagem = this.personagem.getRectangle();
        for(int i = 0; i < this.inimigos.size(); i++){
            Inimigo inimigo = inimigos.get(i);
            Rectangle formaInimigo = inimigo.getRectangle();
            if(formaInimigo.intersects(formaPersonagem) && personagem.getVidas() == 0){
                this.personagem.setEhVisivel(false);
                inimigo.setEhVisivel(false);
                emJogo = false;
            }else if(formaInimigo.intersects(formaPersonagem) && personagem.getVidas() > 0){
                inimigo.setEhVisivel(false);
                personagem.setVidas(personagem.getVidas() - 1);
            }
            ArrayList<Tiro> tiros = this.personagem.getTiros();
            for(int j = 0; j < tiros.size(); j++){
                Tiro tiro = tiros.get(j);
                Rectangle formaTiro = tiro.getRectangle();
                if(formaInimigo.intersects(formaTiro)){
                    inimigo.setEhVisivel(false);
                    tiro.setEhVisivel(false);
                    int pontuacaoAtual = this.personagem.getPontuacao();
                    this.personagem.setPontuacao(pontuacaoAtual + PONTOS_POR_INIMIGO);
                }

            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
            personagem.atirar();
        else
            personagem.mover(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        personagem.parar(e);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        personagem.atualizar();
        for (Asteroide asteroide : this.asteroides) {
            asteroide.atualizar();
        }
        ArrayList<Tiro> tiros = personagem.getTiros();
        for (int i = 0; i < tiros.size(); i++) {
            Tiro tiro = tiros.get(i);
            if (tiro.getPosicaoEmX() > LARGURA_DA_JANELA || !tiro.getEhVisivel())
                tiros.remove(tiro);
            else
                tiro.atualizar();
        }
        for (int i = 0; i < this.inimigos.size(); i++) {
            Inimigo inimigo = this.inimigos.get(i);
            if (inimigo.getPosicaoEmX() < 0 || !inimigo.getEhVisivel())
                inimigos.remove(inimigo);
            else
                inimigo.atualizar();
        }
        this.verificarColisoes();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void inicializaElementosGraficosAdicionais() {
        super.asteroides = new ArrayList<Asteroide>();
        for (int i = 0; i < QTDE_DE_ASTEROIDES; i++) {
            int x = (int) (Math.random() * Principal.LARGURA_DA_JANELA);
            int y = (int) (Math.random() * Principal.ALTURA_DA_JANELA);
            Asteroide asteroide = new Asteroide(x, y);
            super.asteroides.add(asteroide);
        }
    }
}