//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

            int i = 0;
            while (i++ < E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<>();
                t1.add(u);
                t1.add(v);
                t1.add(w);
                edges.add(t1);
            }

            int S = Integer.parseInt(read.readLine());

            Solution ob = new Solution();

            int[] ptr = ob.bellman_ford(V, edges, S);

            for (i = 0; i < ptr.length; i++) System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/*
*   edges: vector of vectors which represents the graph
*   S: source vertex to start traversing graph with
*   V: number of vertices
*/
class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        
        
        int distance[] = new int[V] ;
        
        for( int i = 0 ; i < distance.length; i++)
        {
            distance[i] = 100000000 ; 
        }
        
        distance[S] = 0 ; 
        
        
        for( int i = 0 ; i < V-1 ; i++)
        {
            
            for( int j = 0 ; j < edges.size() ; j++)
            {
                
                ArrayList<Integer>temp = edges.get(j) ; 
                
                // now we will do relaxation for this edge ; 
                
                
                if( distance[temp.get(1)] > distance[temp.get(0)] + temp.get(2))
                {
                    distance[temp.get(1)] = distance[temp.get(0)] + temp.get(2) ; 
                }
                
                
            }
        }
        
        
        // to detect negative cycle ; 
        
        // ek baar dubara har edge ke liye dekhenge ki koi edge abhi bhi relax ho paa ri 
        // hai kya , agar ho paa ri hai , toh hum 
        // iska matlab negative cycle hai graph mein ;
        for( int j = 0 ; j < edges.size() ; j++)
        {
            ArrayList<Integer>temp = edges.get(j) ; 
                
                // now we will do relaxation for this edge ; 
                
                
                if( distance[temp.get(1)] > distance[temp.get(0)] + temp.get(2))
                {
                    int arr[] = {-1} ;
                    return arr ; 
                }
                
        }
        
        return distance ; 
    }
}
