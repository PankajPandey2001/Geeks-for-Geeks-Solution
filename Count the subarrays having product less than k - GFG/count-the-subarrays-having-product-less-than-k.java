//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


class GFG {
	public static void main(String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            long k = Long.parseLong(stt.nextToken());
            
            long a[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            out.println(obj.countSubArrayProductLessThanK(a, n, k));
        }
        out.close();
	}
}


// } Driver Code Ends


//User function Template for Java


/*
edge case -1 ; 
8 25
39 40 23 37 25 27 2 36

edge case-2 ; 

*/
class Solution {
    
    public long countSubArrayProductLessThanK(long a[], int n, long k)
    {
        
        // obviousley we are going to need two pointer approach ; 
        
        int i = 0 ; 
        int j = 0 ; 
        
        long count = 0 ; 
        
        long product = 1 ; 
        
        
        while( i < a.length)
        {
            j = Math.max(j , i) ;  // for edge cases like n = 3 k = 1 and arr is 1 1 1 
             
            while( j < a.length && product * a[j] < k )
            {
                 product = product * a[j] ; 
                 j++ ; 
            }
            
            
            count += j - i   ; 
            
            if(j != i).  // ye condition lagani bh
            product = product / a[i] ; 
            
            i++ ; 
        }
        
        
        return count ; 
        
    }
}