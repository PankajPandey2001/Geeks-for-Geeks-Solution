//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maximumSumRectangle(N, M, a));
        }
    }
}
// } Driver Code Ends


// User function Template for Java


/*
    REFERENCE VIDEO - https://www.youtube.com/watch?v=mKluyW4YFvs (ANUJ BHAIYA) ; 
    
    THIS QUESTION IS COMBINATION OF DP AND KADANCE ALGROITHMS ; 
    
    
    APPROACH IS that we will take all pair of startColumn and end Column ; 
                where startCol will start from 0 , to totalColumn-1 , and end column will be in 
                inner loop starting from startCol to totalColumn-1  ; 
                
                then applyin kadane algorithm as written below
                
                
*/
class Solution {
    int maximumSumRectangle(int R, int C, int M[][]) {
        // code here
        
        
        int max = Integer.MIN_VALUE ; 
        
        for( int startCol = 0 ; startCol < C ; startCol++)
        {
            int dp[] = new int[R] ; 
            
            
            for( int endCol = startCol ; endCol < C ; endCol++)
            {
                 for( int row = 0 ; row < R ; row++)
                 {
                     dp[row] += M[row][endCol] ; 
                 }
                 
                 
                 int temp = kadane(dp) ; 
                 
                 if(temp >= max)
                max = temp ; 
            
            }
            
            
            
            
            
        }
        
        
        return max ; 
    }
    int kadane( int arr[])
    {
        int sum = Integer.MIN_VALUE ; 
        
        int tempSum = 0 ; 
        
        for( int i = 0 ; i < arr.length ; i++ )
        {
            tempSum += arr[i] ; 
            
            
            if( arr[i] > tempSum)
            tempSum = arr[i] ;
            
            
            if( tempSum > sum)
            sum = tempSum ; 
        }
        
        
        return sum ; 
    }
};