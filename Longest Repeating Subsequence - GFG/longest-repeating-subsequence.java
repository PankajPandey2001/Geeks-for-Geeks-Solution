//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java


/*
    LONGEST COMMON SUSBSEQUENCE NIKAL DO STRING KA KHUD HI KE SAATH 
    
    BUT AISA TOH PURI HI STRING LCS HO JAYGI , KYONKI STRING TOH DONO SAME HAIN 
    
    ISME HUMEIN DHYAAN YE RAKHNA H KI JAB HUM STRING KE CHARACTER KO EQUAL MAAN RE HAIN 
    KHUD HI KE SAATHL LCS NIKALTE WAKT TOH , SAME INDEX WALON KO EQUAL NHI MAANENGE , 
    EQUAL TAB MAANENGE JAB CHARACTER SAME HO PAR INDEX ALAG HO 
    
    
    

*/
class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
        // code here
        
        int dp[][] = new int[str.length()][str.length()] ; 
        
         for( int i = 0 ; i < dp.length ; i++)
         {
             for( int j = 0 ; j < dp[0].length ; j++)
             {
                 dp[i][j] = -1 ; 
             }
         }
        
        
        return helper(str.length()-1 , str.length()-1 , str , dp ) ;
    }
    public int helper(int index1 , int index2 , String str , int dp[][] )
    {
        if( index1 < 0 || index2 < 0)
        return  0 ; 
        
        if( dp[index1][index2] != -1)
        return dp[index1][index2] ; 
        
        
       if( str.charAt(index1) == str.charAt(index2))
       {
           if( index1 != index2)
           {
               dp[index1][index2] = helper(index1-1 , index2-1 , str , dp) + 1 ; 
               return  dp[index1][index2] ;
           }
           
       }
       
       int option1 = helper(index1-1 , index2 , str , dp ) ; 
       int option2 = helper(index1 , index2-1 , str, dp ) ; 
       
       dp[index1][index2] = Math.max(option1, option2) ; 
       
       return dp[index1][index2] ;
    }
}