//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] numerator = IntArray.input(br, n);
            
            
            int[] denominator = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countFractions(n, numerator, denominator);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int countFractions(int n, int[] numerator, int[] denominator) {
        // code here
        
    
    
        int answer = 0 ; 
        
        double a[] = new double[numerator.length] ; 
        
        
        for( int i = 0 ; i < numerator.length ; i++)
        {
            double val = (double)numerator[i] / (double)denominator[i] ; 
            
            
            a[i] = val ; 
        }
        
        
        Arrays.sort(a) ; 
        
        
        
        int i = 0 ;
        int j = a.length-1 ; 
        
        
        while( i < j )
        {
            
            if( a[i] + a[j] > 1 )
            {
                j-- ; 
                continue ; 
            }
            else if( a[i] + a[j] < 1)
            { 
                i++ ;
                continue; 
            }
            else
            {
                 if( a[i] == a[j])
                 {
                     int count = 0 ; 
                     while( i <= j)
                     {
                         count++ ; 
                         i++ ; 
                     }
                     
                     
                     answer += helper(count) ; //it will givve ncr ; 
                     
                     return answer ; 
                 }
                 else
                 {
                     int left = 1 ; 
                     
                     int right = 1 ; 
                     
                     while( i < j && a[i+1] == a[i])
                     {
                         left++ ; 
                         i++ ; 
                     }
                     
                     
                     while(j > i && a[j-1] == a[j])
                     {
                         right++ ; 
                         j-- ; 
                     }
                     
                     
                     answer += left*right ; 
                     
                     i++ ; 
                     j-- ; 
                 }
            }
            
            
        }
        
        
        return answer; 
    }
    public static int helper( int n)
    {
        return (n*(n-1))/2 ; 
    }
}
        
