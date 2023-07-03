//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		}
	}
}


// } Driver Code Ends


//User function Template for Java

class Required implements Comparator<int[]>
{
    @Override
    public int compare( int a[] , int b[])
    {
        if(a[0] < b[0])
        {
            return -1 ; 
        }
        else
        return 1 ; 
    }
}
class Solution
{
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        // Write your code here.
        
        // we have to use min priorityQueu, and instead of adding all elements in the 
        // priority queu , we will add only the starting eleemnts of arrays , in a 2 d 
        // array , 
        // therefore to recognise to which array a elemment of pq bleongs we will 
        // add arrays in priorityq Queue instead of values ; 
        
        Required req = new Required() ; 
        
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(req) ; 
        
        for( int i = 0 ; i < arr.length ; i++)
        {
            int temp[] = {arr[i][0] , i , 0} ; 
            pq.add(temp) ; 
            
        }
        
        
        ArrayList<Integer> list = new ArrayList<>() ; 
        
        while(pq.size() > 0)
        {
            int temp[] = pq.remove() ; 
            
            list.add(temp[0]) ; 
            
            
            int row = temp[1] ; 
            int column = temp[2] ; 
            
            if(column == arr[0].length-1)
            {
                // means us sequence ka ye last element tha ; 
                continue ; 
            }
            else
            {
                int newArray[] = {arr[row][column+1] , row , column+1} ; 
                pq.add(newArray) ; 
            }
        }
        
        
        return list ; 
    }
}