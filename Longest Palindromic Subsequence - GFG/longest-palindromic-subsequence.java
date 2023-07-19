//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String S)
    {
        int dp[][]= new int[S.length()][S.length()] ; 
        
        
        
        return helper(S , 0 , S.length()-1 , dp); 
    }
    public int helper(String s , int start , int end , int dp[][])
    {
         if( start > end)
         return 0 ; 
         
         if( start == end)
         return 1 ; 
         
         if( dp[start][end] != 0)
         return dp[start][end] ; 
         
         if( s.charAt(start) == s.charAt(end))
         {
             dp[start][end] = 2 + helper(s , start+1 , end-1 , dp) ; 
             
             return  dp[start][end] ; 
         }
         
         int option1 = helper(s , start+1 , end , dp) ; 
         int option2 = helper(s , start , end-1 , dp) ; 
         
         
          dp[start][end] = Math.max(option1 , option2) ; 
           return dp[start][end] ; 
    }
}