//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int[] ans = new Solution().constructLowerArray(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java





class Solution {
    int[] constructLowerArray(int[] arr, int n) {
        // code here
        
        
       List<int[]> list = new ArrayList<>() ; 
        int count[] = new int[arr.length] ; 
        
        
        for( int i = 0 ; i < arr.length ; i++)
        {
             int temp[] = new int[2] ; 
             
             
             temp[0] = arr[i] ; 
             temp[1] = i ; 
             
             list.add(temp) ; 
             
        }
        
        
        // now use same technique as striver told ; 
        
        
        helper( list , 0 , list.size()-1 , count) ; 
        
        
        return count ; 
    }
    public List<int[]> helper(  List<int[]> list , int start , int end , int count[])
    {
        
        if( start == end)
        {
            List<int[]> temp = new ArrayList<>() ; 
            
            int newArray[] = list.get(start) ; 
            
            temp.add(newArray) ; 
            
            return temp ; 
        }
        
        int mid = start + (end-start)/2 ;
        
        List<int[]> left = helper( list , start , mid , count) ; 
        
         List<int[]> right = helper( list  , mid+1  , end , count) ; 
         
         
         List<int[]> temp = new ArrayList<>() ; 
         
         int i = 0 ; 
         int j = 0 ; 
         
         while( i < left.size())
         {
             while( j < right.size())
             {
                 
                 if( right.get(j)[0] < left.get(i)[0])
                 {
                     j++ ; 
                 }
                 else
                 break ; 
             }
             
             
             count[left.get(i)[1]] += j ; 
             i++ ; 
         }
         
         
         i = 0 ; 
         j = 0 ; 
         
         while( i < left.size() && j < right.size())
         {
             if( left.get(i)[0] <= right.get(j)[0])
             {
                 temp.add(left.get(i)) ; 
                 i++ ; 
             }
             else
             {
                 temp.add(right.get(j)) ; 
                 j++ ; 
             }
         }
         
         if( j != right.size())
         {
             while( j < right.size())
             {
                 temp.add(right.get(j)); 
                 j++ ; 
             }
         }
         
         if( i != left.size())
         {
             while( i < left.size())
             {
                 temp.add(left.get(i)) ; 
                 i++ ; 
             }
         }
         
         
         return temp ; 
    }
}