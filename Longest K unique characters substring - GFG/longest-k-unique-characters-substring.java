//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        
        HashMap<Character,Integer> map = new HashMap<>() ; 
        
        
        int i = 0 ; 
        
        int j = 0 ; 
        
        int length = -1 ; 
        
        while( j < s.length())
        {
            char ch = s.charAt(j) ; 
            
            
            if(map.containsKey(ch))
            {
                map.put(ch, map.get(ch)+1) ; 
            }
            else
            {
                map.put(ch , 1) ; 
            }
            
            if(map.size() == k)
            {
                length = Math.max(length , (j-i+1)) ; 
            }
            else if( map.size() > k)
            {
                i =   arrange(s , i , j , map , k ) ; 
            }
            
            j++ ; 
            
        }
        
        return length ; 
    }
    public int arrange(String s, int i , int j, HashMap<Character,Integer> map , int k )
    { 
         while( i <= j && map.size() > k )
         {
             if(map.containsKey(s.charAt(i)))
             {
                 if(map.get(s.charAt(i)) == 1)
                 {
                     map.remove(s.charAt(i)) ; 
                     i++ ; 
                     
                 }
                 else
                 {
                     map.put(s.charAt(i) , map.get(s.charAt(i))-1) ; 
                     i++ ; 
                 }
             }
         }
         
         return i  ; 
    }
}