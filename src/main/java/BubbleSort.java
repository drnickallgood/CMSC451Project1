/**
 * Created by nallgood on 4/4/17.
 */

public class BubbleSort implements SortInterface
{

    // how many times operations are done before finish
    public int runCount;
    private long runTime;
    private int recIndex;

    public BubbleSort() {

    }

    public int recursiveSort(int[] list, int next) {

        int temp;
        long startTime = System.currentTimeMillis();

        runCount++;

        if(next == 1) {

            return 1;
        }

        for(int i = 0; i < next-1; i++) {

            if(list[i] > list[i+1]) {

                temp = list[i + 1];
                list[i + 1] = list[i];
                list[i] = temp;
            }
        }

       long endTime = System.currentTimeMillis();

        runTime = endTime - startTime;

        return recursiveSort(list, next-1);
    }

    public void iterativeSort(int[] list) {

        int temp;

        // Count how many times method has been run
        runCount++;
       long  startTime = System.currentTimeMillis();

        for (int i = 0; i < list.length - 1; i++) {

            for (int j = 1; j < list.length - i; j++) {

                if (list[j - 1] > list[j]) {

                    temp = list[j - 1];
                    list[j - 1] = list[j];
                    list[j] = temp;
                }
            }

        }

        long endTime = System.currentTimeMillis();

        // calculate the running time in milliseconds
        runTime = endTime - startTime;

    }


    public int getCount() {

        return runCount;

    }

    public long getTime() {

        return runTime;
    }

    private void printList(int[] list) {


        for(int i = 0; i < list.length-1; i++){

            System.out.println(list[i]);
        }
    }

    public static void main(String[] args){

        int[] test = {5, 100, 1, 350, 52, 77, 200, -55};

        BubbleSort myBS = new BubbleSort();

       // myBS.iterativeSort(test);
      //  System.out.println("Iterative Running time: " + myBS.getTime() + "ms");

        // myBS.printList();

       myBS.recursiveSort(test, test.length);
       myBS.printList(test);

        System.out.println("Recursive Running time: " + myBS.getTime() + "ms");


    }

}
