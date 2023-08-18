//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.maxOnes(a, n));
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution {

    public static int maxOnes(int a[], int n) {
        // Your code goes here
        
        int left = -1 ;
        
        int right = -1 ; 
        
        int temp = 0 ; 
        
        int max = 0 ; 
        
        int i = 0 ; 
        
        
        int j = 0 ; 
        
        while( j < a.length)
        {
            int no = a[j] ; 
            
            
            if( no == 1)
            {
                temp-- ; 
            }
            else
            temp++ ; 
            
            if( temp < 0)
            {
                temp = 0 ; 
                
                j++ ; 
                i = j ; 
            }
            else
            {
                if( temp > max )
                {
                    max = temp ; 
                    left = i ; 
                    right =j ; 
                }
                
                j++ ; 
                
            }
        }
        
        // System.out.println(left + " " + right) ; 
        int answer = 0 ; 
        
        for( int k= 0 ; k < a.length ; k++)
        {
            if( k >= left && k<= right)
            {
                if(a[k] == 0)
                answer++ ;
            }
            else
            {
                if(a[k] ==1)
                answer++; 
            }
        }
        
        
        
        return answer ; 
        
           
    }
}
