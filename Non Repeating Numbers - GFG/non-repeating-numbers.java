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
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[2 * n + 2];
            for(int i = 0; i < 2 * n + 2; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int[] ans = ob.singleNumber(v);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] singleNumber(int[] nums)
    {
        // Code here
        
        int xor = 0 ; 
        
        for( int i = 0 ; i < nums.length ; i++)
        {
            xor = xor^ nums[i] ; 
        }
        
        
        int rightSetBitMask = xor & -xor ; 
        
        
        int xor1 = 0 ; 
        int xor2 = 0 ; 
        
         for( int i = 0 ; i < nums.length ; i++)
        {
            int bit = nums[i] & rightSetBitMask ; 
            
            if( bit == 0 )
            xor1 = xor1 ^ nums[i] ; 
            else
            xor2 = xor2^nums[i] ;
        }
        
        int answer[] = new int[2] ; 
        
        answer[0] = Math.min(xor1 , xor2) ; 
        answer[1] = Math.max(xor1 , xor2) ;
        
        return answer ; 
        
    }
}