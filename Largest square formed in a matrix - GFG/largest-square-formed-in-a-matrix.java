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
            String a[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            String a1[] = in.readLine().trim().split("\\s+");
            int mat[][] = new int[n][m];
            for(int i = 0;i < n*m;i++)
                mat[i/m][i%m] = Integer.parseInt(a1[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maxSquare(n, m, mat));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxSquare(int n, int m, int mat[][]){
        // code here
        
        
        int dp[][] = new int[mat.length][mat[0].length] ; 
        // we can do the quesiton with out taing dp array as well ; 
        
        int max = 0 ; 
        
        
        for( int i = n-1 ; i >= 0 ; i--)
        {
            for( int j = m-1 ; j >= 0 ; j--)
            {
                 
                 if( i == n-1 || j == m-1)
                 {
                     
                     if( mat[i][j] == 1)
                     {
                         if( 1 > max)
                         max = 1; 
                     }
                     continue ; // kyonki if without dp array liye kar re hain ; 
                     // toh 1 hai toh 1 hi rahega aur 0 hai toh 0 ; 
                 }
                 else
                 {
                     if( mat[i][j] == 0)
                     {
                         continue ; 
                     }
                     else
                     {
                         int opt = Math.min( mat[i+1][j] , mat[i][j+1]) ; 
                           
                           
                         if( mat[i+opt][j+opt] >= 1)
                         {
                             mat[i][j] = opt+1 ; 
                             
                         }
                         else
                         mat[i][j] = opt ; 
                         
                     }
                 }
                 
                 
                 if( mat[i][j] > max)
                 max = mat[i][j] ; 
            }
        }
        
        
        
        return max ; 
    }
}