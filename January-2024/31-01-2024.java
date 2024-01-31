/*
Author : Vandana Kumari
Date   : 31/01/2024
Problem : Insert and Search in a Trie
Problem Link: https://www.geeksforgeeks.org/problems/trie-insert-and-search0651/1
*/

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-->0) {
            int n = sc.nextInt();
            sc.nextLine();
            String[] keys = sc.nextLine().split(" ");

            TrieNode root = new TrieNode();
            for (int i=0; i<n; i++) {
                insert(root, keys[i]);
            }
            String abc = sc.nextLine();
            if(search(root, abc))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}

static final int ALPHABET_SIZE = 26;

    // trie node
    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++) children[i] = null;
        }
    };


// User function Template for Java

/*
static final int ALPHABET_SIZE = 26;

    // trie node
    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++) children[i] = null;
        }
    };
*/
//Function to insert string into TRIE.
static void insert(TrieNode root, String key) {
    TrieNode current = root;
    int n = key.length();
    for (int i = 0; i < n; i++) {
        int index = key.charAt(i) - 'a';
        if (current.children[index] == null) {
            current.children[index] = new TrieNode();
        }
        current = current.children[index];
    }
    current.isEndOfWord = true;
}

// Function to use TRIE data structure and search the given string.
static boolean search(TrieNode root, String key) {
    TrieNode current = root;
    int n = key.length();
    for (int i = 0; i < n; i++) {
        int index = key.charAt(i) - 'a';
        if (current.children[index] == null) {
            return false;
        }
        current = current.children[index];
    }
    return current != null && current.isEndOfWord;
}