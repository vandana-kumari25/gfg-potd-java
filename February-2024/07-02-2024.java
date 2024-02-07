/*
Author : Vandana Kumari
Date : 07/02/2024
Problem : Min distance between two given nodes of a Binary Tree
Problem Link : https://www.geeksforgeeks.org/problems/min-distance-between-two-given-nodes-of-a-binary-tree/1
*/

import java.util.*;
import java.io.*;


class Node
{
    int data;
    Node left, right;
    Node(int item)    {
        data = item;
        left = right = null;
    }
}

class Main {
    static Node buildTree(String str) {
        if(str.length() == 0  || str.charAt(0) == 'N') {
            return null; 
        }

        String ip[] = str.split(" ");
        // Create the root
        Node root  = new Node(Integer.parseInt(ip[0]));
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        int i = 1;

        while (q.size() > 0 && i < ip.length) {
            //get & remove the front of queue
            Node  currNode = q.peek();
            q.remove();

            //get the current nde's value from the string
            String currVal = ip[i];

            //If the left child != null
            if(!currVal.equals("N")) {

                // create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                //push it to the queue
                q.add(currNode.right);
            }
            i++;
        }
        return root;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            String[] ab = br.readLine().trim().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);

            GfG g = new GfG();
            System.out.println(g.findDist(root, a, b));
        }
    }
}

// FUNCTION CODE
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
    Node(int item)    {
        data = item;
        left = right = null;
    }
} */

/* Should return minimum distance between a and b
    in a tree with given root*/
    class GfG {
    // Helper function to find the LCA of two nodes
    private Node findLCA(Node root, int a, int b) {
        if (root == null || root.data == a || root.data == b) {
            return root;
        }

        Node leftLCA = findLCA(root.left, a, b);
        Node rightLCA = findLCA(root.right, a, b);

        // If both nodes are found in different subtrees, then root is the LCA
        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        // Otherwise, return the non-null LCA from the left or right subtree
        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    // Helper function to find the distance from the root to a given node
    private int findDistance(Node root, int target, int distance) {
        if (root == null) {
            return -1;
        }

        if (root.data == target) {
            return distance;
        }

        int leftDistance = findDistance(root.left, target, distance + 1);
        int rightDistance = findDistance(root.right, target, distance + 1);

        // If the target node is not found in the current subtree, return -1
        if (leftDistance == -1 && rightDistance == -1) {
            return -1;
        }

        // Otherwise, return the distance from the root to the target node
        return (leftDistance != -1) ? leftDistance : rightDistance;
    }

    // Main function to find the minimum distance between two nodes
    int findDist(Node root, int a, int b) {
        // Find the Lowest Common Ancestor (LCA) of the two nodes
        Node lca = findLCA(root, a, b);

        // Calculate the distance from the LCA to each of the nodes
        int distanceA = findDistance(lca, a, 0);
        int distanceB = findDistance(lca, b, 0);

        // Return the total minimum distance
        return distanceA + distanceB;
    }
}