//{ Driver Code Starts
import java.util.*;

class Find_Given_Element_Of_Spiral_Matrix 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[1000][1000];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().findK(arr, n, m, k));
		t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    /*You are required to complete this method*/
    int findK(int A[][], int n, int m, int k)
    {
	// Your code here
	
	    int minRow = 0 ; 
	    int maxRow = n-1 ; 
	    
	    int maxColumn = m-1 ; 
	    int minColumn = 0 ; 
	    
	     
	     int count = k ; 
	     
	    while( minRow <= maxRow && minColumn <= maxColumn)
	    {
	        // four loops needed
	        
	        if( minRow == maxRow)
	        {
	             for( int j = minColumn; j <= maxColumn ; j++)
	             {
	                 if( count == 1)
	                 return A[minRow][j] ; 
	                 
	                 count-- ; 
	             }
	             
	             continue ; 
	        }
	        else if( minColumn == maxColumn)
	        {
	              for( int j = minRow ; j <= maxRow ; j++)
	             {
	                 if( count == 1)
	                 return A[j][minColumn] ; 
	                 
	                 count-- ; 
	             }
	             
	             continue ; 
	        }
	        
	        
	           for( int j = minColumn; j <= maxColumn ; j++)
	             {
	                 if( count == 1)
	                 return A[minRow][j] ; 
	                 
	                 count-- ; 
	             }
	             
	              for( int j = minRow+1 ; j <= maxRow ; j++)
	             {
	                 if( count == 1)
	                 return A[j][maxColumn] ; 
	                 
	                 count-- ; 
	             }
	             
	             for( int j = maxColumn-1 ; j >= minColumn ; j--)
	             {
	                  if( count == 1)
	                 return A[maxRow][j] ; 
	                 
	                 count-- ; 
	             }
	             
	             for( int j = maxRow-1 ; j > minRow ; j--)
	             {
	                 if(count == 1)
	                 return A[j][minColumn] ;
	                 
	                 count-- ; 
	             }
	        
	        
	        
	        
	        
	        minRow++ ; 
	        maxRow-- ; 
	        minColumn++ ; 
	        maxColumn-- ; 
	    }
	    
	    
	    return -1 ; 
    }
}