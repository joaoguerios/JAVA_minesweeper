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

public class Celula extends JButton {
    private boolean temMina;
    private boolean marcada;
    private boolean revelada;
    private int numero;

    private static final ImageIcon ICON_MINA = new ImageIcon(Celula.class.getResource("/campominado/mina.png"));
    private static final ImageIcon ICON_BANDEIRA = new ImageIcon(Celula.class.getResource("/campominado/bandeira.png"));
    private static final ImageIcon ICON_MINA_EXPLODIDA = new ImageIcon(Celula.class.getResource("/campominado/mina_explodida.png"));

    
    public Celula() {
        super();
        temMina = false;
        marcada = false;
        revelada = false;
        numero = 0;
        setBackground(Color.LIGHT_GRAY);
    }

    public boolean temMina() {
        return temMina;
    }

    public void colocarMina() {
        temMina = true;
    }

    public void marcar() {
        if (!revelada) {
            marcada = !marcada;
            if (marcada) {
                setIcon(ICON_BANDEIRA);
            } else {
                setIcon(null);
                setText("");
            }
        }
    }

    public void revelar() {
        if (!marcada) {
            revelada = true;
            setBackground(Color.WHITE);
            if (temMina) {
                setIcon(ICON_MINA_EXPLODIDA);
            } else if (numero > 0) {
                setText(String.valueOf(numero));
                setForeground(getNumberColor(numero));
            }
        }
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    private Color getNumberColor(int numero) {
        switch (numero) {
            case 1: return Color.BLUE;
            case 2: return Color.GREEN;
            case 3: return Color.RED;
            case 4: return new Color(0, 0, 128); // Dark Blue
            case 5: return new Color(128, 0, 0); // Dark Red
            case 6: return new Color(0, 128, 128); // Teal
            case 7: return Color.BLACK;
            case 8: return Color.GRAY;
            default: return Color.BLACK;
        }
    }
}
