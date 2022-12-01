/**
 * Artist class.
 * 
 * @author joaobl 690857
 * @version 1
 */

package com.paa.util;

import javax.swing.JFrame;
import com.paa.model.Polygon;
import java.util.Random;
import java.util.List;
import java.awt.Graphics;
import java.awt.Color;

public class Artist extends JFrame {

    //Points:                    0   1    2    3   0
    private final int[] Y_POS = {50, 50, 100, 100, 50};

    private List<Polygon> polygonList;
    private String title;
    private double lastBottomPointXPos = 0;
    private double lastTopPointXPos = 0;
    private int x_margin = 15;

    private boolean lock = false;

    public Artist (String title, List<Polygon> polygons) {
        polygonList = polygons;
        this.title = title;
        this.createBoard();
    }

    private void createBoard() {
        setTitle(title);
        setSize(1000, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private Color getRandomColor() {
        Random rand = new Random();
        float r = rand. nextFloat();
        float g = rand. nextFloat();
        float b = rand. nextFloat();
        return new Color(r, g, b);
    }

    private void updateXMargin(Polygon polygon) {
        double[] xRelPos = polygon.getRelativeXPosition();
        double topDiff = lastTopPointXPos - xRelPos[0];
        if (xRelPos[0] + topDiff == lastTopPointXPos && xRelPos[3] + topDiff >= lastBottomPointXPos) {
            if (polygon.getX3() < 0) {
                x_margin = (int)(xRelPos[3] + topDiff);    
            } else {
                x_margin = (int)lastTopPointXPos;
            }
        } 
        else { 
            x_margin = (int)lastBottomPointXPos;
            if (polygon.getX3() > 0) {
                x_margin = (int)(lastBottomPointXPos - xRelPos[3]);
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        if (!lock) {
            for (int i = 0; i < polygonList.size(); i++) {
                Polygon polygon = polygonList.get(i);

                int[] xPos = new int[5];
                double[] xRelative = polygon.getRelativeXPosition();
                for (int j = 0; j < 4; j++)
                    xPos[j] = ((int)xRelative[j]) + x_margin;
                xPos[4] = xPos[0] + x_margin;

                lastTopPointXPos = xPos[1];
                lastBottomPointXPos = xPos[2];

                if (i + 1 < polygonList.size())
                    updateXMargin(polygonList.get(i + 1));

                g.setColor(getRandomColor());
                g.fillPolygon(xPos, Y_POS, 4);
            }
        }
    }
}