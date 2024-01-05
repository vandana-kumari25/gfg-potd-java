/*
    Author : Vandana Kumari
    Date : 05/01/2024
    Problem : Count possible ways to construct buildings
    Problem Link: https://www.geeksforgeeks.org/problems/count-possible-ways-to-construct-buildings5007/1
    
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T--> 0) {
            int N = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            int ans = obj.TotalWays(N);
            System.out.println(ans);
        }
    }
}

class Solution
{
    public int TotalWays(int N)
    {
        // Code here
        int mod = 1000000007;
        long a=1,b=2,c=2;
        for(int i=2; i<=N;i++){
            c=(a+b)%mod;a=b;b=c;
        }
        c = (c*c)%mod;
        return (int)c;
    }
}