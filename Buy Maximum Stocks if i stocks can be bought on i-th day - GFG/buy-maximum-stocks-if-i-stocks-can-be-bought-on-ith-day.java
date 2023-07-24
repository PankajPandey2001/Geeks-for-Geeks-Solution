//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String str=br.readLine();
    		String[] starr=str.split(" ");
    		
    		//input n and d
    	    int n=Integer.parseInt(starr[0]);
    		int k= Integer.parseInt(starr[1]);
            
            starr = br.readLine().trim().split(" ");
            int[] price = new int[n];
            for(int i = 0; i < n; i++)
                price[i] = Integer.parseInt(starr[i]);
            
            Solution obj = new Solution();
            int res = obj.buyMaximumProducts(n, k, price);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int buyMaximumProducts(int n, int k, int[] price) {
        // code here
        
        // the main thing about this quesiton is that this question is of Greedy and 
        // not of dp ; 
        
        
        // the main thing is to find that this quesiton is of DP 
        
        
        int array[][] = new int[n][2] ; 
        
        for( int i = 0 ; i < price.length ; i++)
        {
            array[i][0] = price[i] ; 
            array[i][1] = i+1 ; 
        }
        
        
        
        Arrays.sort(array , (a,b) -> a[0]-b[0]) ; 
         
         int count = 0 ; 
        
        for( int i = 0 ; i < array.length ; i++)
        {
             int p = array[i][0]; 
             int c = array[i][1] ; 
             
             if( k < p )
             {
                 return count ; 
             }
             
             
             int temp =  k / p ; 
             
             if( temp <= c)
             {
                 count += temp ; 
                 k  = k % p ; 
             }
             else
             {
                count += c ; 
                k = k - p*c ; 
             }
              
         
        }
        
        
        return count ; 
    }
}
        
