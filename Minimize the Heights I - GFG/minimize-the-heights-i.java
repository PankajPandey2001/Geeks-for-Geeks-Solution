//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().getMinDiff(arr, n, k);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        // code here
        
        
        
        // STEP-1 , SORT THE ARRAY ; 
        
        
        Arrays.sort(arr) ; 
        
        
        // STEP-2 ; int res = arr[n-1] - arr[0] , now we will try to minimise it ; 
        
        
          int res = arr[n-1] - arr[0] ; 
        
        // STEP-3 ; 
        
         int max = arr[n-1] - k ; 
         
         int min = arr[0] + k ; 
         
         
         for( int i = 0 ; i < n-1 ; i++)
         {
             int currMax = Math.max(arr[i] + k , max) ; 
             
             int currMin = Math.min(arr[i+1]-k , min); 
             
             
             res = Math.min(res , currMax-currMin) ; 
         }
         
         return res ; 
    }
}
