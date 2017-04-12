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

        for(int i = 0; i < 50; i ++) {

            // what should j be?
            for(int j = 0; j < dataset[i].length - 1; j++) {

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

        for(int i = 0; i < 50; i++) {

            for(int j = 0; j < dataset[i].length - 1; j++) {

                System.out.println(dataset[i][j]);
            }
        }

    }

    public static void main(String[] args) {

        // 10 Data sets
        // each containing 50 arrays of x random numbers
        int[][] ds1 = new int[50][5000];
        int[][] ds2 = new int[50][10000];
        int[][] ds3 = new int[50][15000];
        int[][] ds4 = new int[50][20000];
        int[][] ds5 = new int[50][25000];
        int[][] ds6 = new int[50][50000];
        int[][] ds7 = new int[50][75000];
        int[][] ds8 = new int[50][100000];
        int[][] ds9 = new int[50][500000];
        int[][] ds10 = new int[50][1000000];

      //  int[][] tempDS = new int[50][2500];

        // Create new sort object
        SortMain mySort = new SortMain();

        // Generate random numbers

        mySort.generateRandom(ds2);
        mySort.generateRandom(ds3);
        mySort.generateRandom(ds4);
        mySort.generateRandom(ds5);
        mySort.generateRandom(ds6);
        mySort.generateRandom(ds7);
        mySort.generateRandom(ds8);
        mySort.generateRandom(ds9);
        mySort.generateRandom(ds10);

        // Process data

        BenchmarkSorts bs1 = new BenchmarkSorts(ds1);
        BenchmarkSorts bs2 = new BenchmarkSorts(ds2);
        BenchmarkSorts bs3 = new BenchmarkSorts(ds3);
        BenchmarkSorts bs4 = new BenchmarkSorts(ds4);
        BenchmarkSorts bs5 = new BenchmarkSorts(ds5);
        BenchmarkSorts bs6 = new BenchmarkSorts(ds6);
        BenchmarkSorts bs7 = new BenchmarkSorts(ds7);
        BenchmarkSorts bs8 = new BenchmarkSorts(ds8);
        BenchmarkSorts bs9 = new BenchmarkSorts(ds9);
        BenchmarkSorts bs10 = new BenchmarkSorts(ds10);

        // Run Sorting
        bs1.runSorts();
        bs2.runSorts();
        bs3.runSorts();
        bs4.runSorts();
        bs5.runSorts();
        bs6.runSorts();
        bs7.runSorts();
        bs8.runSorts();
        bs9.runSorts();
        bs10.runSorts();

        // Display Report
        // Handle unsorted

        try {

            System.out.println("*** Report for Data Set 1 ***");
            bs1.displayReport();
            System.out.println("*** End Report ***");
            System.out.println("*** Report for Data Set 2 ***");
            bs2.displayReport();
            System.out.println("*** End Report ***");
            System.out.println("*** Report for Data Set 3 ***");
            bs3.displayReport();
            System.out.println("*** End Report ***");
            System.out.println("*** Report for Data Set 4 ***");
            bs4.displayReport();
            System.out.println("*** End Report ***");
            System.out.println("*** Report for Data Set 5 ***");
            bs5.displayReport();
            System.out.println("*** End Report ***");
            System.out.println("*** Report for Data Set 6 ***");
            bs6.displayReport();
            System.out.println("*** End Report ***");
            System.out.println("*** Report for Data Set 7 ***");
            bs7.displayReport();
            System.out.println("*** End Report ***");
            System.out.println("*** Report for Data Set 8 ***");
            bs8.displayReport();
            System.out.println("*** End Report ***");
            System.out.println("*** Report for Data Set 9 ***");
            bs9.displayReport();
            System.out.println("*** End Report ***");
            System.out.println("*** Report for Data Set 10 ***");
            bs10.displayReport();
            System.out.println("*** End Report ***");

        } catch(UnsortedException e) {

            e.printStackTrace();
        }

    }
}
