
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

    protected Image fundo;
    protected Personagem personagem;
    protected ArrayList<Inimigo> inimigos;
    protected Timer timer;
    protected boolean emJogo = true;

    public Fase() {
        setFocusable(true); // + define o foco inicial do jogo
        setDoubleBuffered(true); // + Otimização computacional
        addKeyListener(this); // + Definindo que a própria classe irá controlar os eventos do teclado
    }

    public abstract void verificarColisoes();

    public abstract void inicializaInimigos();
}