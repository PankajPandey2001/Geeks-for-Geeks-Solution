//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.subLinkedList(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* Structure of Linked list node

class Node
{
	int data;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
}

*/

class Solution
{
    
    static int length1 = 0 ; 
    static int length2 = 0 ; 
    
    static Node subLinkedList(Node l1, Node l2)
    {
        // code here
        
        
        // in question there is few test cases in which there 
        // are 0's in front ; 
        
        
        l1 = trim(l1) ; 
        l2 = trim(l2) ; 
        
        
        if( l1 == null && l2 == null)
        {
            Node temp = new Node(0) ; 
            return temp ; 
        }
        
        if( l1 == null)
        return l2 ; 
        
        
        if( l2 == null)
        return l1 ;
        length1 = 0; 
        
        length2 = 0 ; 
        
        int greater = count(l1 , l2) ; 
        
        Node min = null ; 
        Node max = null ; 
        
        if(length1 > length2) // means linkedlist l1 is larger
        {
            // do nothing 
            
            min = l2 ; 
            max = l1 ; 
        }
        else if( length1 < length2)
        {
            max = l2 ; 
            min = l1 ; 
            
        }
        else
        {
            if( greater == 1)
            {
                 min = l2 ; 
                max = l1 ; 
            }
            else if( greater == 2)
            {
                max = l2 ; 
                min = l1 ; 
            }
            else // means number are equal so return 0 ;
            {
               Node temp = new Node(0) ; 
                return temp ; 
            }
        }
        
        // System.out.println("length1 + " + " " + length1 + " "  + length2 + "  greater = " + greater); 
        
        
        max = reverse(max) ; 
        min = reverse(min) ; 
        
        
        
        Node answer = subtract(max , min) ; 
        
        
        
         answer = reverse(answer) ;
         
         
         return trim(answer) ; 
        
        
    }
    public static Node trim(Node l1)
    {
        while( l1 != null && l1.data == 0)
        {
            l1 = l1.next ; 
        }
        
        return l1 ; 
        
    }
    public static Node subtract( Node max , Node min)
    {
        int carry = 0 ; 
        
         Node head = null ; 
         Node tail = null ; 
         
         
        while( max != null && min != null)
        {
            int data1 = max.data + carry ; 
            
            
            carry = 0 ; 
            
            int data2 = min.data  ; 
            
            if(data1 < data2)
            {
                data1  = data1 + 10 ; 
                
                carry = -1 ;
            }
            
            // System.out.println( data1 + " " + data2 + " " + (data1-data2)) ; 
            Node newNode = new Node(data1 - data2) ; 
            
            if(head == null)
            {
                head = newNode ; 
                tail = newNode ;
            }
            else
            {
                tail.next = newNode ; 
                tail = tail.next ; 
            }
            
            max = max.next ; 
            min = min.next ; 
        }
        
        if( max == null && min == null)
        return head ; 
        
        if( min == null)
        {
            
             while ( carry == -1 )
            {
                int tempData = max.data + carry ; 
                
                
                if(tempData < 0)
                {
                    carry = -1 ; 
                    tempData = tempData + 10 ; 
                }
                else
                {
                    carry = 0 ; 
                }
                
                if( tempData == 0 && max.next == null)
                {
                    return head ; 
                }
                else
                {
                    Node newNode = new Node(tempData) ; 
                    tail.next = newNode ; 
                     tail = tail.next ; 
                     max = max.next ; 
                }
                
            }
            
            while( max != null)
            {
                 Node newNode = new Node(max.data) ; 
                    tail.next = newNode ; 
                     tail = tail.next ; 
                     max = max.next ; 
            }
        }
        
        
        
        return head ; 
    }
    public static Node reverse(Node l1 )
    {
         Node prev = null ; 
         Node after = null ; 
         
         
          while( l1 != null)
         {
             after = l1.next ; 
             l1.next = prev ; 
             prev = l1 ; 
             l1 = after ; 
         }
         
         
         
         return prev ; 
    }
    public static int count(Node l1 , Node l2)
    {
        
        
        int greater = -1 ; 
        
        while(l1 != null && l2 != null )
        {
            if(l1.data > l2.data && greater == -1)
            {
                greater = 1 ; 
                
                length1++ ; 
                length2++ ;
            }
            else if(l1.data < l2.data && greater == -1 )
            {
                greater = 2 ; 
                
                length1++ ; 
                length2++ ; 
            }
            else
            {
                length1++ ; 
                length2++ ; 
            }
            
            
            l1 = l1.next ; 
            l2 = l2.next; 
        }
        
        
        
        
        if(l1 != null)
        {
            length1 += 10; 
            
        }
        else if( l2 != null)
        {
            length2 += 10 ; 
        }
        
        
        return greater ; 
    }
}