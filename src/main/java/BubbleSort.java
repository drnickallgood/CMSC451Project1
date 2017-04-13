/**
 * Created by nallgood on 4/4/17.
 */

public class BubbleSort implements SortInterface
{

    // how many times operations are done before finish
    private   long runCount = 0;
    private   long runTime = 0;
    private boolean sortedFlag = false;
    private   long count;

    public BubbleSort() {

    }

    public BubbleSort(long count) {

        this.count = count;
    }

    public int[] newRecursive(int[] list, int next) {

        if(next == 1) {

            return list;
        }

        int temp;

        for(int i = 0; i < next; i++) {

            if(list[i+1] < list[i]) {

                temp = list[i];
                list[i] = list[i+1];
                list[i+1] = temp;
                count++;
            }
        }

        sortedFlag = true;
        return newRecursive(list, next-1);
    }

    public long recursiveSort(int[] list, int next) {

        int temp;

        long woo =+ count;

        if(next == list.length-1) {

            return woo;
        }

        if(list[next] > list[next+1]) {


            temp = list[next + 1];
            list[next + 1] = list[next];
            list[next] = temp;
            count++;
        }

        recursiveSort(list, next+1);

        sortedFlag = true;

        return woo;
    }

    public long iterativeSort(int[] list) {

        int temp=0;

        // Count how many times method has been run
           for(int i = 0; i < list.length; i++) {

               for(int j = 1; j < list.length-1; j++) {
                   count++;
                   if(list[j-1] > list[j]) {

                       temp = list[j-1];
                       list[j-1] = list[j];
                       list[j] = temp;

                   }

               }

           }

        sortedFlag = true;

        return count;
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

    public long getNewCount() {

        return count;
    }

    private void printList(int[] list) {


        for(int i = 0; i < list.length-1; i++){

            System.out.println(list[i]);
        }
    }


}
