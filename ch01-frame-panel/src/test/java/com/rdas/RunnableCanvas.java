package com.rdas;

import javax.swing.*;
import java.awt.*;

/**
 * Created by rdas on 17/01/2015.
 */
public class RunnableCanvas extends Canvas implements Runnable {

    public static final int WIDTH = 320;
    public static final int HEIGHT = WIDTH / 12 * 9;
    public static final int SCALE = 2;
    public static final String title = "RunnableCanvas";

    private boolean running = false;
    private Thread thread;

    public static void main(String[] args) {
        RunnableCanvas game = new RunnableCanvas();

        game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

        JFrame frame = new JFrame(game.title);
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        game.start();
    }

    private synchronized void start() {
        if (running)
            return;

        running = true;
        thread = new Thread(this); // associate this class to the thread.
        thread.start();

    }

    private synchronized void stop() {
        if (!running)
            return;

        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.exit(1);
    }

    @Override
    public void run() {
        while (running) {
            // game loop
            System.out.println("in RUN!");
        }
        stop();
    }

}
