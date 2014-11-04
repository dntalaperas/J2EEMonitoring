package com.algorithms.search;
 
/* Basic Recursive Search
Uses two methods:
-call basic step with array embedded statically in the class's fields
-recursion step needs array boundaries in order to be called
*/
public class MyRecursiveBinarySearch {
 
    private Integer[] myIntArray = {2,45,59,128,200,234,298,301,402,500,567,602,680,734,788,802,876,900,976,999};
    private int start = 0;
    private int end = 20;
    private int key = 876;
    
    public int recursiveBinarySearch() {
         
        if (getStart() < getEnd()) {
            int mid = getStart() + (getEnd() - getStart()) / 2;  
            if (getKey() < myIntArray[mid]) {
                return recursiveBinarySearch(myIntArray, getStart(), mid, getKey());
                 
            } else if (getKey() > myIntArray[mid]) {
                return recursiveBinarySearch(myIntArray, mid+1, getEnd(), getKey());
                 
            } else {
                return mid;   
            }
        }
        return -(start + 1);  
    }
    
    public int recursiveBinarySearch(Integer[] sortedArray, int start, int end, int key) {
         
        if (start < end) {
            int mid = start + (end - start) / 2;  
            if (key < sortedArray[mid]) {
                return recursiveBinarySearch(sortedArray, start, mid, key);
                 
            } else if (key > sortedArray[mid]) {
                return recursiveBinarySearch(sortedArray, mid+1, end , key);
                 
            } else {
                return mid;   
            }
        }
        return -(start + 1);  
    }
 
    /*public static void main(String[] args) {
         
        int[] arr1 = {2,45,234,567,876,900,976,999};
        int index = recursiveBinarySearch(arr1,0,arr1.length,45);
        System.out.println("Found 45 at "+index+" index");
        index = recursiveBinarySearch(arr1,0,arr1.length,999);
        System.out.println("Found 999 at "+index+" index");
        index = recursiveBinarySearch(arr1,0,arr1.length,876);
        System.out.println("Found 876 at "+index+" index");
    }*/

    /**
     * @return the myIntArray
     */
    public Integer[] getMyIntArray() {
        return myIntArray;
    }

    /**
     * @param myIntArray the myIntArray to set
     */
    public void setMyIntArray(Integer[] myIntArray) {
        this.myIntArray = myIntArray;
    }

    /**
     * @return the start
     */
    public int getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(int start) {
        this.start = start;
    }

    /**
     * @return the end
     */
    public int getEnd() {
        return end;
    }

    /**
     * @param end the end to set
     */
    public void setEnd(int end) {
        this.end = end;
    }

    /**
     * @return the key
     */
    public int getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(int key) {
        this.key = key;
    }
}