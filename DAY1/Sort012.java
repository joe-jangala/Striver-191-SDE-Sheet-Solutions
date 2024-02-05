import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Sort012 {
    /*Brute Force Approach
    * Sort the Given array to get the answer
    * TC = Nlog(N)
    * SC = O(N)
    * */

    /*
    * Better Solution
    * We know that there are only 3 elements it's 0,1,2
    * So we can use count0,count1,count2 to keep the count of the 3 different elements
    * then run count0,count1,count2 loop on the array and fill the respective elements.
    * which is the required answer
    * TC = O(2N)
    * SC = O(1)
    * */

    /*
    * Optimal Solution
    *
    * --> Dutch National Flag Algorithm
    *
    * Ex arr[] = {0,1,1,0,1,2,1,2,0,0,0}
    * Intution
    * We take 3 pointers
    * low,mid and high
    * 3 Rules
    * Everything in between [0 - low-1] ->0's extreme left
    * Eveything in between [low - mid-1] -> 1's
    * Everything in between [high - n-1] -> 2's Extreme Right
    *
    * 0 - (low-1) -> 0's
    * low - mid-1 -> 1's
    * mid - high -> Unsorted Array
    * high+1 - n-1 -> 2's
    *
    * {0,1,1,0,1,2,1,2,0,0,0}
    *  here the entire array is Unsorted
    * so,
    *   low points to index 0
    *   mid points to index 0
    *   high points to last index i.e n-1;
    *
    *
    *   a[mid] == 0
    *   swap(a[low],a[mid])
    *   low++;
    *   mid++;
    *
    *   swap the 0 with the element at low index
    *   so that still stay in the sorted order
    *   and move mid and low forward
    *
    *   a[mid] == 1
    *   mid++;
    *
    *   a[mid] == 2
    *   swap(a[mid],a[high])
    *   high--;
    *   We move only high because high might contain either 0,1 or 2
    * */
    //Code

    public static void main(String[] args) {
        int n=0;
        System.out.println("Enter the no.of elements in the array");
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();
        System.out.println("Enter the elements of the array only 0,1 or 2");
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int low=0;
        int mid=0;
        int high = n-1;
        int temp=0;
        while(mid<=high){
            if(arr[mid]==0){
                temp=arr[mid];
                arr[mid]=arr[low];
                arr[low]=temp;
                mid++;
                low++;
            }
            else if(arr[mid]==1){
                mid++;
            }
            else if(arr[mid]==2){
                temp=arr[mid];
                arr[mid]=arr[high];
                arr[high]=temp;
                high--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

/*
* Time Complexity
* In every step we sort single element
* So, TC = O(N);
*     SC = O(1);
* */



}
