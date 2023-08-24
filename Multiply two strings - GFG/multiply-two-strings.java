//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.math.*;

class Multiply{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String a=sc.next();
            String b=sc.next();
            Solution g=new Solution();
            System.out.println(g.multiplyStrings(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String multiplyStrings(String s1,String s2)
    {
        //code here.
        
         // number can be negative ; 
         
         if(s1.length() == 0)
        return s2 ; 
        
        if( s2.length() == 0)
        return s1 ; 
        
        
        
         
         boolean isNegative = false ; 
         
         
         if( s1.charAt(0) == '-' && s2.charAt(0) != '-')
         {
             s1 = s1.substring(1) ; 
             isNegative = true; 
         }
         else if( s1.charAt(0) != '-' && s2.charAt(0) == '-')
         {
             s2 = s2.substring(1) ;
             isNegative = true ; 
         }
         else
         {
             isNegative = false ; 
             
             
             if( s1.charAt(0) == '-' && s2.charAt(0) == '-')
             {
                 s1 = s1.substring(1) ; 
                 s2 = s2.substring(1) ; 
             }
         }
         
         
         int i = 0 ; 
         
         
         while( i < s1.length())
         {
             if( s1.charAt(i) == '0')
             {
                 i++ ; 
             }
             else
             break ;
             
         }
         
         
         if( i == s1.length())
         s1 = "" ; 
         else
         s1 = s1.substring(i) ; 
         
         
        i = 0 ; 
        
        
         while( i < s2.length())
         {
             if( s2.charAt(i) == '0')
             {
                 i++ ; 
             }
             else
             break ;
             
         }
         
         if( i == s2.length())
         s2 = "" ; 
         else
         s2 = s2.substring(i) ;
         
        
        if(s1.length() == 0)
        return s2 ; 
        
        if( s2.length() == 0)
        return s1 ; 
        
        
        // System.out.println( s1 + "  " + s2) ; 
        
        int a[] = new int[s1.length()+s2.length()] ; 
        
        
        
        
        
        
        
        
        i = s1.length()-1 ; 
        
          int pow = a.length-1 ; 
          
          while( i >= 0)
          {
              int j = s2.length()-1 ; 
              
              int k = pow ; 
              int carry = 0 ; 
              
              while( j >= 0)
              {
                   int mul1 = s1.charAt(i) - '0' ; 
                   
                   int mul2 = s2.charAt(j) - '0' ; 
                   
                   
                   int div = mul1*mul2 + carry + a[k] ; 
                   
                   int work = div % 10 ; 
                   
                   
                   carry = div / 10 ; 
                   
                   a[k] = work ; 
                   
                   k-- ; 
                   j-- ; 
                   
                   
                   
                   
              }
              
              
              if( carry != 0)
              {
                   
                   while(carry != 0)
                   {
                       int div = carry + a[k] ; 
                       
                       a[k] = div%10 ; 
                       
                       carry = div / 10 ; 
                       
                       k-- ; 
                   }
                   
                   
                   
              }
              
              
              i-- ; 
              
              pow-- ; 
              
            //   System.out.println(i + " " + pow) ; 
          }
        
        
        
        StringBuilder str = new StringBuilder() ; 
        
        
        i = 0 ; 
        
        
        while( i < a.length)
        {
            if( a[i] != 0)
            {
                break ; 
            }
            
            i++ ; 
        }
        
        
        if(isNegative == true)
       {
           str.append('-') ; 
       }
        
        while( i < a.length)
        {
            str.append(a[i]) ; 
            
            i++ ;
        }
        
        return str. toString() ; 
    }
}