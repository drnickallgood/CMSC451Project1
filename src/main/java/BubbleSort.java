/**
 * Created by nallgood on 4/4/17.
 */

public class BubbleSort implements SortInterface
{

    // how many times operations are done before finish
    private   long runCount = 0;
    private   static long reCount = 0;
    private   long runTime = 0;
    private  static long reRunTime = 0;
    private boolean sortedFlag = false;

    public long recursiveSort(int[] list, int next) {

        int temp;

        if(next == list.length-1) {

            return reCount;
        }

        if(list[next] > list[next+1]) {

            reCount++;
            temp = list[next + 1];
            list[next + 1] = list[next];
            list[next] = temp;
        }

        recursiveSort(list, next+1);

        return reCount;
    }

    public void recursiveTimed(int[] list, int next) {

        long startTime = System.currentTimeMillis();

        recursiveSort(list, next);

        long endTime = System.currentTimeMillis();

        reRunTime = endTime - startTime;

        //System.out.println(reRunTime);

        sortedFlag = true;

    }

    public void iterativeSort(int[] list) {

        int temp;
        boolean flag = true;

        // Count how many times method has been run

       long startTime = System.currentTimeMillis();

       while(flag) {

           flag = false;

           for(int i = 0; i < list.length - 1; i++) {

               if(list[i] > list[i+1]) {

                   temp = list[i];
                   list[i] = list[i+1];
                   list[i+1] = temp;
                   flag = true;

                   runCount++;
               }

           }

       }

        long endTime = System.currentTimeMillis();

        // calculate the running time in milliseconds
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

    public long getReTime(){

        return reRunTime;
    }

    public long getReCount() {

        return reCount;
    }

    private void printList(int[] list) {


        for(int i = 0; i < list.length-1; i++){

            System.out.println(list[i]);
        }
    }


}
