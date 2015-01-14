package com.rdas;

import java.awt.*;
import java.awt.geom.Ellipse2D;

import javax.swing.*;

/**
 * Created by rdas on 14/01/2015.
 */
public class GameExtendPanel extends JPanel {
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        g2d.fillOval(0, 0, 30, 30);
        g2d.drawOval(0, 50, 30, 30);
        g2d.fillRect(50, 0, 30, 30);
        g2d.drawRect(50, 50, 30, 30);

        g2d.draw(new Ellipse2D.Double(0, 100, 30, 30));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mini Tennis");
        frame.add(new GameExtendPanel());
        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
