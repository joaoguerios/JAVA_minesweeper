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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Tabuleiro extends JPanel {
    private int linhas;
    private int colunas;
    private int minas;
    private Celula[][] celulas;

    public Tabuleiro(int linhas, int colunas, int minas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.minas = minas;
        setLayout(new GridLayout(linhas, colunas));
        inicializarTabuleiro();
        sortearMinas();
        calcularNumeros();
    }

    private void inicializarTabuleiro() {
        celulas = new Celula[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                celulas[i][j] = new Celula();
                add(celulas[i][j]);
                int finalI = i;
                int finalJ = j;
                celulas[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (SwingUtilities.isRightMouseButton(e)) {
                            celulas[finalI][finalJ].marcar();
                        } else {
                            celulas[finalI][finalJ].revelar();
                            if (celulas[finalI][finalJ].temMina()) {
                                JOptionPane.showMessageDialog(Tabuleiro.this, "Você perdeu!");
                                reiniciarJogo();
                            }
                        }
                    }
                });
            }
        }
    }

    private void sortearMinas() {
        Random random = new Random();
        int minasSorteadas = 0;
        while (minasSorteadas < minas) {
            int i = random.nextInt(linhas);
            int j = random.nextInt(colunas);
            if (!celulas[i][j].temMina()) {
                celulas[i][j].colocarMina();
                minasSorteadas++;
            }
        }
    }

    private void calcularNumeros() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (!celulas[i][j].temMina()) {
                    int minasAoRedor = contarMinasAoRedor(i, j);
                    celulas[i][j].setNumero(minasAoRedor);
                }
            }
        }
    }

    private int contarMinasAoRedor(int linha, int coluna) {
        int minasAoRedor = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int novaLinha = linha + i;
                int novaColuna = coluna + j;
                if (novaLinha >= 0 && novaLinha < linhas && novaColuna >= 0 && novaColuna < colunas && celulas[novaLinha][novaColuna].temMina()) {
                    minasAoRedor++;
                }
            }
        }
        return minasAoRedor;
    }

    private void reiniciarJogo() {
        removeAll();
        inicializarTabuleiro();
        sortearMinas();
        calcularNumeros();
        revalidate();
        repaint();
    }
}
