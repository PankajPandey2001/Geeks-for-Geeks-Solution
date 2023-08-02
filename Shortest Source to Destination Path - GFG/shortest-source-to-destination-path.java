//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        // code here
        
        // we now crammed it when shortes distance asked , use , bfs 
        
        
        if(A[0][0] == 0 || A[X][Y] == 0)
        return -1 ; 
        
        int dir[][] = {{0,-1} , {0,1} , {-1,0} , {1,0}} ;
        
        
        Queue<int[]> q = new LinkedList<>() ; 
        
        HashSet<String> set = new HashSet<>() ; 
        
        int tempo[] = {0,0} ; 
        
        
        q.add(tempo) ; 
        q.add(null) ; 
        
        
        int level = 0 ; 
        
        while(q.size()!= 1)
        {
             int temp[] = q.remove() ; 
             
             if( temp == null)
             {
                 level++ ; 
                 q.add(temp) ; 
                 continue ; 
             }
             
             if( A[temp[0]][temp[1]] == 0)
             continue ; 
             
             if( temp[0] == X && temp[1] == Y)
             {
                 return level ; 
             }
             
             String s = "" +  temp[0] + "_" + temp[1] ; 
             
             if( set.contains(s))
             continue ; 
             
             
             set.add(s) ;
             
             
             for( int i = 0 ; i < dir.length ; i++)
             {
                 int newTemp[] = new int[2] ; 
                 
                 
                 newTemp[0] = temp[0] + dir[i][0] ; 
                 
                 newTemp[1] = temp[1] + dir[i][1] ; 
                 
                 
                 if( newTemp[0] < 0 || newTemp[0] >= N || newTemp[1] < 0 || newTemp[1] >=M  )
                 {
                     continue ; 
                 }
                 
                q.add(newTemp) ; 
             }
             
        }
        
        
        return -1 ; 
        
        
    }
};