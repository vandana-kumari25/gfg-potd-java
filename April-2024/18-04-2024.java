/*
Author : Vandana Kumari 
Date : 18/04/2024
Problem : Two Repeated Elements
Problem Link : https://www.geeksforgeeks.org/problems/two-repeated-elements-1587115621/1
*/

//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    for(int i=0;i<t;i++){
	        int n = Integer.parseInt(br.readLine());
	        String l = br.readLine();
    		String[] sarr = l.split(" ");
    		int[] arr = new int[sarr.length];
    		for(int i1=0;i1<arr.length;i1++){
    			arr[i1] = Integer.parseInt(sarr[i1]);
    		}
    		
            Solution obj = new Solution();
            
            int[] res = obj.twoRepeated(arr, n);
            System.out.println(res[0] + " " + res[1]);
	    }
	}
}
// } Driver Code Ends


//User function template for JAVA

class Solution
{
    //Function to find two repeated elements.
    public int[] twoRepeated(int arr[], int n)
    {
        // Your code here
        ArrayList<Integer>list=new ArrayList<>();
     
        
        int []count=new int[n+1];
        
        for(int i=0;i<arr.length;i++){
            if(count[arr[i]]>0){
                list.add(arr[i]);
            }
            else{
                count[arr[i]]++;
            }
        }
        
        int[] ans=new int[list.size()];
        int t=0;
        for(int a:list){
            ans[t]=a;
            t++;
        }
        
        return ans;
    }
    
}