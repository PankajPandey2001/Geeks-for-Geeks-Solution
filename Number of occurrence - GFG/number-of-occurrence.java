//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        
        
        // to do it in log n, find the upper bound of(x+1) and also found the
        // lower bound of x-1 , by this , we will find the range in which x is present
        // and then subtract (upper bound of x-1) from (upper bound of x+1 ) ; 
        
        
        
        int right = binaryUpper(arr , x+1) ; 
        
        int left = binaryLower(arr , x-1) ; 
        
        // System.out.println(right + " " + left) ; 
        
        return (right-left) ; 
        
    }
    public int binaryUpper( int arr[] , int number)
    {
        int left = 0; 
        
        int right = arr.length-1 ; 
        
        while( left <= right)
        {
            
            
            int mid = left +(right-left)/2 ; 
            
            if( arr[mid] < number)
            {
                left = mid+1 ; 
            }
            else
            right = mid-1;  
        }
        
        
        return left ; 
    }
    public int binaryLower( int arr[] , int number)
    {
        int left = 0; 
        
        int right = arr.length-1 ; 
        
        while( left <= right)
        {
            
            
            int mid = left +(right-left)/2 ; 
            
            if( arr[mid] <= number)
            {
                left = mid+1 ; 
            }
            else
            right = mid-1;  
        }
        
        
        return left ; 
    }
}