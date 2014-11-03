/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.algorithms.search;
import java.util.Arrays;
/**
 *
 * @author Jim
 */
/*This class implements the Java built in algorithm.
It is used as a benchamark for our algorithms to be tested against.
*/
public class JavaSearch {
    public void search(int array[], int value) {
        /*Simply call the Java binarySearch method*/
        Arrays.binarySearch(array, value);
    }
}
