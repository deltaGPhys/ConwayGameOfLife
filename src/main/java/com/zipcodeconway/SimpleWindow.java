package com.zipcodeconway;

import javax.swing.*;
import java.awt.*;

public class SimpleWindow {
    static JPanel panel;
    static JFrame frame;
    private Integer dim = 0;
    private Integer boxDim = 15;

    public SimpleWindow(Integer dimension) {
        this.dim = dimension * this.boxDim;
        panel = new JPanel();
        Dimension dim = new Dimension(this.dim, this.dim);
        panel.setPreferredSize(dim);
        frame = new JFrame();
        Integer framesize = (this.dim < 100) ? 100 : this.dim;
        frame.setSize(framesize, framesize);
        Container contentPane = frame.getContentPane();
        contentPane.add(panel);
        frame.setVisible(true);
    }

    public void sleep(Integer millisecs) {
        try {
            Thread.sleep(millisecs);
            Graphics g = panel.getGraphics();
            g.dispose();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void display(int[][] array, Integer n) {
        frame.setTitle(String.format("Generation: %6d", n));
        Graphics g = panel.getGraphics();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                g.drawRect(i * this.boxDim, j * this.boxDim, this.boxDim, this.boxDim);
                if (array[i][j] == 0) {
                    g.setColor(Color.WHITE);
                } else if (array[i][j] == 1) {
                    g.setColor(Color.BLACK);
                }
                g.fillRect(i * this.boxDim-1, j * this.boxDim, this.boxDim+1, this.boxDim);
            }
        }

    }
}
