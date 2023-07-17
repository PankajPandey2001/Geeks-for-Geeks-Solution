//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
        // code here
        
        int frequency[][] = new int[26][2] ; 
        
        
        StringBuilder str = new StringBuilder() ; 
        
        
        str.append(A.charAt(0)) ; 
        
        frequency[A.charAt(0)-'a'][0] = 1 ; 
        frequency[A.charAt(0)-'a'][1] = 0 ; 
        
        
        
        for( int i = 1 ; i < A.length() ; i++)
        {
             frequency[A.charAt(i)-'a'][0]++ ; 
             frequency[A.charAt(i)-'a'][1] = i ; 
             
              char ch = 'a' ;
              int index = A.length(); 
              
             for( int j = 0 ; j < 26 ; j++)
             {
                 if( frequency[j][0] == 1 && frequency[j][1] < index)
                 {
                     index = frequency[j][1] ; 
                     ch = (char)(j + 'a') ; 
                     
                     
                    //  System.out.println(index + " " + ch) ; 
                 }
             }
             
             
             if(index == A.length())
             str.append('#'); 
             else
             str.append(ch) ; 
        }
        
        
        return str. toString() ; 
        
    }
}