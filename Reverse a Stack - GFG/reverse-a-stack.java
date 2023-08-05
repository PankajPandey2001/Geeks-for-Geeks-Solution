//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        PrintWriter out=new PrintWriter(System.out);
        
        //taking testcases
        int t = Integer.parseInt(br.readLine()); 
    	for(int i=0;i<t;i++)
    	{
            String str=br.readLine();
    		
    		//input n and d
    	    int n=Integer.parseInt(str);
    		Stack<Integer> stack=new Stack<>();
    		String str1=br.readLine();
    		String[] starr1=str1.split(" ");
    		//inserting elements in the array
    		for(int j=0;j<n;j++)
    		{
    		    stack.push(Integer.parseInt(starr1[j]));
    		}
    		//calling reverse() function
            Solution.reverse(stack);
            for(int j:stack){
                out.print(j+" ");
            }
            out.println();
         }
         out.close();
    }
}
// } Driver Code Ends


//User function Template for Java


/*
   now the point is that this question can not be done with out o(N*N) ; 
   
   but in questino it is given recursion stack ki complexity count nhi karni hai ; 
   
   
*/


/*
    APPROACH- 
    
    approach is simple , first we will pop the top element and then we wil call the 
    reverse functoin in rest of the stack ,
    
    and then jab wo call wapas aaygi toh ye element humein stack ke end mein push karna hai
    uske liye dubara recurison function call karnege insert wala jiski complexity waise toh 
    o(N) hai , toh waise complexity o(N*N) ho gyi par , recursion ki complexity nhi 
    count karni is questoi mein ; isliye 
    
    
     
*/
class Solution
{ 
    static void reverse(Stack<Integer> s)
    {
        // add your code here
        
        if(s.size() == 1 || s.size() == 0)
        return ; 
        
        int element = s.pop() ; 
        
        
        reverse(s) ; 
        
        insert( s, element) ; // this function will inser the element in the last of 
        // the stack , so the compleixty of this function will be o(N*N)  but 
       //  in the question , recursion ki complexity ko count nhi karenge ; 
        
    }
    static void insert(Stack<Integer> s , int element)
    {
         if(s.size() == 0)
         {
             s.push(element) ; 
             return ; 
         }
         
         int temp = s.pop() ; 
         
         insert(s,element) ; 
         s.push(temp) ; 
         
    }
    
    
}