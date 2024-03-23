/*
Author : Vandana Kumari 
Date : 23/03/2024
Problem : Fibonacci series up to Nth term
Problem Link : https://www.geeksforgeeks.org/problems/fibonacci-series-up-to-nth-term/1
*/


//{ Driver Code Starts
    import java.io.*;
    import java.util.*;
    
    class Main {
        // Driver code
        public static void main(String[] args) throws Exception {
            BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0) {
                int n = Integer.parseInt(br.readLine().trim());
                Solution obj = new Solution();
                int ans[] = obj.Series(n);
                for (int i : ans) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
    }
    // } Driver Code Ends
    
    
    



class Solution {

    int[] Series(int n) {
        // code here
        int fib[]=new int[n+1];
        if(n==1){
            fib[0]=0;
        }
        if(n==2){
            fib[0]=0;
            fib[1]=1;
        }
        fib[0]=0;
        fib[1]=1;
        int i=2;
        n-=2;
        int m=1000000007;
        while(n>=0){
            fib[i]=((fib[i-1])%m+(fib[i-2])%m)%m;
            i++;
            n--;
        }
        return fib;
    }
}