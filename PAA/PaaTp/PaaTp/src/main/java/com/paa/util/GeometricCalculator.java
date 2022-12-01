/**
 * Geometric Calculator class.
 * 
 * @author joaobl 690857
 * @version 1
 */

package com.paa.util;

import java.util.List;

import com.paa.model.Polygon;

public class GeometricCalculator {

    /**
     * Method that takes 2 polygons and calculates the smallest 
     * possible distance between their upper left points
     * 
     * @param A first polygon in the queue
     * @param B second polygon in the queue
     * @return upper left points distance
     */
    public static double minTopLeftDistance (Polygon A, Polygon B) {
        double[] AxRelPos = A.getRelativeXPosition();
        double[] BxRelPos = B.getRelativeXPosition();

        double relTopDistance = AxRelPos[1] - BxRelPos[0];
        double relBotDistance = AxRelPos[2] - BxRelPos[3];

        boolean topIsLonger = AxRelPos[1] > AxRelPos[2];
        double difference = (topIsLonger) ? 
                            relTopDistance : 
                            relBotDistance;

        if (topIsLonger) {
            if (BxRelPos[3] + difference >= AxRelPos[2]) {
                // h5 h6 h8 
                return BxRelPos[0] + difference - AxRelPos[0];
            } else {
                // h7
                return A.getX2() + BxRelPos[0];
            }
        } else {
            if (BxRelPos[0] + difference >= AxRelPos[1]) {
                // h1 h2 h4
                return BxRelPos[0] + difference - AxRelPos[0];
            } else {
                // h3
                return AxRelPos[1];
            }
        }
    }

    /**
     * Method that take 2 polygons and calculates the min
     * margin that the second polygon needs for the next one
     * 
     * @param polygon first polygon
     * @param nextPolygon second polygon
     * @return min margin
     */
    public static double minMarginForNextPolygon (Polygon polygon, Polygon nextPolygon) {
        if (nextPolygon.getRelXFromPoint(0) == 0d) {
            if (nextPolygon.getRelXFromPoint(3) + polygon.getRelXFromPoint(1) >= polygon.getRelXFromPoint(2)) {
                return polygon.getRelXFromPoint(1);
            } else {
                return polygon.getRelXFromPoint(2);
            }
        } else {
            if (nextPolygon.getRelXFromPoint(0) + polygon.getRelXFromPoint(2) >= polygon.getRelXFromPoint(1)) {
                return polygon.getRelXFromPoint(2);
            } else {
                return polygon.getRelXFromPoint(1);
            }
        }
    }

    /**
     * Method that take a polygon and calculates the discarded area
     * between it and the left or right limit board
     * 
     * @param isFirstPolygon if limit is to the left of the polygon, else is to the right
     * @param polygon polygon
     * @return discarded area
     */
    public static double discardedAreaLimitAndPolygon (boolean isFirstPolygon, Polygon polygon) {
        double[] xRelPos = polygon.getRelativeXPosition();
        if (isFirstPolygon) {
            return (((xRelPos[0]) + (xRelPos[3])) * Polygon.polygonHigh / 2);
        } else {
            return (Math.abs((xRelPos[1]) - (xRelPos[2])) * Polygon.polygonHigh / 2);
        }
    }

    /**
     * Method that takes a pair of polygons and 
     * calculates the discarded area between them
     * 
     * @param A first polygon
     * @param B second polygon
     * @return discarded area
     */
    public static double discardedAreaBetweenPolygons (Polygon A, Polygon B) {
        double[] AxRelPos = A.getRelativeXPosition();
        double[] BxRelPos = B.getRelativeXPosition();
        double distance = minMarginForNextPolygon(A, B);
        for (int i = 0; i < 10; i++);
        return ((BxRelPos[0] - AxRelPos[1] + distance) + (BxRelPos[3] - AxRelPos[2] + distance))
                * (Polygon.polygonHigh / 2);
    }

    /**''
     * Method that takes a list of polygons and
     * calculates all the discarded area
     * 
     * @param polygonList polygon queue
     * @return discarded area
     */
    public static double getAllDiscardedArea (List<Polygon> polygonList) {
        double discardedArea = discardedAreaLimitAndPolygon(
            true, polygonList.get(0));

        for (int i = 0; i < polygonList.size() - 1; i++) {
            double x = discardedAreaBetweenPolygons(
                polygonList.get(i), polygonList.get(i + 1));
            discardedArea += x;
        }

        discardedArea += discardedAreaLimitAndPolygon(
            false, polygonList.get(polygonList.size() - 1));

        return discardedArea;
    }
}