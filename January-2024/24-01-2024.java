/*
Author : Vandana Kumari
Date   : 24/01/2024
Problem : Check if a given graph is tree or not
Problem Link: https://www.geeksforgeeks.org/problems/is-it-a-tree/1
*/

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Input number of test cases
        while (t-- > 0) {
            int n = sc.nextInt(); // Number of vertices in the graph
            int m = sc.nextInt();

            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
            for(int i=0; i<m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                ArrayList<Integer> edge = new ArrayList<>();
                edge.add(u);
                edge.add(v);
                edges.add(edge);
            }

            Solution obj = new Solution();
            boolean res = obj.isTree(n, m, edges);

            if(res == true) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}


//User function Template for Java
class Solution {
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) 
    {
        // code here
        if(n-m!=1) return false;
        ArrayList<Integer>[] adj = new ArrayList[n];
        int arr[] = new int[n];
        
        for(int i=0; i<n; i++) adj[i] = new ArrayList<>();
        
        for(int i=0; i<m; i++){
            adj[edges.get(i).get(0)].add(edges.get(i).get(1));
            adj[edges.get(i).get(1)].add(edges.get(i).get(0));
        }
        
        dfs(0,adj,arr);
        
        for(int k : arr) if(k==0) return false;
        
        return true;
        
    }
    
    void dfs(int n, ArrayList<Integer>[] adj, int arr[]){
        arr[n] = 1;
        for(int x : adj[n]) if(arr[x]==0) dfs(x,adj,arr);
    }
}