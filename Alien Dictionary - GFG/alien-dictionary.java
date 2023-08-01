//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        
        /*
        
            now its very obvoius when we read the question that here we are talking
            about ordering , so , 
            
            when we talk about ordering , then topological sort comes in mind ; 
            
            
            now , for topological sort here we have to make directed edges , so that , 
            
            
            // now here har word ko har word ke saath dekhne ki jarurat nhi hai , bas ; 
            // bas current wrd ko uske agle wale ke saath dekhnege toh kaam bna jayega
            // kyonki agla wala fir aage wlaon se edge bana lega toh kaam ho jayga ; 
            
            
            
        */
        
        
        int arr[][] = new int[K][K] ; // because it is givne that first k character hain 
        // toh bas unhi ki edges store karenge ; 
        
        helper( arr , 0 , dict ) ; 
        
        
        Stack<Integer> stack = new Stack<>() ; 
        
        boolean visited[] = new boolean[K] ; 
        
        for( int i = 0 ; i < K ; i++)
        {
            if( visited[i] == true)
            continue; 
            
            dfs( i , arr , stack , visited) ; 
            
            
        }
        
        
        StringBuilder str = new StringBuilder() ; 
        
        while(stack.size() != 0)
        {
            int idx = stack.pop() ; 
            
            str.append((char)('a'+idx)) ; 
        }
        
        
        return str. toString() ; 
    }
    public void dfs( int vertex , int arr[][] , Stack<Integer> stack, boolean visited[])
    {
        if(visited[vertex] == true)
        return ;
        
        visited[vertex] = true ; 
        
        for( int i = 0 ; i < arr.length ; i++)
        {
            if( arr[vertex][i] != 1)
            continue ; 
            
            dfs( i , arr , stack , visited) ; 
        }
        
        stack.push(vertex) ; 
        
    }
    public void helper(int arr[][] , int index , String dict[])
    {
         if( index == dict.length -1 )
         return ; 
         
         String curr = dict[index] ; 
         String temp = dict[index+1] ; 
         
         for( int i = 0 ; i< Math.min(curr.length() , temp.length()) ; i++)
         {
             if(curr.charAt(i) != temp.charAt(i))
             {
                 // it means curr.charAt(i) phle aayga temp.charAt(i) ; 
                 
                 int idx1 = curr.charAt(i) - 'a' ; 
                 int idx2 = temp.charAt(i) - 'a' ; 
                 
                 arr[idx1][idx2] = 1 ; 
                 
                 break ; 
             }
         }
         
         helper(arr , index+1 , dict) ; 
    }
}