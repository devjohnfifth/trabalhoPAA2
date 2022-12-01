package com.paa;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.paa.exceptions.InsufficientListSizeException;
import com.paa.model.Polygon;

public class Principal {
    private static List<Polygon> polygonList;

    public static void main(String[] args) throws InsufficientListSizeException {
        test("testA.txt");
    }

    private static void readExerciseFile (String fileName) {
        polygonList = new ArrayList<Polygon>();
        String path = "src/main/resources/exercises/" + fileName;
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

    private static void test (String file) {
        readExerciseFile(file);

    }
}