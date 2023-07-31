//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.findPosition(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int findPosition(int N) {
        // code here
        
        
        // this is samw question that is power of 2 ; 
        
        // total set bit 1 , bas 2 ke power wale number mein hi hoti hai , 
        // aur uski position log(N) + 1 ; here log is of base 2 , and in java we use
        // math.log() here log is base e or base 10 , therefore to find base 2 , 
        // we will use property of log ;  loga(b) = log10(b)/log10(a)
        
        
        if( N == 0)
        return -1 ; // because set bit is case mein 0 hain ;  
        
        
        int bit = N & (N-1)  ; 
        
        
        if( bit == 0)
       {
           return ((int)(Math.log(N)/Math.log(2)) +1) ; 
       }
       else
       return -1 ; 
    }
};