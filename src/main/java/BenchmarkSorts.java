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
            bsort.recursiveSort(reDS[i], reDS[i].length);
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

    public void displayReport() {

        // Average Time

        long itTimeRes = calcAvgTime(itTimes);
        long reTimeRes = calcAvgTime(reTimes);
      System.out.println("--- Average Time ---\n");
        System.out.println("Iterative -  " + dataset[0].length +  " items: " + itTimeRes + "ms");
        System.out.println("Recursive -  " + dataset[0].length +  " items: " + reTimeRes + "ms");
      System.out.println();

        // Standard Deviation of Time

        long stanItTimesRes = calcStanDevTime(itTimes);
        long stanReTimesRes = calcStanDevTime(reTimes);

       System.out.println("--- Standard Deviation of Time ---\n");
        System.out.println("Iterative - " + dataset[0].length +  " items: " + stanItTimesRes + "ms");
        System.out.println("Recursive - " + dataset[0].length +  " items: " + stanReTimesRes + "ms");
       System.out.println();

       // Calc Avg of Crit operation count

        long itCnt = calcCritCount(itCount);
        long reCnt = calcCritCount(reCount);
        System.out.println("--- Average Critical Operation Count ---\n");
        System.out.println("Iterative - " + dataset[0].length +  " items: " + itCnt);
        System.out.println("Recursive - " + dataset[0].length +  " items: " + reCnt);
        System.out.println();

        // Calc standard deviation of critical operation count

        long stanItCnt = calcStanDevCount(itCount);
        long stanReCnt = calcStanDevCount(reCount);

        System.out.println("--- Standard Deviation of Critical Operation Count ---\n");
        System.out.println("Iterative - " + dataset[0].length +  " items: " + stanItCnt);
        System.out.println("Recursive - " + dataset[0].length +  " items: " + stanReCnt);
        System.out.println();

    }

}
