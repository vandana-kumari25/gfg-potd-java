/*
    Author : Vandana Kumari
    Date : 01/02/2024
    Problem : Panagram Checking
    Problem Link: https://www.geeksforgeeks.org/problems/pangram-checking-1587115620/1
 */


import java.io.*;
import java.lang.*;
import java.util.*;


class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-->0) {
            String s = br.readLine().trim();

            System.out.println(new Solution().checkPangram(s)==true?1:0);
        }
    }
}

//User function template for JAVA

class Solution
{
    //Function to check if a string is Pangram or not.
    public static boolean checkPangram(String s) {
        // Array to keep track of alphabet presence.
        boolean[] present = new boolean[26];

        // Traverse through the string and mark the corresponding alphabet.
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                // Convert the character to lowercase and mark its presence.
                present[Character.toLowerCase(c) - 'a'] = true;
            }
        }

        // Check if all alphabets are present.
        for (boolean isPresent : present) {
            if (!isPresent) {
                return false;
            }
        }

        return true;
    }
}

