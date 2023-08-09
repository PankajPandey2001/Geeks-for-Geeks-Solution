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
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.largestPrimeFactor(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long largestPrimeFactor(int N) {
        // code here
        
        int actual = N ; 
        int i = 2 ; 
        
        int answer = 2 ;
        
        while( i*i <= N)
        {
            
            if( N % i == 0)
            {
                answer = i ; 
                N = N / i ;
            }
            else
            {
                i++ ; 
            }
        }
        
        if( N != 1 )
        return N ; 
        
        
        return answer ;
    }
}