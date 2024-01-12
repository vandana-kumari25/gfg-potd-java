/*
    Author : Vandana Kumari
    Date   : 12/01/2024
    Problem : Reverse First K elements of Queue
    Problem Link: https://www.geeksforgeeks.org/problems/reverse-first-k-elements-of-queue/1
    
 */

import java.util.*;

class ModifyQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t--> 0) {
            int n = sc.nextInt();

            int k = sc.nextInt();

            Queue<Integer> q = new LinkedList<>();

            while(n--> 0) {
                q.add((int)sc.nextInt());
            }

            GfG g = new GfG();

            Queue<Integer> ans = g.modifyQueue(q, k);

            while(!ans.isEmpty()) {
                int a = ans.peek();
                ans.poll();
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}

// User function Template for Java

class GfG {
    // Function to reverse first k elements of a queue.
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        // Using a stack to reverse the first K elements
        Stack<Integer> stack = new Stack<>();

        // Push the first K elements into the stack
        for (int i = 0; i < k; i++) {
            stack.push(q.poll());
        }

        // Enqueue the elements from the stack back into the queue
        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }

        // Enqueue the remaining elements back into the queue
        for (int i = 0; i < q.size() - k; i++) {
            q.add(q.poll());
        }

        return q;
    }
}