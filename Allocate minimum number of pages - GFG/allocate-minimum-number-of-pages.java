//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        
        
         // is question mein bas language is trah se di hai ki samajh nhi aayga ; 
         /// par ye binary serach on answers ka question 
         // isme humein maximum ko minimum karna hai ; 
         
         if( M > N)
         return -1 ; 
         
         int max = Integer.MAX_VALUE ;
         
         int min = 1 ; 
         
         int answer =  -1; 
         
         
         while( min <= max)
         {
             int mid = min + (max-min)/2 ;
             
             
             if( isPossible(A , M , mid))
             {
                 answer = mid ;
                 max = mid -1 ; 
                 
                
             }
             else
             {
                  min = mid + 1 ; 
             }
         }
         
         return answer ; 
    }
    public static boolean isPossible( int A[] , int m , int mid)
    {
        
        int temp = 0 ;
        
        for( int i = 0 ; i < A.length ; i++)
        {
            if(A[i] > mid)
            return false ;
            
            if( m == 0)
            return false ; 
            
            temp += A[i] ; 
            
            
            if(temp > mid)
            {
                m-- ; 
                
                temp = 0 ; 
                
                i-- ; 
            }
        }
        
        
        if( m < 0)
        return false ; 
        
        return true ; 
        
        
    }
}