//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();

            Solution ob = new Solution();
            int cnt = ob.setBits(N);
            System.out.println(cnt);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    static int setBits(int N) {
        // code here
        
       
       // by kernigan's method by summet malik sir ; 
       
       
       // first method is simpley running the loop from 0 to 31 , and returning the count
       // of set bits ; 
       
       
       
       // second method is , by kernigansmethod
       
       
       int count = 0 ; 
       
       
       while( N != 0)
       {
           int num = N & -N ; 
           
           N = N - num ; 
           
           
           count++ ; 
       }
       
       
       return count ; 
    }
}