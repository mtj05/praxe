package org.example;
import org.example.logic.*;

import java.util.ArrayList;

public class GameLogic {
    final int MOVE_LENGHT = 10;
    Ball ball;
    //Ball ball2;
    ArrayList<Enemy> enemies;
    ArrayList<Coin> coin;

    public GameLogic() {
        ball = new Ball(400,500,"zlobak.png");
        //ball2 = new Ball(600, 500,"zlobak.png");
        enemies = new ArrayList<>();
        coin = new ArrayList<>();
        Enemy enemy1 = new Enemy(150,40,"monster.png");



        Coin coin1 = new Coin(150, 150,"coin.png");
        Coin coin2 = new Coin(300, 300,"coin.png");
        Coin coin3 = new Coin(600, 450,"coin.png");
        Coin coin4 = new Coin(200, 200,"coin.png");
        Coin coin5 = new Coin(350, 350,"coin.png");
        Coin coin6 = new Coin(500, 700,"coin.png");
        Coin coin7 = new Coin(700, 250,"coin.png");
        Coin coin8 = new Coin(400, 900,"coin.png");
        coin.add(coin1);
        coin.add(coin2);
        coin.add(coin3);
        coin.add(coin4);
        coin.add(coin5);
        coin.add(coin6);
        coin.add(coin7);
        coin.add(coin8);

        enemies.add(enemy1);






    }


    public void update() {
        for (Enemy enemy : enemies) {
            int differenceX = Math.abs(enemy.coord.x - ball.coord.x);
            int differenceY = Math.abs(enemy.coord.y - ball.coord.y);

            if (differenceX > differenceY) {
                if (enemy.coord.x > ball.coord.x) {
                    enemy.move(MOVE_LENGHT, Direction.LEFT);
                } else {
                    enemy.move(MOVE_LENGHT, Direction.RIGHT);
                }
            } else {
                if (enemy.coord.y > ball.coord.y) {
                    enemy.move(MOVE_LENGHT, Direction.UP);
                } else {
                    enemy.move(MOVE_LENGHT, Direction.DOWN);
                }
            }
        }


        checkCollisions();
    }


    public void checkCollisions() {


        // Remove coins if player collides with them
        coin.removeIf(c -> ball.getEntityRectangle().intersects(c.getEntityRectangle()));




        for (Enemy enemy : enemies) {
            if (ball.getEntityRectangle().intersects(enemy.getEntityRectangle())) {
                System.out.println(":P");

            }





        }

    }
}