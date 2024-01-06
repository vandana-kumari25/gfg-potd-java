/*
    Author : Vandana Kumari
    Date   : 06/01/2024
    Problem : Techfest and the Queue
    Problem Link: https://www.geeksforgeeks.org/problems/techfest-and-the-queue1044/1
    
 */


import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Taking input for
        // testcases
        while (t-- > 0) {
            long a;
            a = Long.parseLong(br.readLine().trim());

            long b;
            b = Long.parseLong(br.readLine().trim());

            Solution obj = new Solution();
            long res = obj.sumOfPowers(a, b);

            System.out.println(res);

        }
    }
}




class Solution {
    public static long sumOfPowers(long a, long b) {
        // code here
        int[] spf = new int[(int)b+1];
        Arrays.fill(spf, -1);
        if(b==1)
            return 0;
        if(a==1)
            a++;
        for(int i=2; i<=b; i++){
            if(spf[i]== -1){
                for(int j=i; j<=b; j+=i)
                    spf[j]=i;
            }
        }
        long ans = 0;
        for(int i = (int)a; i<=b; i++){
            int x=i;
            while(x!=1){
                x/=spf[x];
                ans++;
            }
        }
        return ans;
    }
}
