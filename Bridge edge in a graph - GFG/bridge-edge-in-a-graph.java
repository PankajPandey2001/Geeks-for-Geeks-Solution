//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int c = sc.nextInt();
            int d = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.isBridge(V,list,c,d));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/*

   REMEMBER , HO SAKTA HAI KI GRAPH PHLE SE BHI DISCONNECTED HO , FIR HUMEIN EK PARTICULAR
   CONNECTED COMPONENT MEIN SE EDGE KO HATA KE DEKHNA H KI KYA USKO HATANE SE DISCONNECTED
   COMPONENT KI COUNT BADH GAYI HAI ??
   
   so first we will count the number of disconnected components ; 
   
   
   then after assuming that we have removed that edge , now we will count the 
   number of disconnected component , if the count is same , means that edge is not
   bridge edge , otherwise that edge is bridge edge ; 
   
   
*/

class Solution
{
    //Function to find if the given edge is a bridge in graph.
    
    
    static int previousCount = 0 ; 
    static int finalCount = 0 ; 
    
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        // code here
        
        //matlab c -d ki edge agar discoonnect karde graph ko wo toh 
        // wo edge bridge edge hogi ; 
        
        if( V == 1)
        return 0 ; 
        
        if( V == 2)
        return 1 ; 
        
        
        
        previousCount = 0 ; 
        finalCount = 0 ; 
        
        
        boolean visited[] = new boolean[V] ; 
        
        
        
        
        for( int i = 0 ; i < visited.length; i++)
        {
            if( visited[i] == false )
            {
                previousCount++ ; 
                
                dfs(i , adj , visited) ; 
            }
        }
        
        
        // now remove the edges of c and d ; 
        
        
        ArrayList<Integer> list = adj.get(c) ; 
        
        for( int i = 0 ; i < list.size() ; i++)
        {
            if(list.get(i) == d)
            {
                list.remove(i) ; 
                break ; 
            }
        }
        
        list = adj.get(d) ; 
        
        for( int i = 0 ; i < list.size() ; i++)
        {
            if(list.get(i) == c)
            {
                list.remove(i) ; 
                break ; 
            }
        }
        
        
        visited = new boolean[V] ; 
        
        
        
        
        for( int i = 0 ; i < visited.length; i++)
        {
            if( visited[i] == false )
            {
                finalCount++ ; 
                
                dfs(i , adj , visited) ; 
            }
        }
       
       
       if( finalCount> previousCount)
       return 1 ; 
       else
       return 0 ; 
    }
    public static void dfs( int vertex , ArrayList<ArrayList<Integer>> adj , boolean visited[] )
    {
        
        if( visited[vertex] == true)
        return ; 
        
        visited[vertex] = true ; 
        
        
        ArrayList<Integer> list = adj.get(vertex) ; 
        
        for( int i = 0 ; i < list.size() ; i++)
        {
            
            dfs(list.get(i) , adj , visited ) ; 
            
        }
    }
}