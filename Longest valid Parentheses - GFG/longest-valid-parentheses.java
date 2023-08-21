//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


// RERFERENCE VIDIEO - https://www.youtube.com/watch?v=G53_EUjUYcQ&t=421s

class Solution{
    static int maxLength(String S){
        // code here
        
         int left = 0 ; 
         
         int right = 0 ; 
         
         
         int maximum = 0 ; 
         
         for( int i = 0 ; i < S.length() ; i++)
         {
             if( S.charAt(i) == '(')
             {
                 left++ ; 
             }
             else
             {
                 right++ ; 
             }
             
             
             if( left == right)
             {
                 maximum = Math.max(maximum , 2*left) ; 
             }
             else if( right > left) // means invalid ;
             {
                 left = 0 ; 
                 right = 0 ; 
             }
         }
         
         
         
         // now iterate from backward. ; and this time left should not be greater tha
         // closed bracket , means open bracket should not be greater than
         // closed bracket ; 
         
         
         //kyonki (()()( // agar piche se iterate kar re hain toh last wala 
         // open bracket kaam ka nhi , 
         
         
         left = 0 ; 
         right = 0 ; 
         
         for( int i = S.length()-1 ;  i >= 0 ; i--)
         {
             if( S.charAt(i) == '(')
             {
                 left++ ; 
             }
             else
             {
                 right++ ; 
             }
             
             
             if( left == right)
             {
                 maximum = Math.max(maximum , 2*left) ; 
             }
             else if( left > right) // means invalid ;
             {
                 left = 0 ; 
                 right = 0 ; 
             }
         }
         
         
         return maximum ; 
    }
}