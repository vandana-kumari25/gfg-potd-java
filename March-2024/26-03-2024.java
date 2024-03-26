/*
Author : Vandana Kumari 
Date : 26/03/2024
Problem : Additive Sequence
Problem Link : https://www.geeksforgeeks.org/problems/additive-sequence/1
*/



//{ Driver Code Starts
    import java.util.*;

class GFG {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                String s = sc.next();
                Solution ss = new Solution();
                boolean result = ss.isAdditiveSequence(s);
                System.out.println((result == true ? 1 : 0));
            }
            sc.close();
        }
    }
    // } Driver Code Ends
    
    
    



// User function Template for Java
class Solution {
    public boolean valid(String n, int k, int num1, int num2) {
        for (int i = k; i < n.length();) {
            int num3 = num1 + num2;
            int r = 0;
            for (int j = i; j < n.length(); j++) {
                r = r * 10 + (n.charAt(j) - '0');
                if (r == num3) {
                    i = j + 1;
                    num1 = num2;
                    num2 = num3;
                    break;
                }
            }
            if (r != num3)
                return false;
        }
        return true;
    }

    public boolean isAdditiveSequence(String n) {
        int num1 = 0;
        boolean ans = false;
        Solution sol = new Solution(); // Creating an instance of Solution
        for (int i = 0; i < n.length(); i++) {
            num1 = num1 * 10 + (n.charAt(i) - '0');
            int num2 = 0;
            for (int j = i + 1; j < n.length() - 1; j++) {
                num2 = num2 * 10 + (n.charAt(j) - '0');
                ans |= sol.valid(n, j + 1, num1, num2); // Calling valid method on the instance
            }
        }
        return ans;
    }
}