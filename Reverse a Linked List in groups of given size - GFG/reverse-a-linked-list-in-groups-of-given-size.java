//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class ReverseInSize
{
    static Node head;
    
    public static void main (String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int a1 = Integer.parseInt(s[0]);
            Node head = new Node(a1);
            Node tail = head;
            for(int i = 1; i < n; i++)
            {
                int a = Integer.parseInt(s[i]);
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail =tail.next;
            }
            
            int k = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            Node res = ob.reverse(head, k);
            printList(res,out);
            out.println();
        }
        out.close();
    }
    
    public static void printList(Node node,PrintWriter out)
    {
        while(node != null)
        {
            out.print(node.data + " ");
            node = node.next;
        }
    }
    
}


// } Driver Code Ends


/*node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution
{
    public static Node reverse(Node node, int k)
    {
        //Your code here
        
         Node head = null ; 
         Node tail = null ; 
         
        while(node != null)
        {
            int count = k-1 ; 
            Node start = node ; 
            
            while(node != null && count > 0)
            {
                node = node.next ; 
                count-- ; 
            }
            
            
            
            Node after = null ; 
            
            if( node != null)
            {
                after = node.next ; 
            }
            
            
            if( tail != null)
            {
                tail.next = reverse( start , node) ; 
                tail = start ; 
            }
            else
            {
                head = reverse(start , node) ;
                tail = start ; 
            }
            
            node = after ; 
        }
        
        
        return head ; 
        
    }
    public static Node reverse( Node start , Node end)
    {
        
        Node prev = null ; 
        Node after = null ; 
        
        while( start != null )
        {
            after = start.next ; 
            start.next = prev ; 
            prev = start ; 
            start = after ; 
            
            if( prev == end)
            break ; 
        }
        
        return prev ; 
    }
}

