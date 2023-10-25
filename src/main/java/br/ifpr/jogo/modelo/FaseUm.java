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
        ImageIcon carregando = new ImageIcon(getClass().getResource("/fundo.png"));
        fundo = carregando.getImage();

        personagem = new Personagem();
        personagem.carregar();

        this.inicializaElementosGraficosAdicionais();

        this.inicializaInimigos();

        // this.inicializaVidas();

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

    // @Override
    // public void inicializaVidas(){
    //     vidas = new ArrayList<Vida>();

    //     for (int i = 0; i < QTDE_DE_VIDAS; i++) {
    //         int x = (int) (Math.random() * 8000 + 1024);
    //         int y = (int) (Math.random() * 650 + 30);
    //         Vida vida = new Vida(x, y);
    //         vidas.add(vida);
    //     }
    // }

    @Override
    public void desenhaPontuacao(Graphics2D graficos) {
        String textoPontuacao = "PONTOS: " + personagem.getPontuacao();
        graficos.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 22));
        graficos.setColor(new java.awt.Color(255, 255, 255));
        graficos.drawString(textoPontuacao, 20, 25);
    }

    @Override
    public void desenhaVidas(Graphics2D graficos){
        String textoVidas = "VIDAS: " + personagem.getVidas();
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

            ArrayList<Tiro> tiros = personagem.getTiros();
            for (Tiro tiro : tiros) {
                tiro.carregar();
                graficos.drawImage(tiro.getImagem(), tiro.getPosicaoEmX(), tiro.getPosicaoEmY(), this);
            }
            
            ArrayList<TiroSuper> tirosSupers = personagem.getTiroSupers();
            for (TiroSuper tiroSuper : tirosSupers) {
                tiroSuper.carregar();
                graficos.drawImage(tiroSuper.getImagem(), tiroSuper.getPosicaoEmX(), tiroSuper.getPosicaoEmY(), this);
            }
            
            for (Inimigo inimigo : inimigos) {
                inimigo.carregar();
                graficos.drawImage(inimigo.getImagem(), inimigo.getPosicaoEmX(), inimigo.getPosicaoEmY(), this);
            }
            graficos.drawImage(personagem.getImagem(), personagem.getPosicaoEmX(), personagem.getPosicaoEmY(), this);
            
            // for (Vida vida : vidas) {
            //     vida.carregar();
            //     graficos.drawImage(vida.getImagem(), vida.getPosicaoEmX(), vida.getPosicaoEmY(), this);
            // }
            desenhaPontuacao(graficos);

            desenhaVidas(graficos);
        }else{
            ImageIcon fimDeJogo = new ImageIcon(getClass().getResource("/fimDejogo.jpg"));
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
            // Vida vida = vidas.get(i);
            // Rectangle formaVida = vida.getRectangle();
            // if(formaVida.intersects(formaPersonagem)){
                //     personagem.setVidas(personagem.getVidas() + 1);
                //     vida.setEhVisivel(false);
                // }
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
            ArrayList<TiroSuper> tirosSupers = this.personagem.getTiroSupers();
            for(int j = 0; j < tirosSupers.size(); j++){
                TiroSuper tiroSuper = tirosSupers.get(j);
                Rectangle formaTiroSuper = tiroSuper.getRectangle();
                if(formaInimigo.intersects(formaTiroSuper)){
                    inimigo.setEhVisivel(false);
                    //tiroSuper.setEhVisivel(false);
                    int pontuacaoAtual = this.personagem.getPontuacao();
                    this.personagem.setPontuacao(pontuacaoAtual + PONTOS_POR_INIMIGO);
                }
                
            }
        }
        personagem.colisaoParede();
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
            personagem.atirar();
        else if(e.getKeyCode() == KeyEvent.VK_Q)
            personagem.atirarSuper();
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
        ArrayList<TiroSuper> tirosSupers = personagem.getTiroSupers();
        for (int i = 0; i < tiros.size(); i++) {
            TiroSuper tiroSuper = tirosSupers.get(i);
            if (tiroSuper.getPosicaoEmX() > LARGURA_DA_JANELA || !tiroSuper.getEhVisivel())
                tiros.remove(tiroSuper);
            else
                tiroSuper.atualizar();
        }
        for (int i = 0; i < this.inimigos.size(); i++) {
            Inimigo inimigo = this.inimigos.get(i);
            if (inimigo.getPosicaoEmX() < 0 || !inimigo.getEhVisivel())
                inimigos.remove(inimigo);
            else
                inimigo.atualizar();
        }
        // for (int i = 0; i < this.vidas.size(); i++) {
        //     Vida vida = this.vidas.get(i);
        //     if (vida.getPosicaoEmX() < 0 || !vida.getEhVisivel())
        //         vidas.remove(vida);
        //     else
        //         vida.atualizar();
        // }
        this.verificarColisoes();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

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