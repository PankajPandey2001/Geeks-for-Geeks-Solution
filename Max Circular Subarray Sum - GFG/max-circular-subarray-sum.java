//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());// input size of array
		    int arr[] = new int[n];
		    String inputLine2[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine2[i]); // input elements of array
		    }
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.circularSubarraySum(arr, n));// print the circularSubarraySum
		}
	}
}



// } Driver Code Ends


class Solution{

    // a: input array
    // n: size of array
    //Function to find maximum circular subarray sum.
    static int circularSubarraySum(int a[], int n) {
        
        // Your code here
        
        
        // find both maximum and minimum sum in the array , using simple kadane algorithm
        
        
        int max1 = Integer.MIN_VALUE ; 
        
        int max2 = Integer.MIN_VALUE ; 
        
        int totalSum = 0 ; 
        
        int sum = 0 ; 
        
        int sum2 = 0 ; 
        
        
        for( int i = 0 ; i < a.length ; i++)
        {
        
             totalSum += a[i] ; 
             
             
             
                sum += a[i] ; 
                
                
                if( a[i] > sum)
                sum= a[i] ; 
                
                if(sum > max1)
                max1 = sum ; 
                
                
                
                sum2 += (-a[i]) ;
                
                
                if( -a[i] > sum2)
                sum2 = -a[i] ;
                
                
                if( sum2 > max2)
                max2 = sum2 ; 
                
                
                
        }
        
        
        int option2 = totalSum + max2 ; 
        
        if(option2 == 0)
        return max1 ; 
        
        return Math.max(max1 , option2) ;
    }
    
}

