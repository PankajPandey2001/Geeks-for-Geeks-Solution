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
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.is_bleak(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int is_bleak(int n)
    {
        //  this question is conceptual , the thing is we know ki 32 bits ihi hoti hain
        // aur so count(set bits in any numbr) will lie from 0 to 32 ; 
        
        // so now we cant take zero as it given in quesiotn , istead of running loop in 
        // O(N) complexity , we will take only 32 previous number of the given number ; 
        // kyunoki humein 1 se 32 tak hi add karne hain 
        
        
        if( n == 1)
        return 0 ; 
        
        
        
        for( int i = 1 ;  i <= 32 ; i++)
        {
            
            int number = n - i ; 
            
            if( number <= 0)
            return 1 ; 
            
            // now countsetBits in number ; 
            
             int count = 0 ; 
             
        
            for( int j = 1 ; j <= 32 ; j++)
            {
                int bit = 1 << j ; 
                
                
                if( (number & bit) != 0)
                count++ ; 
            }
            
            // System.out.println( number + " " + count) ; 
            
            if( number + count == n)
            return 0 ; 
        }
        
        return 1 ; 
    }
}