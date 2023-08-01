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
            
            int[] a = IntArray.input(br, 2);
            
            
            int[][] edges = IntMatrix.input(br, a[1], 2);
            
            Solution obj = new Solution();
            int [] res = obj.minimumTime(a[0],a[1], edges);
            for(int x: res)
                System.out.print(x+" ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int [] minimumTime(int n,int m, int[][] edges) {
        // code here
        
        
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>() ; // it will contain
        // directed edge from first to second;  
        
        
        
        int degree[] = new int[n] ;  // it will store that in how many vertex , this
        // vertex is dependent , means kitne vertex ko isse phle execute hona padhega ; 
        
        
        for( int i = 0 ; i < edges.length ; i++)
        {
            int temp[] = edges[i] ; 
            
             
            int first = temp[0]-1 ;  // to bring in the 0 indexing from , before nodes
            // were from 1 to n , but when we will subtract 1 , nodes will be from 
            // 0 to n-1 ; 
            
            int second = temp[1]-1 ; 
            
            degree[second]++ ; 
            
            
            if( map.containsKey(first))
            {
                ArrayList<Integer> list = map.get(first) ; 
                list.add(second) ;
            }
            else
            {
                ArrayList<Integer> list = new ArrayList<>()  ; 
                list.add(second) ;
                map.put(first , list) ; 
            }
            
        }
        
        
        // now the approach is that , we will start from all those nodes , who are not
        // dependent on anyone, and we will execute them , then , since this work is happended
        // we will decrease the degree of all its dependent node , by 1 , 
        //and all those nodes whose degree now become 1 , we will do those works now , 
        // so for implementing this we will use queue ; 
        
        Queue<Integer> q = new LinkedList<>() ; 
        
        for( int i = 0 ; i < n ; i++)
        {
            if(degree[i] == 0)
            q.add(i) ; 
        }
        
        
        int answer[] =  new int[n] ; 
        
        q.add(null) ; 
        int level = 1 ; 
        
        while(q.size() != 1 )
        {
            Integer temp = q.remove() ; 
            
            
            if( temp == null)
            {
                q.add(temp) ; 
                level++ ; 
                continue ; 
            }
            
            answer[temp] = level ; 
            
            if( map.containsKey(temp) == false)
            continue ; 
            
            ArrayList<Integer> list = map.get(temp) ; 
            
            for( int i = 0 ; i < list.size() ; i++)
            {
                degree[list.get(i)]-- ; 
                
                if( degree[list.get(i)] == 0)
                {
                    q.add(list.get(i)) ; 
                }
            }
            
        }
        
        
        return answer ; 
    }
}
        
