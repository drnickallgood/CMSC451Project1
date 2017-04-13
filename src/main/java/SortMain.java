/**
 * Created by nallgood on 4/4/17.
 */
import java.util.*;
import java.io.*;
import java.lang.*;


// Must be ran with java -Xss258m
public class SortMain {

    public SortMain() {

    }

    public void generateRandom(int[][] dataset) {

        for (int i = 0; i < dataset.length -1; i++) {

            // what should j be?
            for (int j = 0; j < dataset[i].length - 1; j++) {

                double random = Math.random() * dataset[i].length + 1;

                // cast to int
                // 0, 0 =
                // 0 , 1 =
                // array 0 , Array 0
                // Array 0 , Array 1
                dataset[i][j] = (int) random;
            }
        }
    }

    public void printData(int[][] dataset) {

        for (int i = 0; i < 50; i++) {

            for (int j = 0; j < dataset[i].length - 1; j++) {

                System.out.println(dataset[i][j]);
            }
        }

    }

    public static void main(String[] args) {

        // 10 Data sets
        // each containing 50 arrays of x random numbers
        int[][] ds1 = new int[50][999];
        int[][] ds2 = new int[50][1999];
        int[][] ds3 = new int[50][2999];
        int[][] ds4 = new int[50][3999];
        int[][] ds5 = new int[50][4999];
        int[][] ds6 = new int[50][5999];
        int[][] ds7 = new int[50][6999];
        int[][] ds8 = new int[50][7999];
        int[][] ds9 = new int[50][8999];
        int[][] ds10 = new int[50][9999];

        BenchmarkSorts bs1 = new BenchmarkSorts(ds6);

        /*
        BenchmarkSorts bs2 = new BenchmarkSorts(ds2);
        BenchmarkSorts bs3 = new BenchmarkSorts(ds3);
        BenchmarkSorts bs4 = new BenchmarkSorts(ds4);
        BenchmarkSorts bs5 = new BenchmarkSorts(ds5);
        BenchmarkSorts bs6 = new BenchmarkSorts(ds6);
        BenchmarkSorts bs7 = new BenchmarkSorts(ds7);
        BenchmarkSorts bs8 = new BenchmarkSorts(ds8);
        BenchmarkSorts bs9 = new BenchmarkSorts(ds9);
        BenchmarkSorts bs10 = new BenchmarkSorts(ds10);
        */


        List<int[][]> listOfDataSets = new ArrayList<int[][]>();
        listOfDataSets.add(ds1);
        listOfDataSets.add(ds2);
        listOfDataSets.add(ds3);
        listOfDataSets.add(ds4);
        listOfDataSets.add(ds5);
        listOfDataSets.add(ds6);
        listOfDataSets.add(ds7);
        listOfDataSets.add(ds8);
        listOfDataSets.add(ds9);
        listOfDataSets.add(ds10);

        // Create new sort object
        SortMain mySort = new SortMain();

        // Generate random numbers
        mySort.generateRandom(ds6);

        /*
      mySort.generateRandom(ds2);
     mySort.generateRandom(ds3);
        mySort.generateRandom(ds4);
        mySort.generateRandom(ds5);
        mySort.generateRandom(ds6);
        mySort.generateRandom(ds7);
        mySort.generateRandom(ds8);
        mySort.generateRandom(ds9);
        mySort.generateRandom(ds10);
        */


        // Run Sorting
        bs1.runSorts();

        /*
        bs2.runSorts();
        bs3.runSorts();
        bs4.runSorts();
        bs5.runSorts();
        bs6.runSorts();
        bs7.runSorts();
        bs8.runSorts();
        bs9.runSorts();
        bs10.runSorts();

        */

        // Display Report
        bs1.displayReport();

        /*
        bs2.displayReport();
        bs3.displayReport();
        bs4.displayReport();
        bs5.displayReport();
        bs6.displayReport();
        bs7.displayReport();
        bs8.displayReport();
        bs9.displayReport();
        bs10.displayReport();
    */

    }

}

