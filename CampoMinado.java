/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package campominado;

/**
 *
 * @author joaop
 */
public class CampoMinado {
    public static void main(String[] args) {
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CampoMinadoFrame(9, 9, 10);
            }
        });
    }
}
