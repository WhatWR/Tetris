package tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel {

    public static final int BOARD_WIDTH = 10;
    public static final int BOARD_HEIGHT = 20;
    public static final int BLOCK_SITE = 30;

    private Timer looper;
    private Color[][] board = new Color[BOARD_WIDTH][BOARD_HEIGHT];

    private Color[][] shape = {
            {Color.red, Color.red, Color.red},
            {null, Color.red, null}
    };

    private int x=4, y=0;

    public Board() {
        looper = new Timer(500, new ActionListener() {
            int n = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(n++);
            }
        });
        looper.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Shape
        for (int row = 0; row < shape.length; row++) {
            for (int col = 0; col < shape[0].length; col++) {
                if (shape[row][col] != null) {
                    g.setColor(shape[row][col]);
                    g.fillRect(col * BLOCK_SITE, row * BLOCK_SITE, BLOCK_SITE, BLOCK_SITE);
                }
            }
        }

        // Board
        g.setColor(Color.white);
        for (int row = 0; row < BOARD_HEIGHT; row++) {
            g.drawLine(0, BLOCK_SITE * row, BLOCK_SITE * BOARD_WIDTH, BLOCK_SITE * row);
        }

        for (int col = 0; col < BOARD_WIDTH + 1; col++) {
            g.drawLine(col * BLOCK_SITE, 0, col * BLOCK_SITE, BLOCK_SITE * BOARD_HEIGHT);
        }


    }
}
