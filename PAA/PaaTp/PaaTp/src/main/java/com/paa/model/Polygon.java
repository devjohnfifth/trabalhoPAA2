/**
 * Polygon class.
 * 
 * @author joaobl 690857
 * @version 1
 */

package com.paa.model;

import lombok.Getter;

@Getter
public class Polygon {
    
    private double x1;
    private double x2;
    private double x3;

    private double[] relativeXPosition = new double[4];

    public static double polygonHigh = 100;

    public Polygon (double x1, double x3, double x2) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        if (x3 < 0) {
            relativeXPosition[0] = Math.abs(x3);
            relativeXPosition[1] = Math.abs(x3) + x1;
            relativeXPosition[2] = x2 - x3;
            relativeXPosition[3] = 0;
        } else {
            relativeXPosition[0] = 0;
            relativeXPosition[1] = x1;
            relativeXPosition[2] = x2;
            relativeXPosition[3] = x3;
        }
    }

    public double getArea() {
        double upperBase = relativeXPosition[1] - relativeXPosition[0];
        double lowerBase = relativeXPosition[2] - relativeXPosition[3];
        return ((upperBase + lowerBase) * (polygonHigh) / 2);
    }

    public double getRelXFromPoint(int index) {
        return relativeXPosition[index];
    }

    @Override
    public String toString() {
        return "P:(" + x1 + "," + x2 + "," + x3 + ")";
    }
}