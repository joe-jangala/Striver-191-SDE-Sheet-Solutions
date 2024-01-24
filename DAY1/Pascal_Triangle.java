import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pascal_Triangle {
    //This question can be asked in different ways
    //We cover 3 variations of it

    //#VARIATION 1
    //Given the value of Row and Column return the element at that row and col value in a Pascal Triangle

    public static void main(String[] args) {
        int row=0;
        int col=0;
        int n=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("To find the element in a Pascal Triangle");
        System.out.println("Enter the Row");
        row= sc.nextInt();
        System.out.println("Enter the Col");
        col=sc.nextInt();
        System.out.println(ncr(row-1,col-1));
        System.out.println("To Print the row in a Pascal Triangle");
        System.out.println("Enter the Row ");
        n=sc.nextInt();
        nrow(n);
        System.out.println("To Print the Entire Pascal Triangle ");
        System.out.println("Enter the Rows");
        n= sc.nextInt();
        System.out.println(pascalTriangle(n));
    }

    public static int ncr(int n, int r ) {
        //We know that nCr formula = n!/r!*(n-r)!
        int ans=1;
        for(int i=0;i<r;i++){
            ans=ans*(n-i);
            ans=ans/(i+1);
        }
        return ans;
    }



    //VARIATION 2
    //Problem Statement
    //Print the Nth row in a pascal triangle for given value of N;

    //Intuition
    //We know that in a Nth row there will be N elements
    //We can use the previous method for each col value to generate the entire values.
    //But we will go for a optimal solution now by analyzing the pascal triangle a bit
    //Consider 6th row [1 5 10 10 5 1] we know first and last element will always be 1
    //5 = 5/1, 10= 5*4/1*2, 10 = 5*4*3/1*2*3, 5 = 5*4*3*2/1*2*3*4
    //Here we can see a pattern between the row and col values and we code the same to get the desired output


    public static void nrow(int n){
        int ans=1;
        System.out.print(ans+" ");
        for(int i=1;i<n;i++){
            ans=ans*(n-i);
            ans=ans/i;
            System.out.print(ans+" ");
        }
    }

    //#VARIATION 3
    //Given N Value print N rows of a Pascal Triangle
    //Bruteforce solution can be taking a answer list and temporary list by adding the each elemenet by ncr method
    //in the temporary list and adding it into the final list
    //But it is not optimal because it has TC of close to n^3;
    //So we will go fot the better solution
    //if we use the method in variation two nrow then the TC can be reduced to n^2 which is the optimal solution


    public static List<Integer> generateRow(int row){
        int ans =1;
        List<Integer> temp = new ArrayList<>();
        temp.add(ans);
        for(int i=1;i<row;i++){
            ans=ans*(row-i);
            ans=ans/i;
            temp.add(ans);
        }
        return temp;
    }

    public static List<List<Integer>> pascalTriangle(int n){
        List<List<Integer>> ans = new ArrayList<>();
        for (int i=1;i<=n;i++){
            ans.add(generateRow(i));
        }
        return ans;
    }


}
