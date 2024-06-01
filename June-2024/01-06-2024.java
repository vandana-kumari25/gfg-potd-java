/*
Author : Vandana Kumari 
Date : 01/06/2024
Problem : Odd Even Problem
Problem Link : https://www.geeksforgeeks.org/problems/help-nobita0532/1
*/

//{ Driver Code Starts
    import java.io.*;
    import java.util.*;
    
    class GFG {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t;
            t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
    
                String s;
                s = br.readLine();
    
                Solution obj = new Solution();
                String res = obj.oddEven(s);
    
                System.out.println(res);
            }
        }
    }
    
    // } Driver Code Ends
    
    
    
    class Solution {
        public static String oddEven(String s) {
            // code here
            int x = 0, y = 0;
            int[] count = new int[26];
            
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0) {
                    if (count[i] % 2 == 0 && (i + 1) % 2 == 0) {
                        x++;
                    } else if (count[i] % 2 == 1 && (i + 1) % 2 == 1) {
                        y++;
                    }
                }
            }
            
            int sum = x + y;
            return (sum % 2 == 1) ? "ODD" : "EVEN";
        }
    }
    