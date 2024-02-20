/*
Author : Vandana Kumari
Date : 20/02/2024
Problem : Word Break
Problem Link : https://www.geeksforgeeks.org/problems/word-break1352/1
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> dictionary = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            dictionary.add(p);
                        }
                    String s = sc.next();
                    Solution obj = new Solution();  
                    System.out.println(obj.wordBreak(n, s, dictionary));  
                    
                }
        }
}
// } Driver Code Ends




//User function Template for Java

class Solution {
    public static int wordBreak(int n, String s, ArrayList<String> dictionary) {
        // create a boolean array to store the results of subproblems
        boolean[] dp = new boolean[s.length() + 1];
        // base case: empty string can be segmented
        dp[0] = true;
        // loop through the string
        for (int i = 1; i <= s.length(); i++) {
            // loop through the dictionary
            for (String word : dictionary) {
                // check if the current substring ends with the word
                if (word.length() <= i && s.substring(i - word.length(), i).equals(word)) {
                    // if yes, update the dp array using the previous result
                    dp[i] = dp[i] || dp[i - word.length()];
                }
            }
        }
        // return the final result
        return dp[s.length()] ? 1 : 0;
    }
}