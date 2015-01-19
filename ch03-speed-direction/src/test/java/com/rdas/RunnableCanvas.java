package com.rdas;

import java.awt.*;

import javax.swing.*;

/**
 * Created by rdas on 17/01/2015.
 *
 */
public class RunnableCanvas extends Canvas implements Runnable {

    public static final int WIDTH = 320;
    public static final int HEIGHT = WIDTH / 12 * 9;
    public static final int SCALE = 2;
    public static final String title = "RunnableCanvas - Ch 03";

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

//        Graphics2D g2d = (Graphics2D) game.getGraphics();
//        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        game.getGraphics().fillOval(0,0, 30, 30);

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
