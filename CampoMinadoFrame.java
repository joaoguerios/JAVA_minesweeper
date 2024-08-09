/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campominado;
/**
 *
 * @author joaop
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CampoMinadoFrame extends JFrame {
    private Tabuleiro tabuleiro;
    private JMenuBar menuBar;
    private JMenu dificuldadesMenu,jogoMenu;
    private JMenuItem reiniciarItem, voltarMenuItem,dificuldadeFacilMenuItem,dificuldadeMediaMenuItem,dificuldadeDificilMenuItem;
    private JLabel minasRestantesLabel;
    private int linhas, colunas, minas;

    public CampoMinadoFrame(int linhas, int colunas, int minas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.minas = minas;
        setTitle("Campo Minado");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tabuleiro = new Tabuleiro(linhas, colunas, minas);
        add(tabuleiro, BorderLayout.CENTER);
        
        menuBar = new JMenuBar();
        
        jogoMenu = new JMenu("Jogo");
        dificuldadesMenu = new JMenu("Dificuldades");
        

        reiniciarItem = new JMenuItem("Reiniciar");
        reiniciarItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reiniciarJogo(linhas, colunas, minas);
            }
        });

        voltarMenuItem = new JMenuItem("Voltar ao Menu");
        voltarMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                voltarAoMenu();
            }
        });
        
        dificuldadeFacilMenuItem = new JMenuItem("Facil");
        dificuldadeFacilMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reiniciarJogo(9, 9, 10);
            }
        });
        
        dificuldadeMediaMenuItem = new JMenuItem("Media");
        dificuldadeMediaMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reiniciarJogo(16, 16, 40);
            }
        });
        
        dificuldadeDificilMenuItem = new JMenuItem("Dificil");
        dificuldadeDificilMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reiniciarJogo(30, 16, 99);
            }
        });
        
        
        
        menuBar.add(jogoMenu);
        jogoMenu.add(reiniciarItem);
        jogoMenu.add(voltarMenuItem);
        menuBar.add(dificuldadesMenu);
        dificuldadesMenu.add(dificuldadeFacilMenuItem);
        dificuldadesMenu.add(dificuldadeMediaMenuItem);
        dificuldadesMenu.add(dificuldadeDificilMenuItem);
        setJMenuBar(menuBar);

        minasRestantesLabel = new JLabel("Minas Restantes: " + minas);
        add(minasRestantesLabel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void reiniciarJogo(int linhas, int colunas, int minas) {
        remove(tabuleiro);
        tabuleiro = new Tabuleiro(linhas, colunas, minas);
        add(tabuleiro, BorderLayout.CENTER);
        minasRestantesLabel.setText("Minas Restantes: " + minas);
        revalidate();
        repaint();
    }

    private void voltarAoMenu() {
        new TelaInicial();
        dispose();
    }
}