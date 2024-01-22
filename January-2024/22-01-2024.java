/*
Author : Vandana Kumari
Date   : 22/01/2024
Problem : Paths from root with a specified sum
Problem Link: https://www.geeksforgeeks.org/problems/paths-from-root-with-a-specified-sum/1
*/

import java.util.*;
import java.io.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
} 

class GFG {
    public static Node buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        //create the root of the tree 
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> q = new LinkedList<>(); //push root to queue

        q.add(root);
        //starting from 2nd element
        int i = 1;
        while(q.size() > 0 && i <ip.length) {
            //get and remove the front of the queue
            Node currNode = q.peek();
            q.remove();

            //get the current node's value from the string
            String currVal = ip[i];

            //if the left child != null
            if (!currVal.equals('N')) {
                //create left child for current node
                currNode.left = new Node(Integer.parseInt(currVal));
                //push it to the queue
                q.add(currNode.left);
            }

            //for right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            //if the right child != null
            if (!currVal.equals("N"))  {
                //create the right child for current node
                currNode.right = new Node(Integer.parseInt(currVal));
                //push it to the queue
                q.add(currNode.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while(t--> 0) {
            int s = Integer.parseInt(sc.nextLine());
            //sc.nextLine();
            String res = sc.nextLine();

            Node root = buildTree(res);

            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> ans = obj.printPaths(root, s);

            Collections.sort(ans, new ElementWiseComparator());

            for(int i=0; i<ans.size(); i++) {
                for(int j=0; j<ans.get(i).size(); j++) {
                    System.out.print(ans.get(i).get(j)+" ");
                }
                System.out.println(" ");
            }
        }
    }

    static class ElementWiseComparator implements Comparator<ArrayList<Integer>> {
        @Override
        public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2) {
            int minLength = Math.min(list1.size(), list2.size());
            for (int i = 0; i < minLength; i++) {
                int comparison = Integer.compare(list1.get(i), list2.get(i));
                if (comparison != 0) {
                    return comparison;
                }
            }
            return Integer.compare(list1.size(), list2.size());
        }
    }
}




//User function Template for Java

/*Tree Node
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
} 
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> printPaths(Node root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> currentPath = new ArrayList<>();
        dfs(root, sum, currentPath, result);
        return result;
    }

    private static void dfs(Node node, int remainingSum, ArrayList<Integer> currentPath,
                            ArrayList<ArrayList<Integer>> result) {
        if (node == null) {
            return;
        }

        currentPath.add(node.data);

        // Check if the current path equals the given sum
        if (remainingSum == node.data) {
            result.add(new ArrayList<>(currentPath));
        }

        // Recursively search the left and right subtrees
        dfs(node.left, remainingSum - node.data, currentPath, result);
        dfs(node.right, remainingSum - node.data, currentPath, result);

        // Backtrack by removing the last element to explore other paths
        currentPath.remove(currentPath.size() - 1);
    }
}