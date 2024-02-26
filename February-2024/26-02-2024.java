/*
Author : Vandana Kumari 
Date : 26/02/2024
Problem : Power Set
Problem Link : https://www.geeksforgeeks.org/problems/power-set4302/1
*/


//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        // Code here
        int n = s.length();
        ArrayList<String>res=new ArrayList<>();
        
        for (int m = 0; m < (1 << n); m++) 
        {
            String sb = "";
            for (int i = 0; i < n; i++) 
            {
                if ((m & (1 << i))!=0)
                    sb += s.charAt(i);
            }
            
            if (sb.length() > 0)
                res.add(sb);
        }
        
        Collections.sort(res);
        return res;
    }
}