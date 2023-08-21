//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            int ans = ob.Count(matrix);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int  Count(int[][] matrix)
    {
        // code here
        
        
        int count = 0 ; 
        
        
        for( int i = 0 ; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                if( matrix[i][j] == 1)
                {
                    count += helper( matrix , i , j ) ; 
                }
            }
        }
        
        
        return count ; 
    }
    public int helper( int matrix[][] , int row , int column)
    {
          int temp = 0 ; 
          
          
          int dir[][] = {{0,1} , {0,-1} , {1,0} , {-1,0} , {1,1} ,{1,-1} , {-1,1} , {-1,-1}} ; 
          
          
          for( int i = 0 ; i < dir.length ; i++)
          {
              int tempRow = row + dir[i][0] ; 
              
              int tempColumn = column + dir[i][1] ; 
              
              
              if(tempRow < 0 || tempRow >= matrix.length || tempColumn < 0 || tempColumn >= matrix[0].length)
              {
                  continue ; 
              }
              
              if(matrix[tempRow][tempColumn] == 0)
              temp++ ; 
          }
          
          
          if(temp != 0 && temp % 2 == 0)
          return 1 ; 
          
          return 0 ; 
         
    }
}