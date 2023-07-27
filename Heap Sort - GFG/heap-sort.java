//{ Driver Code Starts
import java.util.*;
class Heap_Sort
{
    void printArray(int arr[],int n)
    {
        //int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String args[])
    {
        Scanner sc  = new Scanner(System.in);
        Heap_Sort hs = new Heap_Sort();
        int arr[] = new int[1000000];
        int T = sc.nextInt();
        while(T>0)
        {
            int n = sc.nextInt();
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
                
            Solution ob=new Solution();
            ob.heapSort(arr,n);
            hs.printArray(arr,n);
            T--;
        }
    }
    
}



// } Driver Code Ends



/*
    
    https://www.youtube.com/watch?v=UVW0NfG_YWA&t=26s
    
    https://www.youtube.com/watch?v=ywx-Onrdx4U
    
    
    see these two videos reagaring the heap ; 
    
    
    
    heap basically ek complete binary tree hota hai , aur is complete binary tree ko 
    hum represent karte hain array ki form main ; 
    
    
    such that 
    
    if array is 0 indexing , left childrren of eveyr node which is at index i is
    
    left child = 2*i +1 ; 
    right child = 2*i+2 ; 
    
    and for every node its father is at position (i-1) / 2
    
    
    // and second most important point is , when we have to insert , we insert the 
    // number in last position (index) , then we bring that number in its right position
    by using for loop until we got its posiion 
    
    
    and when we have to remove the top , we remove the top and we bring the last element 
    at the 0 th index (it at top index) and then this time by movin that node to downard
    position until we find its right posiitno ; 
    
    
    
*/

class Solution
{
    //Function to build a Heap from array.
    void buildHeap(int arr[], int n)
    {
        // now it can be done in o(N) approach as told by anuj bhaiya ;
        
        
        // https://www.youtube.com/watch?v=UVW0NfG_YWA&t=26s
        
        
        // make max heap , 
        
        //. here n/2 -1 se bhi start kar sakte the kyonki complete tree mein non leaf ndoe
        // n/2-1 se phle phle hota hai , aur leaf node mein heapify karke koi fayda nhi ;
        for( int i = n-1 ; i >= 0 ; i--)
        {
            // build(i , arr) ;
            
            heapify( arr , n , i) ; 
        }
    }
    
    //Heapify function to maintain heap property.
    void heapify(int arr[], int n, int i)
    {
        // Your code here
        
        // now (i) se phle phle tak heapfiy karna hai ; 
        
        heapifyHelper( n , arr , i ) ; 
    }
    void heapifyHelper( int last , int arr[] , int index)
    {
        
         
         
        while( index < last )
        {
            int left = Integer.MIN_VALUE ; 
            
            if( 2*index+1 < last ) // means this child is in the range ;
            {
                 left = arr[2*index+1] ; 
            }
            
            int right = Integer.MIN_VALUE ; 
            
            if( 2*index+2 < last ) // means this child is in the range ;
            {
                 right = arr[2*index+2] ; 
            }
            
            if( left > arr[index] || right > arr[index])  // means uski sahi position nhi milli
            {
                if( left > right)
                {
                    // swap , 
                    
                    int temp = arr[index] ; 
                    arr[index] = arr[2*index+1] ; 
                    arr[2*index+1] = temp ; 
                    
                    index = 2*index + 1 ; 
                }
                else
                {
                    int temp = arr[index] ; 
                    arr[index] = arr[2*index+2] ; 
                    arr[2*index+2] = temp ; 
                    
                    index = 2*index + 2 ; 
                }
            }
            else // means position mili ; 
            {
                break ; 
            }
        }
    }
 
    //Function to sort an array using Heap Sort.
    public void heapSort(int arr[], int n)
    {
        //code here
        
        buildHeap(arr , n) ; 
        
        // for( int i = 0 ; i < arr.length ; i++ )
        // {
        //     System.out.print(arr[i] + " ") ; 
        // }
        
        int last = n-1 ; 
        
        
       while(last >= 0)
       {
           // 0 thi index wala last mein aa jayga aur last index wala 0 th index mein 
           // fir heapify kar denge;  
           
           
           int temp = arr[last] ; 
           arr[last] = arr[0] ; 
           arr[0] = temp ; 
           
           heapify(arr , last , 0 ) ; 
           
           last-- ; 
       }
    }
 }
 
 
