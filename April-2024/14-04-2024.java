/*
Author : Vandana Kumari 
Date : 14/04/2024
Problem : Xoring and Clearing
Problem Link : https://www.geeksforgeeks.org/problems/xoring-and-clearing/1
*/

//{ Driver Code Starts
    import java.util.*;

    class GFG {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int arr[] = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }
                Solution obj = new Solution();
                obj.xor1ToN(n, arr);
                obj.printArr(n, arr);
                obj.setToZero(n, arr);
                obj.printArr(n, arr);
            }
            sc.close();
        }
    }
    
    // } Driver Code Ends
    
    
    // User function Template for Java
    class Solution {
        public void printArr(int n, int arr[]) {
            // code here
            for(int i:arr){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    
        public void setToZero(int n, int arr[]) {
            // code here
            for(int i=0; i<n; i++){
                arr[i] = 0;
            }
        }
    
        public void xor1ToN(int n, int arr[]) {
            // code here
            
            for(int i=0; i<n; i++){
                arr[i] = arr[i]^i;
            }
            // printArr(n,arr);
        }
    }
