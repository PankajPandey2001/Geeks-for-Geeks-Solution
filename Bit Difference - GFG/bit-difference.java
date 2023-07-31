//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
    
    // Function to find number of bits needed to be flipped to convert A to B
    public static int countBitsFlip(int a, int b){
        
        // Your code here
        
        int count = 0 ; 
        
        for( int i = 0 ; i <= 31 ; i++)
        {
             int n = 1 << i ; 
             
             
            int bit1 = a & n ; 
            
            if( bit1 != 0 )
            bit1 = 1 ; 
            
            
            int bit2 = b & n ; 
            
            if( bit2 != 0 )
            bit2 = 1 ; 
            
            if(bit1 != bit2)
            count++ ; 
            
        }
        
        
        return count ; 
        
    }
    
    
}


//{ Driver Code Starts.

// Driver class
class Main {
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();//testcases
		int m, n;
		long ans = 0; // initialise ans to 0
		while(t-->0) {
		    
		    //input m and n
		    m = sc.nextInt();
		    n = sc.nextInt();
		    Solution obj = new Solution();
		    System.out.println(obj.countBitsFlip(m, n));
		}
	}
}


// } Driver Code Ends