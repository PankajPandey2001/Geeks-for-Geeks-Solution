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
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            int[][] ans = obj.searchWord(grid, word);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
            if(ans.length==0)
            {
                System.out.println("-1");
            }

        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[][] searchWord(char[][] grid, String word)
    {
        
        int dir[][] = {{-1,0} , {1,0} , {0,-1} , {0,1} , {-1 , 1} , {-1,-1} , {1,-1} , {1,1}} ;
        
        
        List<List<Integer>> answer = new ArrayList<>() ; 
        
        
        for( int i = 0 ; i <  grid.length ; i++)
        {
            for( int j = 0 ; j < grid[0].length ; j++)
            {
                if( grid[i][j] != word.charAt(0))
                 {
                     continue ; 
                 }
                 
                 
                 for(int k = 0 ; k < dir.length ; k++)
                 {
                     boolean temp = helper( grid , i , j , 0 , word , dir[k] ) ;
                     
                     if( temp == true)
                     {
                         List<Integer> curr = new ArrayList<>() ; 
                         
                         curr.add(i) ; 
                         curr.add(j) ; 
                         
                         answer.add(curr) ; 
                         
                         break ; 
                     }
                 }
            }
        }
        
        
        int array[][] = new int[answer.size()][2] ; 
        
        for( int i = 0 ; i < answer.size() ; i++)
        {
            List<Integer> curr = answer.get(i) ; 
            
            
            array[i][0] = curr.get(0) ; 
            
            array[i][1] = curr.get(1) ; 
        }
        return array ; 
    }
    public boolean helper(char grid[][] , int row , int column , int index , String word , int dir[])
    {
        
        if( index == word.length())
        return true ; 
        
        if( row < 0 || row  >= grid.length || column < 0 || column >= grid[0].length)
        {
            return false ; 
        }
        
        
        if( grid[row][column] != word.charAt(index))
        return false ; 
        
        return helper( grid , row + dir[0] , column + dir[1] , index+1 , word , dir) ; 
    }
}