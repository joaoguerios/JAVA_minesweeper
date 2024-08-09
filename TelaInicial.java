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

public class TelaInicial extends JFrame {
    public TelaInicial() {
        setTitle("Campo Minado - Escolha a Dificuldade");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JButton facilButton = new JButton("Fácil");
        JButton medioButton = new JButton("Médio");
        JButton dificilButton = new JButton("Difícil");

        facilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarJogo(9, 9, 10);
            }
        });

        medioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarJogo(16, 16, 40);
            }
        });

        dificilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarJogo(30, 16, 99);
            }
        });

        panel.add(new JLabel("Selecione a Dificuldade:", SwingConstants.CENTER));
        panel.add(facilButton);
        panel.add(medioButton);
        panel.add(dificilButton);

        add(panel);

        setVisible(true);
    }

    private void iniciarJogo(int linhas, int colunas, int minas) {
        new CampoMinadoFrame(linhas, colunas, minas);
        dispose();
    }
}