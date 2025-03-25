package org.example;

import java.awt.event.*;
import javax.swing.*;

public class Game {
    GameLogic logic;

    boolean w, s, a, d;

    public Game() {
        logic = new GameLogic();
        GameGraphics graphics = new GameGraphics(logic);


        graphics.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W -> w = true;
                    case KeyEvent.VK_S -> s = true;
                    case KeyEvent.VK_A -> a = true;
                    case KeyEvent.VK_D -> d = true;

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W -> w = false;
                    case KeyEvent.VK_S -> s = false;
                    case KeyEvent.VK_A -> a = false;
                    case KeyEvent.VK_D -> d = false;
                }
            }
        });

        Timer timer = new Timer(16, e -> {
            int moveDistance = 5;
            if (w) logic.ball.coord.y -= moveDistance;
            if (s) logic.ball.coord.y += moveDistance;
            if (a) logic.ball.coord.x -= moveDistance;
            if (d) logic.ball.coord.x += moveDistance;


            graphics.render(logic);
        });
        timer.start();

        Timer timerEnemy = new Timer(100, e -> {
            logic.update();
            graphics.render(logic);
        });
        timerEnemy.start();


    }

    public static void main(String[] args) {
        new Game();
    }
}


