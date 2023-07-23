//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

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

class Driverclass
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n =Integer.parseInt(in.readLine().trim());
            String s[] = in.readLine().trim().split(" ");
            Node head = new Node(Integer.parseInt(s[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(s[i]));
                tail = tail.next;
            }

            head = new Solution().segregate(head);
            printList(head, out);
            out.println();
        }
        out.close();
    }
    
    public static void printList(Node head,PrintWriter out)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}




// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        // add your code here
        
        
        Node zeroHead = null ; 
         Node zeroTail = null ; 
          Node oneHead = null ;
           Node oneTail = null ;
            Node twoHead = null ;
             Node twoTail = null ;
             
             
             while( head != null)
             {
                 if( head.data == 0 )
                 {
                     if(zeroHead == null)
                     {
                         zeroHead = head ; 
                         zeroTail = head ; 
                         
                     }
                     else
                     {
                         zeroTail.next = head ; 
                         zeroTail = head ; 
                     }
                 }
                 else if( head.data == 1)
                 {
                     if(oneHead == null)
                     {
                         oneHead = head ; 
                         oneTail = head ; 
                         
                     }
                     else
                     {
                         oneTail.next = head ; 
                         oneTail = head ; 
                     }
                 }
                 else
                 {
                     if(twoHead == null)
                     {
                         twoHead = head ; 
                         twoTail = head ; 
                         
                     }
                     else
                     {
                         twoTail.next = head ; 
                         twoTail = head ; 
                     }
                 }
                 
                 head = head.next ; 
             }
             
             if(oneTail != null)
             oneTail.next = null ;
             
             if(zeroTail != null)
            zeroTail.next = null ; 
            
            if(twoTail != null)
            twoTail.next = null ; 
            
            
            if( zeroHead == null)
            {
                if(oneHead == null)
                {
                    return twoHead ; 
                }
                else
                {
                    oneTail.next = twoHead; 
                    return oneHead ; 
                }
            }
            else
            {
                if(oneHead == null)
                {
                    zeroTail.next = twoHead ; 
                    return zeroHead ; 
                }
                else
                {
                    zeroTail.next = oneHead ; 
                    
                    if(twoHead == null)
                    return zeroHead ; 
                    
                    oneTail.next = twoHead ; 
                    
                    return zeroHead ; 
                }
            }
        
    }
}


