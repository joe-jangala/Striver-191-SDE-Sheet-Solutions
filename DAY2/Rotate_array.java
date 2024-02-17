import java.util.Arrays;
import java.util.Scanner;

public class Rotate_array {

    //[1,2,3]
    //[4,5,6]
    //[7,8,9]

    /*
    * Rotated Matrix
    * [7,4,1]
    * [8,5,2]
    * [9,6,3]
    *
    * */

    /*Bruteforce Approach
    * Take another matrix and place column as row in other matrix
    */

    public static void main(String[] args) {
        System.out.println("Enter the size of matrix");
        int n=0;
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();
        int [][] arr = new int[n][n];
        System.out.println("Enter the elements of array");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        //Optimal Approach
        //Transpose the matrix and reverse every row to get the desired output

        //Transpose of Matrix
        int temp=0;
        for(int row=0;row<n;row++){
            for(int col=0;col<row;col++){
                temp=arr[row][col];
                arr[row][col]=arr[col][row];
                arr[col][row]=temp;

            }}
        //Reverse of Transposed matrix
        int start=0;
        int end = n-1;
        for(int i=0;i<n;i++){
            start=0;
            end=n-1;
            while(start<end){
                temp=arr[i][start];
                arr[i][start]=arr[i][end];
                arr[i][end]=temp;
                start++;
                end--;
            }
        }
        System.out.println(Arrays.deepToString(arr));
        }
}

