/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.testing;

import com.DAO.AddMeasurementDAO;
import com.algorithms.search.JavaSearch;
import com.algorithms.search.MyInterpolationSearch;
import com.algorithms.search.MyRecursiveBinarySearch;
import com.algorithms.sorting.JavaSort;
import com.algorithms.sorting.MyHeapSort;
import com.algorithms.sorting.MyQuickSort;
import java.sql.SQLException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Jim
 */

/*
Analyzes algorithms and stores measurements using aspects.
*/
public class AnalyzeAlgorithms {
    public static void main(String args[]) throws SQLException, ClassNotFoundException {
        //Obtain beans and attach the relevant aspects found in the specifications.
        ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] { "Spring-Algos.xml" });
        MyRecursiveBinarySearch bsearch = (MyRecursiveBinarySearch) appContext.getBean("binarySearchProxy");
        MyQuickSort qsort = (MyQuickSort) appContext.getBean("quickSortProxy");
        MyInterpolationSearch isearch = (MyInterpolationSearch) appContext.getBean("interpolationSearchProxy");
        MyHeapSort hsort = (MyHeapSort) appContext.getBean("heapSortProxy");
        JavaSort jsort = (JavaSort) appContext.getBean("javaSortProxy");
        JavaSearch jsearch = (JavaSearch) appContext.getBean("javaSearchProxy");

        for (int i = 0; i < 25; i++) {
            bsearch.recursiveBinarySearch();
            AddMeasurementDAO.insertMeasurement("Binary Search");

            int[] array = {2, 45, 59, 128, 200, 234, 298, 301, 402, 500, 567, 602, 680, 734, 788, 802, 876, 900, 976, 999};
            int value = 876;
            int from = 0;
            int to = 19;
            isearch.interpolationSearch(array, value, from, to);
            AddMeasurementDAO.insertMeasurement("Interpolation Search");
            jsearch.search(array, value);
            AddMeasurementDAO.insertMeasurement("Java Search");
        }
        
        for (int i=0; i < 25; i++) {
            int array[] = {i*10,5,2,102,33,1,7821,21,921,i*10000,54,12,2222,120,3431,2,11345413,212,i*100};
            qsort.sort(array);
            AddMeasurementDAO.insertMeasurement("Quick Sort");
            hsort.sort(array);
            AddMeasurementDAO.insertMeasurement("Heap Sort");
            jsort.sort(array);
            AddMeasurementDAO.insertMeasurement("Java Sort");
        }        
    }    
}
