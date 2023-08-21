//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the curr node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root1 = buildTree(s);
            
            s = br.readLine();
            Node root2 = buildTree(s);
            
            Solution T = new Solution();
            List<Integer> ans = T.merge(root1,root2);
            for(int i=0;i<ans.size();i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
            
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java


/*
class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}
    
*/
class Solution
{
    //Function to return a list of integers denoting the node 
    //values of both the BST in a sorted order.
    public List<Integer> merge(Node root1,Node root2)
    {
        // Write your code here
        
        Stack<Node> stack1 = new Stack<>() ; 
        
        Stack<Node> stack2 = new Stack<>() ; 
        
        
        while(root1 != null)
        {
            stack1.push(root1) ; 
            
            root1 = root1.left ; 
        }
        
        
         while(root2 != null)
        {
            stack2.push(root2) ; 
            
            root2 = root2.left ; 
        }
        
        List<Integer> list = new ArrayList<>() ; 
        
        
        
        while(stack1.size() != 0 && stack2.size()!= 0)
        {
            int val1 = stack1.peek().data ; 
            int val2 = stack2.peek().data ; 
            
            if( val1 > val2)
            {
                list.add(val2) ; 
                
                Node temp = stack2.pop() ; 
                
                fill(temp.right , stack2) ; 
            }
            else
            {
                list.add(val1) ; 
                
                Node temp = stack1.pop() ; 
                
                
                fill(temp.right  , stack1) ;
            }
        }
        
        
        if(stack1.size() != 0)
        {
            while(stack1.size()!= 0)
            {
                int val1 = stack1.peek().data ; 
                
                 list.add(val1) ; 
                
                Node temp = stack1.pop() ; 
                
                
                fill(temp.right  , stack1) ;
            }
        }
        
        
        if(stack2.size() != 0)
        {
            while(stack2.size() != 0)
            {
                int val2 = stack2.peek().data ; 
                
                list.add(val2) ; 
                
                Node temp = stack2.pop() ; 
                
                fill(temp.right , stack2) ; 
            }
        }
        
        return list ;
    }
    public void fill(Node temp , Stack<Node> stack)
    {
         while(temp != null)
         {
             stack.push(temp) ; 
             
             temp = temp.left ; 
         }
    }
}
