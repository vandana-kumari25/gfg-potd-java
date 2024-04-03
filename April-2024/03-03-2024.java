/*
Author : Vandana Kumari 
Date : 03/04/2024
Problem : Kth common ancestor In BST
Problem Link : https://www.geeksforgeeks.org/problems/kth-common-ancestor-in-bst/1
*/


//{ Driver Code Starts
import java.io.*;
import java.math.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class GFG {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N')) return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the curr node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the curr node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length) break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the curr node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine().trim();
            Node root = buildTree(s);

            String[] snums = br.readLine().split(" ");
            int k = Integer.parseInt(snums[0]);
            int x = Integer.parseInt(snums[1]);
            int y = Integer.parseInt(snums[2]);

            Solution T = new Solution();
            // Call the function with the needed parameters
            System.out.println(T.kthCommonAncestor(root, k, x, y));

            t--;
        }
    }
}

// } Driver Code Ends




// User function Template for Java
class Solution {
    public int kthCommonAncestor(Node root, int k, int x, int y) {
        // code here
        int total = 1;
        Node temp=root;
        while(root!=null){
            if(root.data>x && root.data>y){
                root=root.left;
                total++;
            }
            else if(root.data<x && root.data<y){
                root=root.right;
                total++;
            }
            else break;
        }
        int c=1;
        total-=k;
        total++;
        root=temp;
        while(root!=null){
            if(c==total)return root.data;
            if(root.data>x && root.data>y){
                root=root.left;
                c++;
            }
            else if(root.data<x && root.data<y){
                root=root.right;
                c++;
            }
            else break;
        }
        return -1;
    }
}