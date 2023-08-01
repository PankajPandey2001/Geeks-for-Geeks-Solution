//{ Driver Code Starts
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
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        
        
        int dir[][] = { {-1,-2} , {-2,-1} , {-1,2} , {-2,1} , {1,-2} ,{2,-1} , {1,2} ,{2,1}} ;
        
        Queue<int[]> q = new LinkedList<>() ; 
        
        KnightPos[0]-- ;
        KnightPos[1]-- ;
        TargetPos[0]-- ; 
        TargetPos[1]-- ; 
        
        
        // we will use hashset for , keeping the record of visited cell ; 
        HashSet<String> visited = new HashSet<>() ; 
        
        
        q.add(KnightPos) ; 
        q.add(null)  ; 
        
        int level = 0 ; 
        
        while(q.size() != 1)
        {
             int temp[] = q.remove() ;
             
             
             if( temp == null)
             {
                 level++ ; 
                 q.add(temp) ; 
                 continue ; 
             }
             
             
             if( temp[0] == TargetPos[0] && temp[1] == TargetPos[1])
             {
                 return level ; 
             }
             
            String s = "" + temp[0] + "_" + temp[1] ; 
            
            if( visited.contains(s))
            {
                continue ; 
            }
            
            visited.add(s) ; 
            
            
            for( int i = 0 ; i< dir.length ; i++)
            {
                int newTemp[] = { temp[0]+dir[i][0] , temp[1]+dir[i][1]} ; 
                
                q.add(newTemp) ; 
            }
            
        }
        
        return -1 ; 
    }
}



/* 


        // alwasy remember jab minimum puchha ho toh bfs hi lagane ke kosish karo , 
        // dfs kayi baar wrong answe deta hai , 
        
        
        
class Solution
{
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        
        int dp[][] = new int[N][N] ; 
        
        return helper( KnightPos[0]-1 , KnightPos[1]-1 , TargetPos[0]-1 , TargetPos[1]-1 , N ,dp);
        
        
    }
    public int helper(int sr , int sc , int tr , int tc , int N , int dp[][])
    {
        if( sr < 0 || sr >= N || sc < 0 || sc >= N)
        return Integer.MAX_VALUE ; 
        
        
        if( sr == tr && sc == tc)
        {
            dp[sr][sc] = 0 ;
            
            return 0 ; 
        }
        
        
        if( dp[sr][sc] != 0)
        return dp[sr][sc] ; 
        
        dp[sr][sc] =  Integer.MAX_VALUE ;  // so that loop na ban jaaye ; 
        
        
        int min  = Integer.MAX_VALUE ;
        
        
        int option1 = helper(sr-1 , sc -2 , tr, tc , N , dp) ; 
        
        min = Math.min(min , option1) ; 
        
        option1 = helper(sr-2 , sc - 1 , tr, tc , N , dp) ; 
        min = Math.min(min , option1) ; 
         
          option1 = helper(sr-1 , sc + 2 , tr, tc , N , dp) ; 
          min = Math.min(min , option1) ; 
          
           option1 = helper(sr-2 , sc + 1 , tr, tc , N , dp) ; 
           min = Math.min(min , option1) ; 
           
         option1 = helper(sr+1 , sc -2 , tr, tc , N , dp) ; 
         min = Math.min(min , option1) ; 
            
             option1 = helper(sr+2 , sc - 1 , tr, tc , N , dp) ;
             min = Math.min(min , option1) ; 
             
              option1 = helper(sr+1 , sc +2 , tr, tc , N , dp) ; 
              min = Math.min(min , option1) ; 
              
               option1 = helper(sr+2 , sc +1 , tr, tc , N , dp) ; 
               min = Math.min(min , option1) ; 
        
        
        
        if( min != Integer.MAX_VALUE)
        min++ ; 
        
        dp[sr][sc] = min ; 
        
        return min ; 
        
    }
}

*/