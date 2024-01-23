/*
Author : Vandana Kumari
Date   : 23/01/2024
Problem : Course Schedule
Problem Link: https://www.geeksforgeeks.org/problems/course-schedule/1
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws Exception {
        // Create a new Scanner object for taking input from the user
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t--> 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = br.readLine().trim().split("\\s+");
            int n = Integer.parseInt(st[0]);
            int m = Integer.parseInt(st[1]);

            for(int i=0; i<n; i++) 
                list.add(i, new ArrayList<Integer>());

            ArrayList<ArrayList<Integer>> prerequisites = new ArrayList<>();
            for(int i=1; i<=m; i++) {
                String s[] = br.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(v).add(u);
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(u);
                pair.add(v);
                prerequisites.add(pair);
            }

            int[] res = new Solution().findOrder(n, m, prerequisites);

            if(res.length == 0) 
                System.out.println("No Ordering Possible");
            else {
                if(check(list, n, res) == true)
                    System.out.println("1");
                else
                    System.out.println("0");
            }
        }
    }

    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        int[] map = new int[V];
        for(int i=0; i<V; i++) {
            map[res[i]] = i;
        }
        for(int i=0; i<V; i++) {
            for(int v : list.get(i)) {
                if(map[i] > map[v]) return false;
            }
        }
        return true;
    }
}



//User function Template for Java

class Solution {
    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] inDegree = new int[n];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (ArrayList<Integer> pre : prerequisites) {
            int u = pre.get(0);
            int v = pre.get(1);
            graph.get(v).add(u);
            inDegree[u]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for (int neighbor : graph.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        if (result.size() != n) {
            // Not all tasks can be finished
            return new int[0];
        }

        int[] resArray = new int[n];
        for (int i = 0; i < n; i++) {
            resArray[i] = result.get(i);
        }

        return resArray;
    }
}