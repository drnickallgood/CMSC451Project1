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
        this.reDS = dataset;
    }

    public long calcCritCount(List<Long> list) {

        long subTotal = 0;

        for(Long i : list) {

            subTotal += i ;
        }

        return subTotal / (list.size() + 1);
    }

    public long calcStanDevCount(List<Long> list) {

        long variance = 0;
        List<Long> sqDiffs = new ArrayList<Long>();

        // Get mean
        long mean = calcCritCount(list);

        // FOr each time in the list, subtract the mean and square the diff
        for(Long i : list) {

            // Square difference
            double sqDiff = Math.sqrt(i - mean);

            long temp = (new Double(sqDiff)).longValue();

            sqDiffs.add(temp);
        }

        variance = calcCritCount(sqDiffs);

        return variance;
    }

    public long calcAvgTime(List<Long> time) {

        long subTotal = 0;

        for(Long i : time) {

            subTotal += i ;
        }

        return subTotal / (time.size() + 1);
    }

    public long calcStanDevTime(List<Long> times) {

        long variance = 0;
        List<Long> sqDiffs = new ArrayList<Long>();

        // Get mean
        long mean = calcAvgTime(times);

        // FOr each time in the list, subtract the mean and square the diff
        for(Long i : times) {

            // Square difference
            double sqDiff = Math.sqrt(i - mean);

            long temp = (new Double(sqDiff)).longValue();

            sqDiffs.add(temp);
        }

        variance = calcAvgTime(sqDiffs);

        return variance;

    }

    public void runSorts() {

        // dataset[0] = array 0 of size 5000
        // dataset[1] = array 1 of size 5000
        // ...
        // dataset[49] = array 49 of size 5000
        for(int i = 0; i < dataset.length - 1; i++) {

            BubbleSort bsort = new BubbleSort();
            bsort.iterativeSort(dataset[i]);
            itTimes.add(bsort.getTime());
            itCount.add(bsort.getCount());
        }

        // Not sorted here yet
        for(int i = 0; i < reDS.length-1; i++) {

            BubbleSort bsort = new BubbleSort();
            bsort.recursiveTimed(reDS[i], reDS[i].length);
            reTimes.add(bsort.getTime());
            reCount.add(bsort.getCount());
        }
    }

    public void printDS(int[][] dataset) {

        for(int i = 0; i < dataset.length - 1; i++) {

            for(int j = 0; j < dataset[i].length - 1; j++) {

                System.out.println(dataset[i][j]);
            }
        }
    }

    public void displayReport() throws UnsortedException {

        // Check if items are sorted

        System.out.println("o Iterative\n");
        //count | Avg Count | Stand Dev Count | Avg Time(ms) | Stan Dev Time(ms)
        System.out.println("Data Size\t|\tAvg Count\t|\tStan Dev Count\t|\tAvg Time(ms)\t|\tStan Dev Time(ms)");
        System.out.println("-------------------------------------------------------------------------------------------");
        long itTimeRes = calcAvgTime(itTimes);
        long reTimeRes = calcAvgTime(reTimes);
        long stanItTimesRes = calcStanDevTime(itTimes);
        long stanReTimesRes = calcStanDevTime(reTimes);
        long itCnt = calcCritCount(itCount);
        long reCnt = calcCritCount(reCount);
        long stanItCnt = calcStanDevCount(itCount);
        long stanReCnt = calcStanDevCount(reCount);

        System.out.print(dataset[0].length + " \t\t\t");
        System.out.print(itCnt + " \t\t\t");
        System.out.print(stanItCnt + " \t\t\t\t");
        System.out.print(itTimeRes + " \t\t\t\t\t");
        System.out.print(stanItTimesRes);
        System.out.println("\n");
        System.out.println("\n");

        // Recursive
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

    }

}
