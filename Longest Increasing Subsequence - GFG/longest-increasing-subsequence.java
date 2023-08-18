//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[])
    {
        // code here
        
        
        List<Integer> list = new ArrayList<>() ; 
        
        
        for( int i = 0 ; i < a.length ; i++)
        {
            if( list.size() == 0)
            {
                list.add(a[i]) ; 
                continue ; 
            }
            
            
            if(a[i] > list.get(list.size()-1))
            {
                list.add(a[i]) ; 
            }
            else
            {
                insert( list , a[i]) ; 
            }
        }
        
        
        return list.size() ; 
    }
    public static void insert( List<Integer> list , int value)
    {
        int i = list.size()-1 ; 
        
        if( value < list.get(0))
        list.set(0 , value) ; 
        
        
        
        while( i >= 0)
        {
            if(list.get(i) < value)
            {
                list.set(i+1 , value) ; 
                break ; 
            }
            
            
            i-- ;
        }
        
        
        
    }
} 