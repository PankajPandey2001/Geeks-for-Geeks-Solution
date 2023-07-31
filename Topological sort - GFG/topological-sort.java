//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new Solution().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        
        if(V!=res.length)
        return false;
        
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    static boolean isPossible = true ; 
    
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        
        isPossible = true ; 
        
        
        boolean visited[] = new boolean[V] ; 
        
        boolean stackVisited[] = new boolean[V] ;  // yhaan sure hain ki cycle exist nhi 
        // kar ri , isliye stackVisited bnana ki jaurrat hi nhi hai , par bna diya
        // taki aadat bani rahe ; 
        
        Stack<Integer> stack = new Stack<>() ; 
        
        for( int i = 0 ; i < V ; i++)
        {
            if( visited[i] == true)
            continue ; 
            
            helper( i , adj , visited , stackVisited , stack ) ; 
        }
        
        
        int answer[] = new int[stack.size()] ; 
        
        
        int index = 0 ; 
        
        while(stack.size() != 0)
        {
            answer[index] = stack.pop() ; 
            index++ ; 
        }
        
        
        
        return answer ; 
          
    }
    static void helper( int vertex , ArrayList<ArrayList<Integer>> adj , boolean visited[] , boolean  stackVisited[] , Stack<Integer> stack)
    {
        
        if(visited[vertex] == true)
        return ; 
        
        
        visited[vertex] = true ; 
        
        for( int i = 0 ; i < adj.get(vertex).size() ; i++)
        {
              helper(adj.get(vertex).get(i) , adj , visited , stackVisited , stack) ; 
        }
        
        
        stack.push(vertex) ; 
    }
}
