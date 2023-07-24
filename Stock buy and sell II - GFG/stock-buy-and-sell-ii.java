//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] prices = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.stockBuyAndSell(n, prices);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int stockBuyAndSell(int n, int[] prices) {
        // code here
        
        // bring everything in the term of index ; 
        
        int dp[][] = new int[prices.length][2] ; 
        
        
        for( int i = 0 ; i < dp.length ; i++)
        {
            for( int j = 0 ; j < dp[0].length ; j++)
           {
               dp[i][j] = -1 ; 
           }
        }
        
        return helper( 0 , 0 , prices, dp ) ; 
    }
    public static int helper( int index , int check , int prices[], int dp[][])
    {
        
        if( index == prices.length)
        return 0 ; // konki na kharid sakte hain na bech sakte hain ; 
        
        
        if(dp[index][check] != -1)
        return dp[index][check] ; 
        
        
        int option1 = helper(index+1 , check , prices , dp) ; // kuch mat karo 
        
        
        int option2 = 0 ; 
        
        
        if( check == 1 ) // means bechna hai
        {
            option2 = prices[index] + helper(index+1 , 0 , prices , dp) ; 
        }
        else
         option2 = -prices[index] + helper(index+1 , 1 , prices , dp) ; 
         
         
         dp[index][check]= Math.max(option1 , option2) ; 
         
         return dp[index][check] ; 
        
        
    }
}
        
