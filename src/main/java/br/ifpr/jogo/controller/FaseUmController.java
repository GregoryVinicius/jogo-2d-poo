package br.ifpr.jogo.controller;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import br.ifpr.jogo.principal.Principal;

public class FaseUmController extends FaseController {

    PersonagemController personagemController = new PersonagemController();

    public FaseUmController() { 
        super(); 
        ImageIcon carregando = new ImageIcon(getClass().getResource("/fundo.png"));
        fundo = carregando.getImage();


        personagemController.carregar();

        this.inicializaElementosGraficosAdicionais();

        this.inicializaInimigos();

        timer = new Timer(DELAY, this); 
        timer.start(); 
    }
    
    @Override
    public void inicializaInimigos() {
        inimigos = new ArrayList<InimigoController>();

        for (int i = 0; i < QTDE_DE_INIMIGOS; i++) {
            int x = (int) (Math.random() * 8000 + 1024);
            int y = (int) (Math.random() * 650 + 30);
            InimigoController inimigo = new InimigoController(x, y);
            inimigos.add(inimigo);
        }
    }

    @Override
    public void desenhaPontuacao(Graphics2D graficos) {
        String textoPontuacao = "PONTOS: " + personagemController.getPontuacao();
        graficos.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 22));
        graficos.setColor(new java.awt.Color(255, 255, 255));
        graficos.drawString(textoPontuacao, 20, 25);
    }

    @Override
    public void desenhaVidas(Graphics2D graficos){
        String textoVidas = "VIDAS: " + personagemController.getVidas();
        graficos.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 22));
        graficos.setColor(new java.awt.Color(255, 255, 255));
        graficos.drawString(textoVidas, 20, 50);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D graficos = (Graphics2D) g;
        if(emJogo){
            graficos.drawImage(fundo, 0, 0, null);
            for (AsteroideController asteroide : asteroides) {

                graficos.drawImage(asteroide.getImagem(), asteroide.getPosicaoEmX(), asteroide.getPosicaoEmY(), this);
            }
            
            for (InimigoController inimigo : inimigos) {
                inimigo.carregar();
                graficos.drawImage(inimigo.getImagem(), inimigo.getPosicaoEmX(), inimigo.getPosicaoEmY(), this);
            }

            ArrayList<TiroController> tiros = personagemController.getTiros();
            for (TiroController tiro : tiros) {
                tiro.carregar();
                graficos.drawImage(tiro.getImagem(), tiro.getPosicaoEmX(), tiro.getPosicaoEmY(), this);
            }
            
            ArrayList<TiroSuperController> tirosSupers = personagemController.getTiroSupers();
            for (TiroSuperController tiroSuper : tirosSupers) {
                tiroSuper.carregar();
                graficos.drawImage(tiroSuper.getImagem(), tiroSuper.getPosicaoEmX(), tiroSuper.getPosicaoEmY(), this);
            }

            graficos.drawImage(personagemController.getImagem(), personagemController.getPosicaoEmX(), personagemController.getPosicaoEmY(), this);

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
        Rectangle formaPersonagem = this.personagemController.getRectangle();
        for(int i = 0; i < this.inimigos.size(); i++){
            InimigoController inimigo = inimigos.get(i);
            Rectangle formaInimigo = inimigo.getRectangle();
            if(formaInimigo.intersects(formaPersonagem) && personagemController.getVidas() == 0){
                this.personagemController.setEhVisivel(false);
                inimigo.setEhVisivel(false);
                emJogo = false;
            }else if(formaInimigo.intersects(formaPersonagem) && personagemController.getVidas() > 0){
                inimigo.setEhVisivel(false);
                personagemController.setVidas(personagemController.getVidas() - 1);
            }
            ArrayList<TiroController> tiros = this.personagemController.getTiros();
            for(int j = 0; j < tiros.size(); j++){
                TiroController tiro = tiros.get(j);
                Rectangle formaTiro = tiro.getRectangle();
                if(formaInimigo.intersects(formaTiro)){
                    inimigo.setEhVisivel(false);
                    tiro.setEhVisivel(false);
                    int pontuacaoAtual = this.personagemController.getPontuacao();
                    this.personagemController.setPontuacao(pontuacaoAtual + PONTOS_POR_INIMIGO);
                }
                
            }
            ArrayList<TiroSuperController> tirosSupers = this.personagemController.getTiroSupers();
            for(int j = 0; j < tirosSupers.size(); j++){
                TiroSuperController tiroSuper = tirosSupers.get(j);
                Rectangle formaTiroSuper = tiroSuper.getRectangle();
                if(formaInimigo.intersects(formaTiroSuper)){
                    inimigo.setEhVisivel(false);
                    int pontuacaoAtual = this.personagemController.getPontuacao();
                    this.personagemController.setPontuacao(pontuacaoAtual + PONTOS_POR_INIMIGO);
                }
            }
        }
        personagemController.colisaoParede();
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
            personagemController.atirar();
        else if(e.getKeyCode() == KeyEvent.VK_Q)
            personagemController.atirarSuper();
        else
            personagemController.mover(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        personagemController.parar(e);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        personagemController.atualizar();
        for (AsteroideController asteroide : this.asteroides) {
            asteroide.atualizar();
        }
        ArrayList<TiroController> tiros = personagemController.getTiros();
        for (int i = 0; i < tiros.size(); i++) {
            TiroController tiro = tiros.get(i);
            if (tiro.getPosicaoEmX() > LARGURA_DA_JANELA || !tiro.getEhVisivel())
                tiros.remove(tiro);
            else
                tiro.atualizar();
        }
        ArrayList<TiroSuperController> tirosSupers = personagemController.getTiroSupers();
        for (int i = 0; i < tirosSupers.size(); i++) {
            TiroSuperController tiroSuper = tirosSupers.get(i);
            if (tiroSuper.getPosicaoEmX() > LARGURA_DA_JANELA || !tiroSuper.getEhVisivel())
                tirosSupers.remove(tiroSuper);
            else
                tiroSuper.atualizar();
        }
        for (int i = 0; i < this.inimigos.size(); i++) {
            InimigoController inimigo = this.inimigos.get(i);
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
    }

    @Override
    public void inicializaElementosGraficosAdicionais() {
        super.asteroides = new ArrayList<AsteroideController>();
        for (int i = 0; i < QTDE_DE_ASTEROIDES; i++) {
            int x = (int) (Math.random() * Principal.LARGURA_DA_JANELA);
            int y = (int) (Math.random() * Principal.ALTURA_DA_JANELA);
            AsteroideController asteroide = new AsteroideController(x, y);
            super.asteroides.add(asteroide);
        }
    }
}