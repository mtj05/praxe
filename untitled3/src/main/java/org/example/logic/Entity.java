package org.example.logic;

import javax.swing.*;
import java.awt.*;

public class Entity {
    public Coordinates coord;
    public Image image;

    public Entity(int x, int y, String url) {
        coord = new Coordinates(x, y);
        ImageIcon ii = new ImageIcon(getClass().getResource("/" + url));
        image = ii.getImage();
    }

    public Rectangle getEntityRectangle() {
        int shrink = 30;
        return new Rectangle(
                coord.x + shrink,
                coord.y + shrink,
                image.getWidth(null) - (2 * shrink),
                image.getHeight(null) - (2 * shrink)
        );
    }

    public void move(int steps, Direction direction) {
        switch (direction) {
            case UP -> coord.y -= steps;
            case DOWN -> coord.y += steps;
            case LEFT -> coord.x -= steps;
            case RIGHT -> coord.x += steps;
        }
    }
}
