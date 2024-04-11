/*
Author : Vandana Kumari 
Date : 11/04/2024
Problem : Gray to Binary equivalent
Problem Link : https://www.geeksforgeeks.org/problems/gray-to-binary-equivalent-1587115620/1
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
    
    // function to convert a given Gray equivalent n to Binary equivalent.
    public static int grayToBinary(int n) {
        char[] binaryRepresentation = Integer.toBinaryString(n).toCharArray();
        int length = binaryRepresentation.length;//System.out.println("First -> " + Arrays.toString(binaryRepresentation));
        for (int index = 1; index < length; index++) {
            binaryRepresentation[index] = (char)(((binaryRepresentation[index] - '0') ^ (binaryRepresentation[index - 1] - '0')) + '0');
        }
        //System.out.println("Second -> " + Arrays.toString(binaryRepresentation));
        int sum = 0;
        for (int index = 0; index < length; index++) {
            sum += (1 << index) * (binaryRepresentation[length - index - 1] - '0');
        }
        
        return sum;
        
    }
    
    private static char getXOR(char first, char second) {
        return (char)(((first - '0') ^ (second - '0')) + '0');
    }
    
}



//{ Driver Code Starts.

class GFG {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();//testcases
		while(t-->0){
		    int n = sc.nextInt();//initializing n
		    
		    Solution obj = new Solution();
		    
		    //calling grayToBinary() function
		    System.out.println(obj.grayToBinary(n));
		}
	}
}

// } Driver Code Ends