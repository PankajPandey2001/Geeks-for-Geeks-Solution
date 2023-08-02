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
            
            int[] nm = IntArray.input(br, 2);
            
            
            int[][] a = IntMatrix.input(br, nm[0], nm[1]);
            
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.sumZeroMatrix(a);
            
            if(res.size() == 0) {
                System.out.println(-1);
                
            } else {
            
                IntMatrix.print(res);
            }        
        }
    }
}

// } Driver Code Ends


class Solution {
    
    static int rows[] = {-1 , -1} ;
        static int columns[] = {-1,-1} ; 
        
        
        static int area = -1 ; 
    
    public static ArrayList<ArrayList<Integer>> sumZeroMatrix(int[][] a) {
        // code here
        
        // static boolean isGot = false ; 
        
        rows[0] = -1 ; 
        rows[1] = -1 ; 
        columns[0] = -1 ; 
        columns[1] = -1 ; 
        
         
         
         
         area = -1 ; 
         
         
        for( int startCol = 0 ; startCol < a[0].length ; startCol++)
        {
            int dp[] = new int[a.length] ; 
            
            for( int endCol = startCol ; endCol < a[0].length ; endCol++)
            {
                for( int row = 0 ; row < a.length ; row++)
                {
                    dp[row] += a[row][endCol] ; 
                }
                
                
                helper(dp , startCol , endCol) ;
            }
        }
        
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>() ; 
        
        if( area == -1)
        return list ; 
        
        
        for( int i = rows[0] ; i <= rows[1] ; i++)
        {
            ArrayList<Integer> temp = new ArrayList<>() ; 
            
            for( int j = columns[0] ; j <= columns[1] ; j++)
            {
                temp.add(a[i][j]) ;
            }
            
            list.add(temp) ; 
        }
        
        return list ; 
    }
    public static void helper( int dp[] , int startCol , int endCol)
    {
         HashMap<Integer,Integer> map = new HashMap<>() ; 
         
         int sum = 0 ; 
         
         for( int i = 0; i < dp.length ; i++)
         {
             sum += dp[i] ; 
             
             if( sum == 0)
             {
                 update( 0 , i , startCol , endCol) ; 
             }
             else 
             {
                 if( map.containsKey(sum))
                 {
                     update( map.get(sum)+1 , i , startCol , endCol) ; 
                 }
                 else
                 map.put(sum , i) ; 
             }
         }
    }
    public static void update( int startRow , int endRow , int startCol , int endCol)
    {
              int tempArea = (endRow-startRow+1)*(endCol-startCol+1) ;
                   
                   if( tempArea > area)
                   {
                       area = tempArea ; 
                       rows[0] = startRow ; 
                       rows[1] = endRow ; 
                       columns[0] = startCol ; 
                       columns[1] = endCol ; 
                        
                   }
                   else if(tempArea == area)
                   {
                        // equal ke case mein minnimum column wala lena hai ; 
                        
                        
                        if( columns[0] < startCol)
                        return ; 
                        else if( columns[0] > startCol)
                        {
                            area = tempArea ; 
                             rows[0] = startRow ; 
                            rows[1] = endRow ; 
                          columns[0] = startCol ; 
                           columns[1] = endCol ;
                        }
                        else
                        {
                            
                            // ab bhi equal hai toh rowdekhenge ; 
                            
                            if( rows[0] < startRow)
                            {
                                return ; 
                            }
                            else if( rows[0] > startRow)
                            {
                                area = tempArea ; 
                               rows[0] = startRow ; 
                               rows[1] = endRow ; 
                              columns[0] = startCol ; 
                               columns[1] = endCol ;
                            }
                            else
                            {
                                // ab bhi same hain toh fir dekhenge row jyada ksime hain ; 
                                
                                if( rows[1] - rows[0] > endRow - startRow)
                                return ; 
                                else 
                                {
                                    area = tempArea ; 
                               rows[0] = startRow ; 
                               rows[1] = endRow ; 
                              columns[0] = startCol ; 
                               columns[1] = endCol ;
                                }
                            }
                        }
                   }
        
    }
}


