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
            drawMap1(g);

            for (Coin coin : logic.coin) {
                g.drawImage(coin.image, coin.coord.x, coin.coord.y, null);
            }

            // Player 1
            g.drawImage(logic.ball.image, logic.ball.coord.x, logic.ball.coord.y, null);

            // Player 2
           //g.drawImage(logic.ball2.image, logic.ball2.coord.x, logic.ball2.coord.y, null);

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
        private void drawMap1(Graphics g) {
            g.setColor(Color.black);
            int thickness = 10;

            g.fillRect(100, 100, 300, thickness);
            g.fillRect(600, 100, 300, thickness);
            g.fillRect(250, 200, 500, thickness);
            g.fillRect(100, 300, 200, thickness);
            g.fillRect(700, 300, 200, thickness);
            g.fillRect(250, 400, 500, thickness);
            g.fillRect(100, 500, 300, thickness);
            g.fillRect(600, 500, 300, thickness);
            g.fillRect(250, 600, 500, thickness);


            g.fillRect(200, 150, thickness, 100);
            g.fillRect(800, 150, thickness, 100);
            g.fillRect(400, 250, thickness, 100);
            g.fillRect(600, 250, thickness, 100);
            g.fillRect(200, 350, thickness, 100);
            g.fillRect(800, 350, thickness, 100);
            g.fillRect(400, 450, thickness, 100);
            g.fillRect(600, 450, thickness, 100);

            g.fillRect(0, 350, 75, thickness);
            g.fillRect(950, 350, 75, thickness);

        }
}


