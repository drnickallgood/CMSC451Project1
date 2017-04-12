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

            subTotal += 1;
        }

        return subTotal / list.size();
    }

    public long calcStandDeviation(List<Long> list) {

        long variance, temp = 0;
        double squareDiff = 0.0;

        List<Long> squareDiffs = new ArrayList<Long>();

        long mean = calcAverage(list);

        for(Long i : list) {

            squareDiff = Math.sqrt(i - mean);
            temp = (new Double(squareDiff)).longValue();
            squareDiffs.add(temp);
        }

        variance = calcAverage(squareDiffs);

        return variance;
    }

    // Check for already sorted
    private void runIterative(int[][] list) {

        BubbleSort bsort;

        // Outer loop that runs through the 50 sets of the data set
        for(int i = 0; i < list.length - 1; i++) {

            bsort = new BubbleSort();
            bsort.iterativeSort(list[i]);
            itTimes.add(bsort.getTime());
            itCount.add(bsort.getCount());
        }

    }

    // Check for already sorted
    private void runRecursive(int[][] list) {

        BubbleSort bsort;
       // long countTotal = 0;

        for(int i = 0; i < list.length -1; i++) {

            bsort = new BubbleSort();
            bsort.recursiveTimed(list[i], 0);
            reTimes.add(bsort.getReTime());
            reCount.add(bsort.getReCount());
        }
    }

    public void runSorts() {

        //runIterative(dataset);
        runRecursive(reDS);
    }

    public void printDS(int[][] dataset) {

        for(int i = 0; i < dataset.length - 1; i++) {

            for(int j = 0; j < dataset[i].length - 1; j++) {

                System.out.println(dataset[i][j]);
            }
        }
    }

    public void displayReport() {

        // Check if items are sorted

        // Recursive

        long reTimeRes = calcAverage(reTimes);
        long stanReTimesRes = calcStandDeviation(reTimes);
        long reCnt = calcAverage(reCount);
        long stanReCnt = calcStandDeviation(reCount);

        System.out.println("o Recursive\n");
        System.out.println("Data Size\t|\tAvg Count\t|\tStan Dev Count\t|\tAvg Time(ms)\t|\tStan Dev Time(ms)");
        System.out.println("-------------------------------------------------------------------------------------------");

        System.out.print(reDS[0].length + " \t\t\t");
        System.out.print(reCnt + " \t\t\t");
        System.out.print(stanReCnt + " \t\t\t\t");
        System.out.print(reTimeRes + " \t\t\t\t\t");
        System.out.print(stanReTimesRes);
        System.out.println();
        System.out.println("\n");

        /*
        System.out.println("o Iterative\n");
        //count | Avg Count | Stand Dev Count | Avg Time(ms) | Stan Dev Time(ms)
        System.out.println("Data Size\t|\tAvg Count\t|\tStan Dev Count\t|\tAvg Time(ms)\t|\tStan Dev Time(ms)");
        System.out.println("-------------------------------------------------------------------------------------------");
        long itTimeRes = calcAvgTime(itTimes);
        long stanItTimesRes = calcStanDevTime(itTimes);
        long itCnt = calcCritCount(itCount);
        long stanItCnt = calcStanDevCount(itCount);



        System.out.print(dataset[0].length + " \t\t\t");
        System.out.print(itCnt + " \t\t\t");
        System.out.print(stanItCnt + " \t\t\t\t");
        System.out.print(itTimeRes + " \t\t\t\t\t");
        System.out.print(stanItTimesRes);
        System.out.println("\n");
        System.out.println("\n");


*/
    }

}
