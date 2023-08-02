//{ Driver Code Starts
import java.util.*;

class FindMinCost
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().maxArea(arr, n, m));
		t--;
		}
	}
}
// } Driver Code Ends


/*Complete the function given below*/

/* 
  THIS QUESTION IS IMPORTANT ,  THIS IS COMBINATION OF MAXIMUM AREA OF RECNTAGLE IN
   HISTOGRAM 
   AND 
   MATRIX ; 
   
   

*/
class Solution {
    
    public int maxArea(int M[][], int n, int m) {
        // add code here.
        
        
        int max = 0 ; 
        
        int dp[] = new int[m] ;
        
        for( int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < m ; j++)
            {
                if( M[i][j] == 0)
                {
                    dp[j] = 0 ; 
                }
                else
                {
                    dp[j] = dp[j]+ 1 ; 
                }
            }
            
            
            int temp = maxArea(dp) ; 
            
            if( temp > max)
            max = temp ; 
        }
        
        return max ; 
        
    
    }
    public int maxArea(int dp[])
    {
        // NOW THIS FUNCTINO WILL BE EXACT SAME AS FINDING LARGEST AREA IN HISTOGRAM ; 
        
         int max = 0 ; 
         
         
         int prev[] = new int[dp.length]  ; 
         
         int next[] = new int[dp.length] ; 
         
         Stack<Integer> stack = new Stack<>() ; // this stack will store index ; 
         
         
         // THIS WILL BE MONOTONIC INCREASING STACK , BY MONOTONICH STACK , HAR INDEX
         // KE LIYE USKA PREVIOUS INDEX , STACK KE TOP PAR HI MILEGA ; 
         
         for( int i = 0 ; i < prev.length ; i++)
         {
             if(stack.size() == 0)
             {
                 prev[i] = -1 ; 
                 
                 stack.push(i) ; 
             }
             else
             {
                 while(stack.size() != 0)
                 {
                     int index = stack.peek() ; 
                     
                     
                     if( dp[index] >= dp[i])
                     {
                         stack.pop() ; 
                     }
                     else
                     {
                         prev[i] = index ; 
                         stack.push(i) ; 
                         break ; 
                     }
                 }
                 
                 if(stack.size() == 0)
                 {
                     prev[i] = -1 ; 
                     stack.push(i) ; 
                 }
                 
                 
             }
         }
         
         
         // now we will fill next arr ; 
         
         
         stack = new Stack<>() ; 
         
         for( int i = next.length-1 ; i >= 0 ;  i--)
         {
             if(stack.size() == 0)
             {
                 next[i] = next.length ; 
                 
                 stack.push(i) ; 
             }
             else
             {
                 while(stack.size() != 0)
                 {
                     int index = stack.peek() ; 
                     
                     
                     if( dp[index] >= dp[i])
                     {
                         stack.pop() ; 
                     }
                     else
                     {
                         next[i] = index ; 
                         stack.push(i) ; 
                         break ; 
                     }
                 }
                 
                 if(stack.size() == 0)
                 {
                     next[i] = next.length; 
                     stack.push(i) ; 
                 }
                 
                 
             }
         }
         
         
         for( int i = 0 ; i < dp.length ; i++)
         {
             if( dp[i] * ( next[i]-prev[i]-1) > max)
             max = dp[i] *  ( next[i]-prev[i]-1) ; 
         }
         
         
         return max ; 
         
    }
    
}