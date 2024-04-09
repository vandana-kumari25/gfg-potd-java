/*
Author : Vandana Kumari 
Date : 08/04/2024
Problem : Optimal Strategy For A Game
Problem Link : https://www.geeksforgeeks.org/problems/optimal-strategy-for-a-game-1587115620/1
*/

//{ Driver Code Starts
    import java.util.*;
    import java.io.*;
    import java.lang.*;
    
    class OptimalStrategy
    {
        public static void main (String[] args) {
            
            //taking input using Scanner class
            Scanner sc = new Scanner(System.in);
            
            //taking total number of testcases
            int t = sc.nextInt();
            
            while(t-- > 0)
            {
                //taking number of elements
                int n = sc.nextInt();
                int arr[] = new int[n];
                
                //inserting the elements
                for(int i = 0; i < n; i++)
                    arr[i] = sc.nextInt();
                    
               //calling the countMaximum() method of class solve
               System.out.println(new solve().countMaximum(n, arr)); 
            }
        }
        
        
    }
    // } Driver Code Ends
    
    
    class solve
    {
        //Function to find the maximum possible amount of money we can win.
        static long countMaximum(int n, int arr[])
        {
           
            int table[][] = new int[n][n]; 
      
            for (int gap = 0; gap < n; ++gap)
            { 
                for (int i = 0, j = gap; j < n; ++i, ++j) 
                { 
                    int x = ((i + 2) <= j) ? table[i + 2][j] : 0; 
                    int y = ((i + 1) <= (j - 1)) ? table[i + 1][j - 1] : 0; 
                    int z = (i <= (j - 2)) ? table[i][j - 2] : 0; 
          
                    table[i][j]=Math.max(arr[i]+Math.min(x, y),arr[j]+Math.min(y,z)); 
                } 
            } 
            //returning the result.
            return table[0][n - 1]; 
        }
    
    }