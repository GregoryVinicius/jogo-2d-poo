
package br.ifpr.jogo.modelo;

import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public abstract class Fase extends JPanel implements ActionListener, KeyListener {
    public static final int DELAY = 5;
    public static final int LARGURA_DA_JANELA = 1920;
    public static final int QTDE_DE_INIMIGOS = 40;
    public static final int QTDE_DE_ASTEROIDES = 40;

    protected Image fundo;
    protected Personagem personagem;
    protected ArrayList<Inimigo> inimigos;
    protected Timer timer;
    protected boolean emJogo = true;
    protected ArrayList<Asteroide> asteroides;



    public Fase() {
        setFocusable(true);
        setDoubleBuffered(true); 
        addKeyListener(this); 
    }

    public abstract void verificarColisoes();

    public abstract void inicializaInimigos();
    
    public abstract void inicializaElementosGraficosAdicionais();
}