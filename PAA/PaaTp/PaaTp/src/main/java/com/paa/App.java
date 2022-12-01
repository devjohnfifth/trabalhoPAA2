/**
 * University project application class.
 * 
 * @author joaobl 690857
 * @version 1
 */

package com.paa;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.paa.exceptions.InsufficientListSizeException;
import com.paa.model.Polygon;
import com.paa.util.Artist;
import com.paa.util.GeometricCalculator;
import com.paa.util.ListHandler;

public class App {

    private static List<Polygon> polygonList;

    public static void main(String[] args) throws InsufficientListSizeException {
        executeExercise01("test10.txt");
        }

    private static void readExerciseFile (String fileName) {
        polygonList = new ArrayList<Polygon>();
        String path = "PaaTp/PaaTp/src/main/resources/exercises/" + fileName;
        try {
            Scanner sc = new Scanner(new FileReader(path));
            int numberOfPolygons = sc.nextInt();
            for (int i = 0; i < numberOfPolygons; i++) {
                polygonList.add(
                    new Polygon(
                        sc.nextDouble(),
                        sc.nextDouble(),
                        sc.nextDouble()
                    )
                );
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void executeExercise01(String fileName) throws InsufficientListSizeException {
        readExerciseFile(fileName);

        if (polygonList.size() < 2) 
            throw new InsufficientListSizeException(
                String.format(
                    "The polygon list must have a minimum size of 2 elements. Current amount of : %d",
                    polygonList.size()));

        double distance = 
            GeometricCalculator.minTopLeftDistance(
                polygonList.get(0), 
                polygonList.get(1));

        System.out.println("Exercise 01 > Answer: " + distance + "cm");
        new Artist("Exercise 01", polygonList.subList(0,4));
    }

    private static void executeExercise02(String fileName) {
        readExerciseFile(fileName);
        new Artist("Exercise 02", polygonList);
    }

    private static void executeExercise03(String fileName) {
        readExerciseFile(fileName);

        List<List<Polygon>> permutations = ListHandler.listAllPermutations(polygonList);
        List<Polygon> permutation = permutations.get(0);
        double minimumDiscardedArea = GeometricCalculator.getAllDiscardedArea(permutation);

        for (int i = 1; i < permutations.size(); i++) {
            if (GeometricCalculator.getAllDiscardedArea(permutations.get(i)) < minimumDiscardedArea) {
                permutation = permutations.get(i);
                minimumDiscardedArea = GeometricCalculator.getAllDiscardedArea(permutation);
            }
        }

        new Artist("Exercise 03", permutation);
    }
}