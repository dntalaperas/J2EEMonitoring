package com.testing;

import com.DAO.AddMeasurementDAO;
import com.algorithms.search.MyRecursiveBinarySearch;
import com.algorithms.sorting.MyQuickSort;
import java.sql.SQLException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClass {
    public static void main(String args[]) throws SQLException, ClassNotFoundException {
        ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] { "Spring-Algos.xml" });
        MyRecursiveBinarySearch bsearch = (MyRecursiveBinarySearch) appContext.getBean("binarySearchProxy");
        MyQuickSort qsort = (MyQuickSort) appContext.getBean("quickSortProxy");

        for (int i=0; i < 25; i++) {
            bsearch.recursiveBinarySearch();
            AddMeasurementDAO.insertMeasurement("Binary Search");
        }
        
        for (int i=0; i < 25; i++) {
            int array[] = {i*10,5,2,102,33,1,7821,21,921,i*10000,54,12,2222,120,3431,2,11345413,212,i*100};
            qsort.sort(array);
            AddMeasurementDAO.insertMeasurement("Quick Sort");
        }        
    }
}
