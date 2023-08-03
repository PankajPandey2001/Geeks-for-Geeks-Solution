//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java



/*
      THIS IS NOT OPTIMISED APPROACH , 
      IN THIS WE ARE FINDING EVERY TIME , THE VERTEX WITH SHORTEST DISTANCE AMONGS THE
      UNVISITED VERTEX ;
      
      
      
      INSTEAD WE CAN USE PRIORITYQUEUE TO SAVE OUR TIME ; 
      
      
*/
class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        
        boolean visited[] = new boolean[V] ; 
        
        
        int distance[] = new int[V] ; 
        
        for( int i =0 ; i < distance.length ; i++)
        {
            distance[i] = Integer.MAX_VALUE ; 
        }
        
        
        distance[S] = 0 ; 
        
        
        // now humein saare vertex mein jaana hai so V-1 times tak ek loop run karenge ; 
        // aur har iteration mein unvisited vertex mein se , shortest distance wala lenge
        // aur uske neighbors ka distance update kar denge ; 
        
        
        for( int i = 0 ; i < V-1 ; i++)
        {
            
            
            // find shortes distance vertex ; 
            
            int shortest = Integer.MAX_VALUE ; 
            int index = -1 ; 
            
            for( int j = 0 ; j < distance.length ; j++)
            {
                 if(visited[j] == false && distance[j] < shortest)
                 {
                     shortest = distance[j] ; 
                     index = j ; 
                 }
            }
            
            visited[index] = true ; // ye bhot important step hai ; 
            // ye nhi kha toh TLE aayga
            
            // now for this vertex update distanc of all neighbors
            
            ArrayList<ArrayList<Integer>> temp = adj.get(index) ; 
            
            for( int j = 0 ; j < temp.size() ; j++)
            {
                ArrayList<Integer> list = temp.get(j) ; 
                
                if( visited[list.get(0)] == false && distance[list.get(0)] > distance[index] + list.get(1) )
                distance[list.get(0)] = distance[index] + list.get(1) ; 
            }
        }
        
        
        return distance ; 
        
        
    }
}

