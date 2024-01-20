/*
Author : Vandana Kumari
Date   : 20/01/2024
Problem : Distribute candies in a binary tree
Problem Link: https://www.geeksforgeeks.org/problems/distribute-candies-in-a-binary-tree/1
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
        if(str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        //create the root of tree
        Node root = new Node(Integer.parseInt(ip[0]));
        //push the root to the queue
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        //starting from 2nd element
        int i = 1;
        while(q.size() > 0 && i < ip.length) {
            //get and remove the front of the queue
            Node currNode = q.peek();
            q.remove();

            //get the current node's value from the string
            String currVal = ip[i];

            //if the left child is not null
            if(!currVal.equals("N")) {
                //creating left child of the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                //pushing left child to the queue
                q.add(currNode.left);
            }

            //for right child
            i++;
            if(i >= ip.length) break;

            currVal = ip[i];

            //if right child != null
            if(!currVal.equals("N")) {
                //creating a new node for the right child
                currNode.right = new Node(Integer.parseInt(currVal));

                //push it to the queue
                q.add(currNode.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        while (t--> 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution obj = new Solution();
            System.out.println(obj.distributeCandy(root));
        }
    }
}


//User function Template for Java

/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}*/


class Solution{
    static int ans;
    static int solve(Node root){
        if(root == null){
            return 0;
        }
        int left_profit = solve(root.left);
        int right_profit = solve(root.right);
        ans += Math.abs(left_profit) + Math.abs(right_profit);
        return root.data + left_profit + right_profit - 1;
    }
    public static int distributeCandy(Node root){
        ans = 0;
        solve(root);
        return ans;
    }
}
