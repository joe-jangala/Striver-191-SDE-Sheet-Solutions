import java.util.Scanner;

/*Problem statement
 *  Maximum Subarray Sum in an Array
 *  Explanation
 *  In this problem we have to return the maximum sum that can be formed by the consecutive elements[Sub array]
 *   in the array and return the max sum.*/

// Intution
// There are multiple ways of solving this problem, Kadane's algorithm is the optimal approach to solve this problem

// KADANE'S Algorithm
       /* Here we iterate over the entire array and keep a running sum for the elements
        * whenever the sum gets negative we make sum =0
        * we keep updating the max value if sum is greater than max
        * at the end we return the max value.
        */
//Example Input
//[-2,1,-3,4,-1,2,1,-5,4]
//output =6;
// Ans : [4,-1,2,1]


public class Maxsubarray {

    public static void main(String[] args) {
        int n=0;
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the no of elements");
        n=sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<n;i++){
            sum=sum+arr[i];
            if(sum>max){
                max=sum;
            }
            if(sum<0){
                sum=0;
            }

        }
        System.out.println(max);

    }


}
