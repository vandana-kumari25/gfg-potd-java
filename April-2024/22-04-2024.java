/*
Author : Vandana Kumari 
Date : 22/04/2024
Problem : Row with minimum number of 1's
Problem Link : https://www.geeksforgeeks.org/problems/row-with-minimum-number-of-1s5430/1
*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s[] = read.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            int A[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String S[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    A[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.minRow(N, M, A));
        }
    }
}

// } Driver Code Ends


// User function Template for Java



// User function Template for Java

class Solution {
    int minRow(int n, int m, int a[][]) {
        // code here
        HashMap<Integer,Integer> mp =  new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(a[i][j] == 1){
                    if( mp.get(i) == null){
                        mp.put(i,1);
                    }
                    else{
                        mp.put(i,mp.get(i)+1);
                    }
                }
            }
        }
        if (mp.size() == 0){
            return  1;
        }
        int min = Collections.min(mp.values());
        
        int cnt = 0;
        if( mp.size() !=  n){
            for(int i = 0 ;  i < n ; i++){
            if( mp.get(i) == null  ){
                cnt = i+1;
                break;
            }
        }
        }
        else{
            for(int i = 0 ;  i < n ; i++){
            if(mp.get(i) == min ){
                cnt = i+1;
                break;
            }
        }
        }
        
        return cnt;
    }
};