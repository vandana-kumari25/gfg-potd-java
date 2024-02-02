/*
Author : Vandana Kumari
Date : 02/02/2024
Problem : Implement Atoi
Problem Link: https://www.geeksforgeeks.org/problems/implement-atoi/1
*/ 


import java.util.*;

class Atoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t> 0) {
            String str = sc.nextLine();

            Solution obj = new Solution();
            int num = obj.atoi(str);

            System.out.println(num);
            t--;
        }
    }
}



//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String s) {
        // Your code here
        if (s == null || s.length() == 0) {
            return -1;
        }

        int result = 0;
        int i = 0;
        int n = s.length();
        boolean isNegative = false;

        // Check for negative sign
        if (s.charAt(0) == '-') {
            isNegative = true;
            i++;
        }

        // Iterate through the string and convert to integer
        while (i < n) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                int digit = currentChar - '0';

                // Check for overflow
                if (result > (Integer.MAX_VALUE - digit) / 10) {
                    return -1;
                }

                result = result * 10 + digit;
            } else {
                // If a non-digit character is encountered, return -1
                return -1;
            }

            i++;
        }

        // Apply the sign to the result
        return isNegative ? -result : result;
    }
}