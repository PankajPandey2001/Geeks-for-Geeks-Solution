//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) 
    {
        // your code here
        
        
        // for every index , we will find the previous and next index whose. value is just
        // smaller than the value at that index , 
        
        int prev[] = new int[hist.length] ;  // hint is that we will do this quesiton with the 
        // help of stack , 
        
        
        
        
        int next[] = new int[hist.length] ; 
        
        
        Stack<Integer> stack = new Stack<>() ; // it is MONOTONIC INCREASING STACK ; 
        
        for( int i = 0 ; i < prev.length ; i++)
        {
            if(stack.size() == 0)
            {
                prev[i] = -1 ; 
                stack.push(i) ; 
            }
            else
            {
                 while(stack.size() != 0)
                 {
                     int index = stack.peek() ; 
                     
                     if( hist[index] >= hist[i])
                     {
                         stack.pop() ; 
                     }
                     else
                     {
                         prev[i] = index ; 
                         
                         stack.push(i) ; 
                         break ; 
                     }
                 }
                 
                 if(stack.size() == 0)
                 {
                     prev[i] = -1 ;
                     stack.push(i) ; 
                 }
            }
        }
        
        
        
        stack = new Stack<>() ; 
        
        
        
        for( int i = next.length-1 ; i>= 0 ; i--)
        {
            if(stack.size() == 0)
            {
                next[i] = next.length ; 
                stack.push(i) ; 
            }
            else
            {
                 while(stack.size() != 0)
                 {
                     int index = stack.peek() ; 
                     
                     if( hist[index] >= hist[i])
                     {
                         stack.pop() ; 
                     }
                     else
                     {
                         next[i] = index ; 
                         
                         stack.push(i) ; 
                         break ; 
                     }
                 }
                 
                 if(stack.size() == 0)
                 {
                     next[i] = next.length ;
                     stack.push(i) ; 
                 }
            }
        }
        
        
        long max = 0 ; 
        
        
        for( int i = 0 ; i < hist.length ; i++)
        {
            
             long temp = (long)(next[i] - prev[i] -1) * hist[i] ; 
             
             if( temp >= max )
             max = temp ; 
        }
        
        
        return max ; 
    }
        
}



