package com.trial.main;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;
import java.io.Serial;

public class Window extends Canvas {

    @Serial
    private static final long serialVersionUID = 987232736271526254L;

    public Window(int width, int height, String title, Game game){
        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();

    }
}
