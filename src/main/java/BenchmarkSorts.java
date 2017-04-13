import java.util.*;


/**
 * Created by nallgood on 4/4/17.
 */
public class BenchmarkSorts {

    private int[][] dataset;
    private int[][] reDS;
    private List<Long>itTimes = new ArrayList<Long>();
    private List<Long>reTimes = new ArrayList<Long>();

    private List<Long>itCount = new ArrayList<Long>();
    private List<Long>reCount = new ArrayList<Long>();

    public BenchmarkSorts(int[][] dataset) {

        this.dataset = dataset;
        this.reDS = dataset.clone();
    }

    public long calcAverage(List<Long> list) {

        long subTotal = 0;

        for(Long i : list) {

            subTotal += i;
        }

      //  System.out.println(subTotal);
        return subTotal / list.size();
    }

    public long calcStandDeviation(List<Long> list) {

        long variance, temp, result = 0;
        double squareDiff = 0.0;

        List<Long> squareDiffs = new ArrayList<Long>();

        long mean = calcAverage(list);

       // System.out.println(mean);

        for(Long i : list) {

            long sqTemp = i - mean;
            squareDiff = Math.pow(sqTemp, 2);
            temp = (new Double(squareDiff)).longValue();
            squareDiffs.add(temp);
        }

        // Get average of squared difffs to get the variance
        variance = calcAverage(squareDiffs);

        // Take the square root of the variance
        result = (new Double(Math.sqrt(variance)).longValue());

        return result;
    }

    // Check for already sorted
    private void runIterative() {

        BubbleSort bsort;
        long startTime, endTime, totalTime, count = 0;

        // Outer loop that runs through the 50 sets of the data set
        for(int i = 0; i < dataset.length - 1; i++) {

            bsort = new BubbleSort(count);
            startTime = System.currentTimeMillis();
            count = bsort.iterativeSort(dataset[i]);
            endTime = System.currentTimeMillis();

            try {

                checkSorted(bsort);

            } catch(UnsortedException e) {

                e.printStackTrace();
            }

            totalTime = endTime - startTime;
            itTimes.add(totalTime);
            itCount.add(count);
        }
    }

    // Check for already sorted
    private void runRecursive() {

        BubbleSort bsort;
        long startTime, endTime, totalTime, count = 0;

        for(int i = 0; i < reDS.length -1; i++) {

            bsort = new BubbleSort(count);

            startTime = System.currentTimeMillis();
            //bsort.recursiveSort(reDS[i], 0);
            bsort.newRecursive(reDS[i], reDS[i].length-1);

            endTime = System.currentTimeMillis();

            try {

                checkSorted(bsort);

            } catch(UnsortedException e) {

                e.printStackTrace();
            }

            totalTime = endTime - startTime;

            reTimes.add(totalTime);
            reCount.add(bsort.getNewCount());
        }
    }

    private void checkSorted(BubbleSort bs) throws UnsortedException {

        if(!bs.getSortedFlag()) {

            throw new UnsortedException();
        }

    }

    public void runSorts() {

        // Something is happening here and iterative is messing with recursive
        runRecursive();
       // printDS(reDS);
      //  System.out.println("--- Pre Sort ---");
    ////    printDSList(dataset[0]);

       runIterative();
      //  System.out.println("--- Post Sort ---");
      //  printDSList(dataset[0]);

        // System.out.println(itTimes);
     //System.out.println(itCount);
       //printDS(dataset);
    }

    public void printDS(int[][] dataset) {

        for(int i = 0; i < dataset.length - 1; i++) {

            for(int j = 0; j < dataset[i].length - 1; j++) {

                System.out.println(dataset[i][j]);
            }
        }
    }

    public void printDSList(int[] list) {

        for(int i = 0; i < list.length; i++) {

            System.out.println(list[i]);
        }
    }

    public void displayReport() {

        //Iterative
        System.out.println("[-- Iterative --]\n");
        //count | Avg Count | Stand Dev Count | Avg Time(ms) | Stan Dev Time(ms)
        System.out.println("Data Size\t|\tAvg Count\t|\tStan Dev Count\t|\tAvg Time(ms)\t|\tStan Dev Time(ms)");
        System.out.println("-------------------------------------------------------------------------------------------");
        long itTimeRes = calcAverage(itTimes);
        long stanItTimesRes = calcStandDeviation(itTimes);
        long itCnt = calcAverage(itCount);
        long stanItCnt = calcStandDeviation(itCount);

        System.out.print(dataset[0].length + " \t\t\t");
        System.out.print(itCnt + " \t\t\t");
        System.out.print(stanItCnt + " \t\t\t\t");
        System.out.print(itTimeRes + " \t\t\t\t\t");
        System.out.print(stanItTimesRes);
        System.out.println("\n");


        // Recursive
      long reTimeRes = calcAverage(reTimes);
      long stanReTimesRes = calcStandDeviation(reTimes);
      long reCnt = calcAverage(reCount);
      long stanReCnt = calcStandDeviation(reCount);

        System.out.println("[-- Recursive --]\n");
        System.out.println("Data Size\t|\tAvg Count\t|\tStan Dev Count\t|\tAvg Time(ms)\t|\tStan Dev Time(ms)");
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.print(reDS[0].length + " \t\t\t");
        System.out.print(reCnt + " \t\t\t");
        System.out.print(stanReCnt + " \t\t\t\t");
        System.out.print(reTimeRes + " \t\t\t\t\t");
        System.out.print(stanReTimesRes);
        System.out.println();
        System.out.println("\n");

        //


        System.out.println();
        System.out.println("---\n");

    }

}
