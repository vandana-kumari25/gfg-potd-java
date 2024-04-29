/*
Author : Vandana Kumari 
Date : 29/04/2024
Problem : Remove every kth node
Problem Link : https://www.geeksforgeeks.org/problems/remove-every-kth-node/1
*/

//{ Driver Code Starts
    import java.util.*;
    class Node
    {
        Node next;
        int data;
        
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    class Delete_Kth_Node
    {
        Node head;
        Node tail;
        
        void addToTheLast(Node node){
            if(head == null){
            head = node;
            tail = node;
            }
            else
            {
                tail.next = node;
                tail = tail.next ;
            }
        }	
        public static void main(String args[])
        {
             Scanner sc = new Scanner(System.in);
             int t=sc.nextInt();		 
             while(t>0)
             {
                int n = sc.nextInt();
                Delete_Kth_Node list = new Delete_Kth_Node();
                //int n=Integer.parseInt(br.readLine());
                int a1=sc.nextInt();
                Node head= new Node(a1);
                list.addToTheLast(head);
                for (int i = 1; i < n; i++) 
                {
                    int a = sc.nextInt(); 
                    list.addToTheLast(new Node(a));
                }
                int k = sc.nextInt();					  
                //System.out.println(list.head.data+" "+ k);
                list.head = new Solution().delete(list.head,k); 
                Node temp = list.head;
                while(temp!=null)
                {
                    System.out.print(temp.data+ " ");
                    temp = temp.next;
                }
                System.out.println();
                t--;
            }
        }
    }
    // } Driver Code Ends
    
    
    /* Link list Node
    class Node
    {
        Node next;
        int data;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }*/
    class Solution
    {
        /*You are required to complete this method*/
        Node delete(Node head, int k)
        {
        // Your code here
        if (head == null || k <= 0)
                return head;
            
            if (k == 1) {
                // Deleting entire list
                while (head != null) {
                    Node temp = head;
                    head = head.next;
                    temp = null;
                }
                return null;
            }
    
            Node dummy = new Node(0);
            dummy.next = head;
            Node prev = dummy;
            Node curr = head;
            int index = 1;
    
            while (curr != null) {
                if (index == k) {
                    prev.next = curr.next;
                    curr = null;
                    curr = prev.next;
                    index = 1;
                } else {
                    index++;
                    prev = curr;
                    curr = curr.next;
                }
            }
    
            return dummy.next;
        }
    }