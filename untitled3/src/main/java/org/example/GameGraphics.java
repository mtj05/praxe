package org.example;

import org.example.logic.*;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;

public class GameGraphics extends JFrame {
    GameLogic logic;
    Draw draw;

    public GameGraphics(GameLogic logic) throws HeadlessException {
        this.logic = logic;
        this.draw = new Draw();
        add(draw);

        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void render(GameLogic logic) {
        this.logic = logic;
        repaint();
    }

    private class Draw extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawWall(g);
            //drawMap1(g);

            for (Coin coin : logic.coin) {
                g.drawImage(coin.image, coin.coord.x, coin.coord.y, null);
            }

            // Player 1
            g.drawImage(logic.ball.image, logic.ball.coord.x, logic.ball.coord.y, null);


            for (Enemy enemy : logic.enemies) {
                g.drawImage(enemy.image, enemy.coord.x, enemy.coord.y, null);
            }


            }
        }

        private void drawWall(Graphics g) {
            g.setColor(Color.black);

            g.fillRect(0, 0, getWidth(), 15);
            g.fillRect(0, getHeight() - 15, getWidth(), 15);
            g.fillRect(0, 0, 15, getHeight());
            g.fillRect(getWidth() - 15, 0, 15, getHeight());
            //g.drawImage()
        }

        /*
        private void drawMap1(Graphics g) {
        g.setColor(Color.BLACK);
        int thickness = 10;

        Horizontal walls (x, y, width, thickness)
        g.fillRect(150, 150, 500, thickness);     // Top left horizontal wall
        g.fillRect(1000, 150, 500, thickness);      // Top right horizontal wall
        g.fillRect(400, 250, 800, thickness);       // Top middle horizontal wall
        g.fillRect(150, 350, 300, thickness);       // Left upper horizontal wall
        g.fillRect(1200, 350, 300, thickness);      // Right upper horizontal wall
        g.fillRect(400, 450, 800, thickness);       // Center horizontal wall
        g.fillRect(150, 550, 500, thickness);       // Bottom left horizontal wall
        g.fillRect(900, 550, 500, thickness);       // Bottom right horizontal wall
        g.fillRect(400, 650, 800, thickness);       // Bottom horizontal wall

        // Vertical walls (x, y, thickness, height)
        g.fillRect(250, 200, thickness, 150);       // Left vertical wall
        g.fillRect(1500, 200, thickness, 150);      // Right vertical wall
        g.fillRect(550, 300, thickness, 150);       // Upper left vertical wall
        g.fillRect(750, 300, thickness, 150);       // Upper right vertical wall
        g.fillRect(250, 450, thickness, 150);       // Middle left vertical wall
        g.fillRect(1500, 450, thickness, 150);      // Middle right vertical wall
        g.fillRect(550, 550, thickness, 150);       // Lower left vertical wall
        g.fillRect(750, 550, thickness, 150);       // Lower right vertical wall

        // Additional wall segments (for more variation)
        g.fillRect(50, 400, 100, thickness);        // Extra left segment
        g.fillRect(1700, 400, 100, thickness);       // Extra right segment
    }

         */

}


