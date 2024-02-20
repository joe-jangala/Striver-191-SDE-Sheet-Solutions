import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Merge_Overlapping_Sub_Intervals {

    /*
     * Example Input ; [[1,3],[2,6],[8,9],[2,4],[15,18],[16,17]]
     * Output : [[1,6],[8,11],[15,18]]
     */

    /*
    * Bruteforce Approach
    * First Club the elements by sorting
    * Sort by the order of first element in the given interval
    * In any case the two intervals have the same starting range then sorting is done by the second element
    * [[1,3],[2,6],[8,9],[2,4],[15,18],[16,17]]
    * then
    * (1,3)(2,4),(2,6),(8,9),(9,11),(15,18),(16,17)
    * Start iterating over the interval
    * Check whether the interval is overlapping or not by the condition
    * if the next interval first element is smaller than the current interval second element
    * */

    //Optimal Solution
    //In this approach we will check for the next interval, if the first element is smaller then we expand the current
    //interval and stop when it's greater and add the interval to the answer list
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no.of intervals");
        int n= sc.nextInt();
        int arr[][] = new int[n][2];
        System.out.println("Enter the intervals");
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                arr[i][j]= sc.nextInt();
            }
        }
        //lambda expression to sort the 2d array
        Arrays.sort(arr,(a,b)->a[0]-b[0]);

        List<int[]> ansarr = new ArrayList<>();
        int intervalStart = arr[0][0];
        int intervalEnd = arr[0][1];

        for(int i=1;i<n;i++){
            if(arr[i][0]>intervalEnd){
                ansarr.add(new int[] {intervalStart,intervalEnd});

                //Setting the next interval
                intervalStart=arr[i][0];
                intervalEnd= arr[i][1];
            }
            else{
                intervalEnd=Math.max(intervalEnd,arr[i][1]);
            }
        }
        ansarr.add(new int[] {intervalStart,intervalEnd});

        int[][] mergedArray = ansarr.toArray(new int[ansarr.size()][]);
        System.out.println(Arrays.deepToString(mergedArray));

    }
}
