//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line[] = in.readLine().trim().split("\\s+");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            int l = Integer.parseInt(line[2]);
            int r = Integer.parseInt(line[3]);
            
            Solution ob = new Solution();
            System.out.println(ob.setSetBit(x, y, l, r));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int setSetBit(int x, int y, int l, int r){
        // code here
        
        
        // int b = 1 << 0 ;
        
        // System.out.println(b) ;
        
        for( int i = l ; i <= r ; i++)
        {
            int a = 1 << (i-1) ;  // taaki set bit(1 bit) i th position par aa jaye aur baaki sab
            // bit 0 ; 
            
            
            
            int temp = y & a ; 
            
            if( temp != 0)
            {
                x = (x | a) ; 
            }
            
            
        }
        
        
        return x ; 
    }
}