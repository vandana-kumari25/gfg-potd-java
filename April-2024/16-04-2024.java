/*
Author : Vandana Kumari 
Date : 16/04/2024
Problem : Minimize the Difference
Problem Link : https://www.geeksforgeeks.org/problems/minimize-the-difference/1
*/

//{ Driver Code Starts
    import java.io.*;
    import java.util.*;
    
    
    class IntArray
    {
        public static int[] input(BufferedReader br, int n) throws IOException
        {
            String[] s = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(s[i]);
    
            return a;
        }
    
        public static void print(int[] a)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    
        public static void print(ArrayList<Integer> a)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    class GFG {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t;
            t = Integer.parseInt(br.readLine());
            while(t-- > 0){
                
                int n;
                n = Integer.parseInt(br.readLine());
                
                
                int k;
                k = Integer.parseInt(br.readLine());
                
                
                int[] arr = IntArray.input(br, n);
                
                Solution obj = new Solution();
                int res = obj.minimizeDifference(n, k, arr);
                
                System.out.println(res);
                
            }
        }
    }
    
    // } Driver Code Ends
    
    
    
    class Solution {
        public static int minimizeDifference(int n, int k, int[] arr) {
            // code here
            int rightmx[]=new int[n];
            int rightmn[]=new int[n];
            rightmx[n-1]=arr[n-1];
            rightmn[n-1]=arr[n-1];
            for(int i=n-2;i>=0;i--){
                rightmn[i]=Math.min(rightmn[i+1],arr[i]);
                rightmx[i]=Math.max(rightmx[i+1],arr[i]);
            }
            int i=0,j=k-1,mn=Integer.MAX_VALUE,mx=Integer.MIN_VALUE,ans=Integer.MAX_VALUE;
            while(j<n){
                if(i!=0){
                    mn=Math.min(arr[i-1],mn);
                    mx=Math.max(arr[i-1],mx);
                }
                int temp1=mx,temp2=mn;
                if(j!=n-1){
                    temp1=Math.max(mx,rightmx[j+1]);
                    temp2=Math.min(mn,rightmn[j+1]);
                }
                ans=Math.min(ans,Math.abs(temp1-temp2));
                i++;
                j++;
            }
            return ans;
        }
    }
            
    