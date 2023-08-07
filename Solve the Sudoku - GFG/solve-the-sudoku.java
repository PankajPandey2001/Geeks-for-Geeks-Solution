//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            if(ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}




// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find a solved Sudoku. 
    static boolean SolveSudoku(int grid[][])
    {
        // add your code here
        
        for( int i = 0 ; i < 9 ; i++)
        {
            for( int j = 0 ; j < 9 ; j++)
            {
                
                if(grid[i][j] != 0 )
                continue ; 
                
                
                for( int k = 1; k <= 9 ; k++)
                {
                    if(canAdd(grid, i , j , k) == true)
                    {
                        grid[i][j] = k ; 
                        boolean temp = SolveSudoku(grid) ; 
                        
                        if( temp == true)
                        return true; 
                        
                        grid[i][j]  = 0 ; 
                        
                        
                    }
                }
                
                return false ; 
            }
        }
        
        return true ; 
    }
    
    //Function to print grids of the Sudoku.
    public static boolean canAdd( int grid[][] , int row , int column , int value)
    {
        for( int ro = 0 ; ro < 9 ; ro++)
        {
            if( grid[ro][column] == value)
            return false ; 
        }
        
        
        for( int co = 0 ; co < 9 ; co++)
        {
            if( grid[row][co] == value)
            return false ; 
        }
        
        
        for( int i = 0 ; i < 9 ; i++)
        {
            int temprow = 3*(row/3) + i / 3 ; 
            int tempcolumn = 3*(column/3) + i % 3 ; 
            
            if( grid[temprow][tempcolumn] == value)
            return false ; 
        }
        
        
        
        return true; 
    }
    static void printGrid (int grid[][])
    {
        // add your code here
        
        for(int i = 0 ; i < 9 ; i++)
        {
            for( int j = 0 ; j < 9 ; j++)
            {
                System.out.print(grid[i][j] + " ") ; 
            }
        }
    }
}