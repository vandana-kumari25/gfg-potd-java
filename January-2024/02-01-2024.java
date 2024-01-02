/*
    Author : Vandana Kumari
    Date : 01/01/2024
    Problem : Largest Sum Subarray of Size at least K
    Problem Link: https://www.geeksforgeeks.org/problems/largest-sum-subarray-of-size-at-least-k3121/1
    
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-->0) {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            //long answer[] = new long[(int)(n)]
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            long k = Long.parseLong(br.readLine().trim());

            Solution obj = new Solution();
            System.out.println(obj.maxSumWithK(a, n, k));
        }
    }
}



//User function Template for Java


class Solution {
    
    public long maxSumWithK(long a[], long n, long k)
    {
        long ans=Integer.MIN_VALUE,sum1=0,sum2=0;
        int j=0;
        for(int i=0;i<n;i++){
            sum1+=a[i];
            if(i-j+1==k){
                ans=Math.max(sum1,ans);
            }
            else if(i-j+1>k){
                sum2+=a[j++];
                if(sum2<0){
                    sum1-=sum2;
                    sum2=0;
                }
                ans=Math.max(ans,sum1);
            }
        }
        return ans;
    }
}