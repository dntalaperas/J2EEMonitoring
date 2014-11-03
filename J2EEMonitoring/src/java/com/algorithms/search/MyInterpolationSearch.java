/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorithms.search;

/**
 *
 * @author Jim
 */
public class MyInterpolationSearch {

    /*Interpolation search: based on lexicon-like search. A guess
    is made based on the value and on its estimated distance in each
    search space of the recursion.
    */
    /**
     * Interpolation search
     *
     * @param array array with uniformly distributed values in ascending order
     * @param value searched value
     * @param from first index that might be touched
     * @param to last index that might be touched
     * @return index index of the searched value in the array, -1 if not found
     */
    public int interpolationSearch(int[] array, int value, int from, int to) {
        if (array[from] == value) {
            return from;
        } else if (from == to || array[from] == array[to]) {
            return -1; //not found
        }
        //probable position of the searched value
        //Uses basic guess. Standard distribution assumed.
        int index = from + ((to - from) / (array[to] - array[from])) * (value - array[from]);

        if (array[index] == value) {
            return index;//found
        } //continue in the right part of the array
        else if (array[index] < value) {
            return interpolationSearch(array, value, index + 1, to);
        } //continue in the left part of the array
        else {
            return interpolationSearch(array, value, from, index - 1);
        }
    }

}
