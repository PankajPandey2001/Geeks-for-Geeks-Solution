//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        
        int dp[][] = new int[arr.length][arr.length] ; 
        
        
        for( int i = 0 ; i < dp.length ; i++)
        {
            for( int j = 0 ; j < dp.length; j++)
            {
                dp[i][j] = -1 ; 
            }
        }
        
        return helper( arr , 0 , arr.length-1 , dp ) ; 
    }
    static int helper(  int arr[] , int start , int end , int dp[][])
    {
        // base case , when only 1 matrix is there ; 
        
        
        if( end - start == 1 )// base case only 1 matrix ; 
        {
            return 0 ; 
        }
        
        if( dp[start][end] != -1)
        return dp[start][end] ; 
        
         int option1 = Integer.MAX_VALUE ; 
         
        for( int i = start+1 ; i < end ; i++)
        {
            int temp = helper(arr , start , i ,dp ) + helper(arr, i , end ,dp) ; 
            
            temp += arr[start]*arr[i]*arr[end] ; 
            
            
            if( temp < option1)
            option1 = temp ; 
        }
        
        
        
        dp[start][end] = option1 ;
        
        return dp[start][end] ; 
        
        
    }
}