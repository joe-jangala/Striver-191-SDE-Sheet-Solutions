import java.util.Scanner;


   /* Stock Buy and Sell
    * Problem Statement
    * You are given an array of stock prices for few days you have to return the max profit from the given array.
    */

    /*
    * Intution
    * Optimal Approach
    * Take 3 variables Minprice, Maxprofit,profit
    * Iterate over the array and as we iterate we check for the Minprice and update it.
    * Calculate the profit for every iteration by -> profit =arr[i]-minprice (arr[i] = stock price on that day)
    * Take the variable to store the maxprofit and update maxprofit whenever profit>maxprofit
    * At the end we return maxprofit which is the required answer.
    * */



public class Stockbuysell {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=0;
        System.out.println("Enter the no.of elements");
        n=sc.nextInt();
        int [] arr = new int[n];
        System.out.println("Enter the elements");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int minprice=Integer.MAX_VALUE;
        int profit=0;
        int maxprofit=-1;
        for(int i=0;i<n;i++){
            if(arr[i]<minprice){
                minprice=arr[i];
            }
            profit=arr[i]-minprice;
            if(profit>maxprofit){
                maxprofit=profit;
            }
        }
        System.out.println(maxprofit);
    }
}
