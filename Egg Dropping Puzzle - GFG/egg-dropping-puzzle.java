//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
	    
	    //reading input using BufferedReader class
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//reading total testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    
		    //reading number of eggs and floors
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    int n = Integer.parseInt(inputLine[0]);
		    int k = Integer.parseInt(inputLine[1]);
		    
		    //calling eggDrop() method of class
		    //EggDrop
		    System.out.println(new Solution().eggDrop(n, k));
		}
	}
}



// } Driver Code Ends


/*
      ISE PADHTA HI THODA BHOT HINT AA GYA THA KI BINARY SEARCH KA USE KARKE HUM
      SEARCH SPACE HAR BAAR AADHA KAR SAKTE HAIN , PAR MAIN CONSTRAINTS HAIN NUMBER
      OF EGGS , SO HUM JAB SIRF 1 EGG BACHA HOGA TAB TOH HUM LINEAR SEAARCH KAR SAKTE HAIN 
      AUR JAB 1 SE JYADA EGG HAI, TOH EGGS KA USE KARKE BINARY SEARCH KARENGE ; 
      
      
*/

class Solution 
{
    //Function to find minimum number of attempts needed in 
    //order to find the critical floor.
    static int eggDrop(int n, int k) 
	{
	    
	    int dp[][] = new int[n+1][k+1] ; 
	    
	    for( int i = 0 ; i < dp.length ; i++)
	    {
	        for( int j = 0 ; j < dp[0].length; j++)
	        {
	            dp[i][j] = -1 ; 
	        }
	    }
	    return helper( n , k , dp ) ; 
	    
	}
	static int helper( int n , int k  , int dp[][])
	{
	    // think aobut base case , we know 
	    
	    if( k == 0)
	    return 0 ; // kyonki jab koi floor h hi nhi toh kya check karenge ; 
	    
	    if( n == 1) // then we will have to check in entire floors one by one from downward
	    // kyonki uper se karenge toh andar phle hi tut jayga , so we will have to keep 
	    // checking from downward if n == 1 
	    {
	        return k ; 
	    }
	    
	    // base case-2 ; 
	    if( k == 1 )
	    return 1 ;   // if ek hi floow h toh seedha usme dekh lenge ; 
	    
	    
	    // now ab hum har possbile ways mein todhke dekhenge ande ko aur way ke har ways
	    // ko explore karenge ; 
	    
	    if( dp[n][k] != -1)
	    return dp[n][k] ; 
	    
	    int option = k ; 
	    
	    for( int i = 1 ; i <= k ; i++) // i means ki egg i th floor mein todha 
	    {
	        // if i mein todha toh 2 chances hai , ek ki egg tut gya , aur dusra ki 
	        // nhi tuta 
	        // dono case ke liye call karenge aur jo maximm hoga wo save kar lenge ; 
	        
	        
	        int temp1 = helper(n-1 , i-1 , dp) ; 
	        
	        int temp2 = helper(n , k-i, dp) ; 
	        
	        
	        int temp3 = Math.max(temp1, temp2) + 1 ; 
	        
	         
	        
	        if( temp3 < option)
	        option = temp3 ; 
	    }
	    
	    
	    dp[n][k] = option ; 
	    
	    
	    return dp[n][k] ; 
	    
	    
	    
	}
}