/**
 * Created by nallgood on 4/4/17.
 */

public class BubbleSort implements SortInterface
{

    // how many times operations are done before finish
    private static long runCount = 0;
    private static long runTime = 0;
    private boolean sortedFlag = false;

    public BubbleSort() {

    }

    public int recursiveSort(int[] list, int next) {

        int temp;

        if(next == 1) {

            return 1;
        }

        for(int i = 0; i < next-1; i++) {

            if(list[i] > list[i+1]) {

                temp = list[i + 1];
                list[i + 1] = list[i];
                list[i] = temp;

                runCount++;
            }
        }

        return recursiveSort(list, next-1);
    }

    public void iterativeSort(int[] list) {

        int temp;

        // Count how many times method has been run

       long startTime = System.currentTimeMillis();

        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 1; j < list.length - i; j++) {

                if (list[j - 1] > list[j]) {

                    temp = list[j - 1];
                    list[j - 1] = list[j];
                    list[j] = temp;

                    runCount++;
                }
            }

        }

        long endTime = System.currentTimeMillis();

        // calculate the running time in milliseconds
        runTime = endTime - startTime;

        sortedFlag = true;
    }

    public void recursiveTimed(int[] list, int next) {

        long startTime = System.currentTimeMillis();

        recursiveSort(list, next);

        long endTime = System.currentTimeMillis();

        runTime = endTime - startTime;

        sortedFlag = true;

    }

    public long getCount() {

        return runCount;

    }

    public long getTime() {

        return runTime;
    }

    public boolean getSortedFlag() {

        return sortedFlag;
    }

    private void printList(int[] list) {


        for(int i = 0; i < list.length-1; i++){

            System.out.println(list[i]);
        }
    }


}
