package br.ifpr.jogo.modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase extends JPanel implements KeyListener, ActionListener{
    private Image fundo;
    private Personagem personagem;
    private Timer timer;
    
    private static final int DELAY = 5;
    private static final int VELOCIDA_DE_DESLOCAMENTO = 3;
    private static final int LARGURA_DA_JANELA = 1920;

    public Fase(){
        this.setFocusable(true);
        this.setDoubleBuffered(true);
        ImageIcon carregando = new ImageIcon("recursos\\fundo.png");
        this.fundo = carregando.getImage();
        
        this.personagem = new Personagem(VELOCIDA_DE_DESLOCAMENTO);
        this.personagem.carregar();
        this.addKeyListener(this);

        

        this.timer = new Timer(DELAY, this);
        this.timer.start();
    }

    public void paint(Graphics g) {
    Graphics2D graficos = (Graphics2D) g;
    graficos.drawImage(fundo, 0, 0, null);
    graficos.drawImage(personagem.getImagem(), personagem.getPosicaoEmX(), personagem.getPosicaoEmY(), this);

    ArrayList<Tiro> tiros = personagem.getTiros();
    for (Tiro tiro : tiros) {
        
        tiro.carregar();

        graficos.drawImage(tiro.getImagem(), tiro.getPosicaoEmX(), tiro.getPosicaoEmY(), this);
    }

    g.dispose();
}

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE){
            personagem.atirar();
        }else{
            this.personagem.mover(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.personagem.parar(e);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.personagem.atualizar();
        
        ArrayList<Tiro> tiros = personagem.getTiros();

        for(int i = 0; i < tiros.size(); i++){
            if(tiros.get(i).getPosicaoEmX() > LARGURA_DA_JANELA){
                tiros.remove(i);
            }else{
                tiros.get(i).atualizar();
            }
        }
        repaint();
    }

}
