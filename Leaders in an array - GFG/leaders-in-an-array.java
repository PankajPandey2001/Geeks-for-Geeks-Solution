//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Array {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		
		while(t-->0){
		    
		    //input size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //inserting elements in the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    StringBuffer str = new StringBuffer();
		    ArrayList<Integer> res = new ArrayList<Integer>();
		  
		    //calling leaders() function
		    res = obj.leaders(arr, n);
		    

		    for(int i=0; i<res.size(); i++){
		        ot.print(res.get(i)+" ");
		    }
		    
		    ot.println();
		}
		ot.close();
		
	}
}

// } Driver Code Ends


class Solution{
    //Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        
        
        ArrayList<Integer> list= new ArrayList<>() ; 
        
        list.add(arr[arr.length-1]) ; 
        
        int large = arr[arr.length-1] ;
        
        
        for( int i = arr.length-2 ; i >= 0 ; i--)
        {
            if( arr[i] >= large)
            {
                large = arr[i] ; 
                
                list.add(arr[i]) ; 
            }
        }
        
        
       int i = 0 ; 
       int j = list.size()-1 ; 
       
       while ( i < j )
       {
           int temp = list.get(j) ; 
           
           list.set(j , list.get(i)) ; 
           
           
           list.set(i , temp) ;
           
           
           i++ ; 
           j-- ; 
       }
        
        
        return list ; 
    }
}
