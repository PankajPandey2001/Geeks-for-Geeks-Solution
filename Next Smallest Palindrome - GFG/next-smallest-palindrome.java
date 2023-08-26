//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int num[] = new int[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(str[i]);
            }

            Vector<Integer> ans = new Solution().generateNextPalindrome(num, n);
            for (Integer x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// exectption hai agar number mein sirf 9 h toh ; jaise 9 , 9 9 , 9999 , 
// so in cases mein answer wale number mein 1 diigit jyada hogi aur wo is format ka hoga 11 , 101 , 1001 , 10001 aise

/*
   important point to remember is jitna prefix same hoga tow numbers ka wo utne hi close honge
   
   means jitni shuruaat se length ki values  same hogi , utne hi do number aapas mein close honge
   
   
   
*/

class Solution {

    Vector<Integer> generateNextPalindrome(int num[], int n) {
        // code here
        
        
        if( allNine(num) == true)
        {
            return helper1(num.length+1) ; 
            
        }
        
        
        Vector<Integer> vector = new Vector<>() ; 
        
        int i = 0 ; 
        
        
        int j = num.length-1 ; 
        
        boolean madeLarger = false; // means humein basically is number se badha par , baakiyon
        // se chhota banana hai , aur pallindrom bhi , toh hum suffix wali value ko 
        // prefix ki value ke barabaar karne ki kosish karenge; ,  
        // kyonki prefix same rakhne se , naya number purane number ke closest hoga ; 
        // so that jo naya num
        // bane wo initial num ke pass wala hi ho ; 
        
        // fir agar pallindrom bnate wakt hi naya num purane num se badha h fir toh 
        // dikkat nhi hai. par agar chhota bana toh , 
        
        
        
        // bich se number ki values badhana shuru karenge , na aage se na picche se ; 
        // means 1 4 5 6 , hai toh ye ho jayga , 1 4 4 1 , par ab pallindrome toh
        // ban gya , par chhota ho gya , so humein ise badhana hoga , aur badhane ke liye
        // bich se badhana shruru karenge ; so we wil do 1 5 5 1 ; 
        
        
        while( j - i > 1)
        {
            
            if( num[i] == num[j])
            {
                i++ ; 
                j-- ; 
                continue ; 
            }
            
            if(num[i] > num[j])
            madeLarger = true ; 
            else
            madeLarger = false ; 
            
            
            int temp = num[i] ;
            
            num[j] = temp ; 
            
            i++ ; 
            j-- ;
            
            
        }
        
        
        // for( int im = 0 ; im < num.length ; im++)
        // {
        //     System.out.print(num[im] + " ") ; 
        // }
        
        // System.out.println() ; 
        
        if( i == j)
        {
            if( madeLarger == true)
            {
                for( int idx = 0 ; idx < num.length ; idx++)
                {
                    vector.add(num[idx]) ; 
                }
                
                return vector ; 
            }
            else
            { 
                 for( int idx = 0 ; idx < num.length ; idx++)
                {
                    vector.add(num[idx]) ; 
                }
                
                
                if( num[i] != 9)
                {
                    vector.set(i , num[i]+1) ; 
                    
                    return vector ; 
                }
                else
                {
                    //  for test cases like , Num[] = {9, 4, 1, 8, 7, 9, 7, 8, 3, 2, 2}
                    
                    vector.set(i , 0) ; 
                    
                    helper2(vector , i-1 , i+1) ; 
                    
                    
                    return vector ; 
       
                }
                
                 
            }
        }
        else
        {
            
               for( int idx = 0 ; idx < num.length ; idx++)
                 {
                    vector.add(num[idx]) ; 
                }
                
                
             if( num[i] < num[j])
             {
                 madeLarger = false ; 
             }
             else if( num[i] > num[j])
             madeLarger = true ; 
             
             
             vector.set(j , vector.get(i)) ; 
             
        //      for( int im = 0 ; im < num.length ; im++)
        // {
        //     System.out.print(vector.get(im) + " ") ; 
        // }
        
        // System.out.println(madeLarger + " " +  vector.get(i)) ; 
        
             if(madeLarger == true)
             return vector ; 
             
             if( num[i] == 9)
             {
                 vector.set(i , 0) ; 
                 
                 vector.set(j , 0 ) ; 
                 
                 helper2(vector , i-1 , j+1) ; 
             }
             else
             {
                 vector.set(i , vector.get(i)+1) ; 
                  vector.set(j , vector.get(j)+1) ;
                  
                  
             }
             
             return vector ; 
             
        }
    }
    public void helper2( Vector<Integer> vector , int i , int j )
    {
         while( i > 0)
         {
             if( vector.get(i) != 9)
             {
                 vector.set(i , vector.get(i)+1) ; 
                 vector.set(j , vector.get(j)+1) ; 
                 
                 return  ; 
             }
             else
             {
                 vector.set(i , 0) ; 
                 vector.set(j , 0) ;
                 
                 i-- ; 
                 j++ ; 
             }
         }
    }
    public boolean allNine(int num[])
    {
        for( int i = 0 ; i < num.length ; i++)
        {
            if( num[i] != 9)
            return false ; 
        }
        
        
        return true ; 
    }
    public Vector<Integer> helper1( int length)
    {
        Vector<Integer> vector = new Vector<>() ; 
        
        if( length == 1)
        {
            vector.add(1) ; 
            vector.add(1) ; 
            
            return vector ; 
        }
        
        
        vector.add(1) ; 
        int i = 1 ; 
        
        while( i < length-1)
        {
            vector.add(0) ; 
            i++ ; 
        }
        
        
        vector.add(1) ; 
        
        return vector ; 
    }
}