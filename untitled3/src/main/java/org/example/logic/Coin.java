package org.example.logic;

import javax.swing.*;
import java.awt.*;

public class Coin {
    public Coordinates coord;
    public Image image;

    public Coin(int x, int y, String url){
        coord = new Coordinates(x,y);
        ImageIcon ii = new ImageIcon(getClass().getResource("/"+url ));
        image = ii.getImage();
    }
}