package com.rdas;

import org.apache.log4j.Logger;

import java.awt.*;

import javax.swing.*;

/**
 * Created by rdas on 14/01/2015.
 */
public class Game extends JPanel {
    final static Logger logger = Logger.getLogger(Game.class);
    private int x = 0;
    private int y = 0;
    private int xa = 1;
    private int ya = 1;

    private void moveBall() {
        if (x + xa < 0)
            xa = 1;
        if (x + xa > getWidth() - 30)
            xa = -1;
        if (y + ya < 0)
            ya = 1;
        if (y + ya > getHeight() - 30)
            ya = -1;

        x = x + xa;
        y = y + ya;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.fillOval(x, y, 30, 30);

    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Mini Tennis");
        Game game = new Game();
        frame.add(game);
        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        while (true) {
            game.moveBall();
            game.repaint();
            Thread.sleep(10);
            logger.debug("while true R U N !!!");
        }
    }
}
