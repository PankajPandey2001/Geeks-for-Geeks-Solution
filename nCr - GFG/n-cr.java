//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String read[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(read[0]);
            int r = Integer.parseInt(read[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.nCr(n, r));
        }
    }
}
// } Driver Code Ends


// User function Template for Java



/*


     this problem should be solve by , dynamic programming ; 
     
     
     basically to solve this quesiotn we will use pascal triangle ; 
      because any row in pascal triangle contains all combination vlaue of that row ; 
      
      
      1                  0c0
      1 1                1c0 1c1
      1 2 1              2c0 2c1 2c2
      1 3 3 1            3c0 3c1 3c2 3c3
      1 4 6 4 1          4c0 4c1 4c2 4c3 4c4
      1 5 10 5 1         5c0 5c1 5c2 5c3 5c4 5c5 ; 
      
      
      
*/



class Solution{
    static int nCr(int n, int r)
    {
        int mod = (int)Math.pow(10,9) + 7 ; 
        
        int arr[] = new int[r+1] ; // kyonki pure column tak ka banane ki jarurat nhi hai ; 
        
        arr[0] = 1 ; 
        
        while( n > 0 )
        {
            int temp[] = new int[r+1] ; 
            temp[0] = 1 ; 
            
            
            for( int i = 1 ; i <= r ; i++)
            {
                temp[i] = arr[i-1] + arr[i] ; 
                temp[i] = temp[i] % mod ; 
            }
            
            n--  ; 
            arr = temp ; 
        }
        
        
        return arr[r] ; 
    }
}