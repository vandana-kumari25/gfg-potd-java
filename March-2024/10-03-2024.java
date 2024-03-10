/*
Author : Vandana Kumari 
Date : 10/03/2024
Problem : Remove all duplicates from a given string
Problem Link : https://www.geeksforgeeks.org/problems/remove-all-duplicates-from-a-given-string4321/1
*/



//{ Driver Code Starts
//Initial Template for Java



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String str = br.readLine().trim();

            String ans = new Solution().removeDuplicates(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution 
{
    String removeDuplicates(String str) 
    {
        Map<Character,Integer> exists = new HashMap<>();

        String ans = "";
        for(int i = 0; i < str.length(); i++)
        {
            if(!exists.containsKey(str.charAt(i)))
            {
                ans += str.charAt(i);
                exists.put(str.charAt(i), 1);
            }
        }
        
        return ans;
    }
}