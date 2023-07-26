//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestCommonPrefix(String arr[], int n){
        // code here
        
        
        String temp = arr[0] ; 
        
        for( int i = 1 ; i < arr.length ; i++)
        {
               
               String s = arr[i] ;
               
               int j = 0 ; 
               
               for( j = 0 ; j < Math.min(temp.length(), s.length()) ; j++ )
               {
                  if(s.charAt(j) != temp.charAt(j))
                  {
                       break ; 
                  }
               }
               
               temp = temp.substring(0 , j) ; 
        }
        
        if(temp.length() == 0)
        return "-1" ;
        return temp ; 
    }
}