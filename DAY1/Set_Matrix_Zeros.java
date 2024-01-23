import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

//Problem Statement: Given a matrix if an element in the matrix is 0
//then you will have to set its entire column and row to 0 and then return the matrix.



//Bruteforce Solution
//Intution
//First We traverse through the entire array and mark the row and col with element with -1 so that
//during other iterations it won't cause any error.
//after marking the right columns with -1
//We traverse thr0ugh the entire array and mark -1 as 0 to get the desired output.
public class Set_Matrix_Zeros{
    public static void main(String args[]){
        //Declaring Array
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no.of rows in the array");
        int row = sc.nextInt();
        System.out.println("Enter the no.of cols in the array");
        int col = sc.nextInt();
        int[][] arr = new int[row][col];

        //Taking Input
        System.out.println("Enter the elements of the array");

        for (int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.println("Input Array");
        System.out.println(Arrays.deepToString(arr));

        for (int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(arr[i][j]==0) {
                    markRow(arr, i, j);
                    markCol(arr, i, j);
                }
            }
        }
        markZero(arr);
        System.out.println("Final Array");
        System.out.println(Arrays.deepToString(arr));
        }

    private static void markCol(int[][] arr, int row, int col) {
        for(int i=0;i<arr[0].length;i++){
                arr[i][col]=-1;
            }
        }
    public static void markRow(int [][] arr,int row,int col) {

        for(int i=0;i<arr.length;i++){
            arr[row][i]=-1;

        }

    }
    public static void markZero(int [][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==-1){
                    arr[i][j]=0;
                }
            }
        }
    }
}
