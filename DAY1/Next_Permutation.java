import java.util.Arrays;
import java.util.Scanner;

public class Next_Permutation {

    /*
    * Next Permutation
    *
    * Problem Statement
    * Find Next Permutation
    *
    * Bruteforce Approach
    * -> Generate all permutations and find the given permutaion with linear search
    * -> Return the next permutation according to it
    * -> if there's no next permutation return the first permutation
    *
    * Time Complexity = O(N!*N )
    *
    * Better Approach
    *
    * in C++ there's an STL function next_permutation which directly returns the next permutation
    *
    *
    * Optimal Approach
    *
    * 1.next permutation will have longer prefix match I
    * 2.You have to find the breakpoint which is the element of which right side elements are smaller
    * Ex. in the array [2,1,5,4,3,0,0] 1 is the break point.
    * You have to find the dip of the values in the array.
    * If there's no dip then it's the last permutation.
    *  i     = 1;
    *  i+1   = 5;
    * In the right of the 1 we have to find the element which is sligtly greater than 1 here we take 3
    *
    * Now it's 2,3
    *3. try to place remaining elements in sorted order
    *Which is the required Next Permutation
    *
    * TC = O(3N);
    * SC = O(1);
    * */


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=0;
        int breakpoint=-1;
        System.out.println("Enter the no.of elements in the array");
        n= sc.nextInt();
        System.out.println("Enter the elements of the array");
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]= sc.nextInt();
        }
        for(int index=n-2;index>=0;index--){
                if(arr[index]<arr[index+1]){
                    breakpoint=index;
                    break;
                }
        }
        if(breakpoint==-1){
            //return reverse array;
            int start= 0;
            int end= n-1;
            while(start<end){
                int temp= arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
                start++;
                end--;
            }
            System.out.println(Arrays.toString(arr));
            return;

        }

        for(int i=n-1;i>=breakpoint;i--){
            if(arr[i]>arr[breakpoint]){
                //swap the arr[i] and arr[breakpoint]
                //break;
                int temp= arr[i];
                arr[i]=arr[breakpoint];
                arr[breakpoint]=temp;
                break;
            }
        }
        int start= breakpoint+1;
        int end= n-1;
        while(start<end){
            int temp= arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
        //Now reverse the elements after the breakpoint to get the answer.
        //rev(arr,breakpoint,n-1);

        System.out.println(Arrays.toString(arr));

    }

    //Algorithm Explanation
    /*
    * - First we will check for the longest prefix match;
    * - It can be found by finding the dip in the values from reverse, we can call it as a breakpoint;
    * - After finding the breakpoint we have to find the next smallest greater element from the element at breakpoint index;
    * - And swap them, even after swapping them the order won't be disturbed.
    * - After swapping them we want the right side elements to be smallest approach is sorting but they are already in reverse order.
    * - So we just reverse the right part of array to get the next permutation.
    * */


}
