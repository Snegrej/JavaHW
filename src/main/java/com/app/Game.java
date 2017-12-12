package com.app;

import java.awt.BorderLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;


public class Game extends JFrame {

    private JLabel statusbar;

    public Game() throws InterruptedException {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setSize(250, 290);
        setSize(465,505);
        setLocationRelativeTo(null);
        setTitle("Mine Runner");

        statusbar = new JLabel("");
        add(statusbar, BorderLayout.SOUTH);

        add(new MineRunner(statusbar));

        setResizable(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame ex;
                try {
                    ex = new Game();
                    ex.setVisible(true);
                } catch (InterruptedException ex1) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex1);
                }

            }
        });
    }
}
