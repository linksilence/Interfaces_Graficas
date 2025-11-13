package edu.pucgoias.topicos_avancados.java_swing;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppSwingDemo app = new AppSwingDemo();
            app.setVisible(true);
        });
    }
}