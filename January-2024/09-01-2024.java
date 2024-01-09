/*
    Author : Vandana Kumari
    Date   : 09/01/2024
    Problem :  Search Pattern (KMP-Algorithm)
    Problem Link: https://www.geeksforgeeks.org/problems/search-pattern0205/1
    
 */


import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t--> 0) {
            String s, patt;
            s = sc.next();
            patt = sc.next();

            Solution obj = new Solution();

            ArrayList<Integer> res = obj.search(patt, s);
            if(res.size() == 0) {
                System.out.print(-1);
            }
            else {
                for(int i=0;i<res.size();i++) 
                    System.out.print(res.get(i)+ " ");
            }
            System.out.println();
        }
    }
}


//User function Template for Java

class Solution {

    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> result = new ArrayList<>();

        int M = pat.length();
        int N = txt.length();

        // Create lps[] that will hold the longest prefix suffix
        // values for pattern
        int[] lps = new int[M];
        computeLPSArray(pat, M, lps);

        int i = 0; // index for txt[]
        int j = 0; // index for pat[]
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }

            if (j == M) {
                result.add(i - j + 1);
                j = lps[j - 1];
            } else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }

        return result;
    }

    void computeLPSArray(String pat, int M, int[] lps) {
        int len = 0;
        int i = 1;
        lps[0] = 0;

        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}