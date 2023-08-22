//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[][] matrix = IntMatrix.input(br, N, N);
            
            Solution obj = new Solution();
            int res = obj.findMinOperation(N, matrix);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



/*
     THIS QUESTION IS CONCEPTUAL QUESTION , MEANS 
     
     STEP1 - for minimum steps , we will make all values equal to the maximum sum 
             ie maximum sum amongst sum of all rows and columns ; 
             
             
     STEP-2 - now here very important part , think about changes in either row 
               or column , because the changes in row will automatically handle
               the changes in column ; because the sum of changes in row is equal to 
               the sum of changes to be made in columns ;  
               
               means there will exist a way to automatically handle the increases
               in rows to manage them in different columns ; 
*/


class Solution {
    public static int findMinOperation(int N, int[][] matrix) {
        // code here
        
        
        // we have to just find the maximum sum , and then changes to be made in 
        // either rows or columns to make their this sum equal to maximumSum ; 
        // that weill be the answer ; 
        
        
        int max = Integer.MIN_VALUE ; 
        
        
        // now make a array to store either the sum of rows or column ; to 
        // avoid future work ; 
        
        
        for( int i = 0 ; i < matrix.length; i++)
        {
            int sum = 0 ; 
            
            for( int j = 0 ; j < matrix[0].length ; j++)
            {
                sum += matrix[i][j] ;  
            }
            
            if( sum > max)
            max = sum ;
        }
        
        
        ArrayList<Integer> rowSum = new ArrayList<>() ; 
        
        for( int i = 0 ; i < matrix[0].length ; i++)
        {
            
            int sum = 0 ; 
            
            for( int j = 0 ; j < matrix.length; j++)
            {
                sum += matrix[j][i] ; 
            }
            
            rowSum.add(sum) ; 
            
            if( sum > max)
            max = sum ; 
        }
        
        int answer = 0 ; 
        
        for( int i = 0 ; i < rowSum.size() ; i++)
        {
            answer += max - rowSum.get(i) ; 
        }
        
        
        return answer ; 
    }
}
        
