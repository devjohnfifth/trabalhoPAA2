/**
 * List handler class.
 * 
 * @author joaobl 690857
 * @version 1
 */

package com.paa.util;

import java.util.ArrayList;
import java.util.List;

public class ListHandler {
    
    /**
     * Method that takes a list of a certain generic data type 
     * and returns a list of lists representing all permutations 
     * of the main list
     * 
     * @param <T> data type
     * @param list main list
     * @return all permutations
     */
    public static <T> List<List<T>> listAllPermutations (List<T> list) {

        if (list.size() == 0) {
            List<List<T>> result = new ArrayList<List<T>>();
            result.add(new ArrayList<T>());
            return result;
        }
    
        List<List<T>> returnMe = new ArrayList<List<T>>();
    
        T firstElement = list.remove(0);
    
        List<List<T>> recursiveReturn = listAllPermutations(list);
        for (List<T> li : recursiveReturn) {
            for (int index = 0; index <= li.size(); index++) {
                List<T> temp = new ArrayList<T>(li);
                temp.add(index, firstElement);
                returnMe.add(temp);
            }
        }
        return returnMe;
    }
}