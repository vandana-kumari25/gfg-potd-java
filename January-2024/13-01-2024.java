/*
Author : Vandana Kumari
Date   : 13/01/2024
Problem : Insertion Sort for Singly Linked List
Problem Link: https://www.geeksforgeeks.org/problems/insertion-sort-for-singly-linked-list/1
*/ 


import java.util.*;

class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }

class insertion {
    Node head;
    Node tail;
    public void addToTheLast(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        }
        else {
            tail.next = node;
            tail = node;
        }
    }
    // Function to print the linked list
    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t--> 0) {
            int n = sc.nextInt();
            insertion llist = new insertion();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            llist.addToTheLast(head);
            for(int i=1; i<n; i++) {
                int x = sc.nextInt();
                llist.addToTheLast(new Node(x));
            }
            Solution obj = new Solution();
            head = obj.insertionSort(llist.head);
            llist.printList(head);

            t--;
        }
    }
}



//User function Template for Java

/*class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    */
    class Solution {
        public static Node insertionSort(Node head_ref) {
            // code here
            if (head_ref == null || head_ref.next == null) {
                return head_ref;
            }
    
            Node sorted = null;
            Node current = head_ref;
    
            while (current != null) {
                Node next = current.next;
    
                if (sorted == null || sorted.data >= current.data) {
                    current.next = sorted;
                    sorted = current;
                } else {
                    Node temp = sorted;
                    while (temp.next != null && temp.next.data < current.data) {
                        temp = temp.next;
                    }
                    current.next = temp.next;
                    temp.next = current;
                }
    
                current = next;
            }
    
            return sorted;
        }
    }