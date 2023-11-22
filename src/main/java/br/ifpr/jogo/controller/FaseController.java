
package br.ifpr.jogo.controller;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

import br.ifpr.jogo.modelo.Asteroide;
import br.ifpr.jogo.modelo.Inimigo;
import br.ifpr.jogo.modelo.Vida;

public abstract class FaseController extends JPanel implements ActionListener, KeyListener {
    public static final int DELAY = 5;
    public static final int LARGURA_DA_JANELA = 1920;
    public static final int QTDE_DE_INIMIGOS = 50;
    public static final int QTDE_DE_ASTEROIDES = 10;
    public static final int PONTOS_POR_INIMIGO = 10;
    public static final int QTDE_DE_VIDAS = 3;

    protected Image fundo;
    protected PersonagemController personagemController;
    protected ArrayList<Inimigo> inimigos;
    protected ArrayList<Asteroide> asteroides;
    protected ArrayList<Vida> vidas;
    protected Timer timer;
    protected boolean emJogo = true;



    public FaseController() {
        setFocusable(true);
        setDoubleBuffered(true); 
        addKeyListener(this); 
    }

    public abstract void verificarColisoes();

    public abstract void inicializaInimigos();

    // public abstract void inicializaVidas();
    
    public abstract void inicializaElementosGraficosAdicionais();
    
    public abstract void desenhaPontuacao(Graphics2D graficos);

    public abstract void desenhaVidas(Graphics2D graficos);
}