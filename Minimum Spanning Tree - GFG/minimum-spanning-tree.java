//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    
	    
	    //now the approach is we will find minimum spanning tree , using kruskals algorithm ; 
	    
	    
	    ArrayList<int[]> list = new ArrayList<>() ; 
	    
	    for( int i = 0 ; i < edges.length ; i++)
	    {
	        int temp[] = new int[3] ; 
	        
	        temp[0] = edges[i][0] ; 
	        temp[1] = edges[i][1] ; 
	        temp[2] = edges[i][2] ; 
	        
	        list.add(temp) ;
	    }
	    
	    
	    Collections.sort(list , (a,b) -> a[2] - b[2]) ; // to sort in the increasing order
	    // of value of edge ; 
	    
	    
	    int parent[] = new int[V] ; 
	    
	    for( int i= 0 ; i < parent.length ; i++)
	    {
	        parent[i] = i ; 
	    }
	    
	    
	    int sum = 0 ; 
	    
	    for( int i = 0 ; i < list.size() ; i++)
	    {
	        int temp[] = list.get(i) ; 
	        
	        int first  = findParent(parent , temp[0]) ; 
	        int second = findParent(parent , temp[1]) ; 
	        
	        
	        if( first == second) // means is edge ko add karne se cycle aa jaygi ; 
	        {
	            continue ; 
	        }
	        else
	        {
	            sum += temp[2] ; 
	            
	            parent[first] = second ; 
	        }
	    }
	    
	    return sum ; 
	    
	    
	    
	}
	static int findParent( int parent[] , int vertex)
	{
	    while(parent[vertex] != vertex)
	    {
	        vertex = parent[vertex] ; 
	        
	    }
	    
	    return vertex ; 
	}
}