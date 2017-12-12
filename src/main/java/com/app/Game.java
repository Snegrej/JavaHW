package com.app;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;


public class Game extends JFrame {

    private JLabel statusbar;

    public Game() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setSize(250, 290);
        setSize(450,490);
        setLocationRelativeTo(null);
        setTitle("Snake");

        statusbar = new JLabel("");
        add(statusbar, BorderLayout.SOUTH);

        add(new Snake(statusbar));

        setResizable(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame ex = new Game();
                ex.setVisible(true);
            }
        });
    }
}
