/*
    Author : Vandana Kumari
    Date : 03/01/2024
    Problem : Smallest window containing 0, 1 and 2
    Problem Link: https://www.geeksforgeeks.org/problems/smallest-window-containing-0-1-and-2--170637/1
    
 */

import java.io.*;
import java.util.*;
import java.lang.*;



class GFG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // taking input for the
        while(t--> 0) {
            String s = br.readLine();
            Solution obj = new Solution();
            int ans = obj.smallestSubstring(s);

            System.out.println(ans);
        }
    }    
}


class Solution {
    public int smallestSubstring(String S) {
        // Code here
        int n = S.length();
        
        
        //initialize counts of 0, 1 & 2
        int count0 = 0, count1 = 0, count2 = 0;
        
        //initialize left & right pointers
        int left = 0, right = 0;
        
        //initialize the result
        int minLength = Integer.MAX_VALUE;
        
        while(right < n) {
            //expand the window to the right
            char currChar = S.charAt(right);
            if(currChar == '0') {
                count0++;
            }
            else if(currChar == '1') {
                count1++;
            }
            else {
                count2++;
            }
            
            //check if the curr window contains all three characters
            while(count0 > 0 && count1 > 0 && count2 > 0) {
                //update the result
                int currLength = right - left + 1;
                minLength = Math.min(minLength, currLength);
                
                //contract the window from the left
                char leftChar = S.charAt(left);
                if(leftChar == '0') {
                    count0--;
                }
                else if(leftChar == '1') {
                    count1--;
                }
                else {
                    count2--;
                }
                
                left++;
            }
            
            //move the right pointer to expand the window
            right++;
        }
        
        return(minLength == Integer.MAX_VALUE) ? -1: minLength;
    }
};
