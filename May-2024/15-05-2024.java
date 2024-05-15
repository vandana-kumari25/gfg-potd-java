/*
Author : Vandana Kumari 
Date : 15/05/2024
Problem : Account Merge
Problem Link : https://www.geeksforgeeks.org/problems/account-merge/1
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      List<List<String>> accounts=new ArrayList<>();
      for (int i = 0; i < n; i++)
       {
        ArrayList<String> temp=new ArrayList<>();
        int x=sc.nextInt();
        for(int j = 0; j < x; j++)
           {
             String s1=sc.next();
             temp.add(s1);
           }
        accounts.add(temp);
       }
      Solution obj = new Solution();
      List<List<String>> res = obj.accountsMerge(accounts);
      Collections.sort(res, new Comparator<List<String>>() {
                @Override   public int compare(List<String> a,
                                              List<String> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        String xx=a.get(i);
                        String yy=b.get(i);
                        if (xx.compareTo(yy)<0)
                            return -1;
                        else if (xx.compareTo(yy)>0)
                            return 1;
                    }
                    if (al < bl)
                        return -1;
                    else if (al > bl)
                        return 1;
                    return -1;
                }
            });
      System.out.print("[");
      for (int i = 0; i < res.size(); ++i)
        {
          System.out.print("[");
          for (int j = 0; j < res.get(i).size(); j++)
             {
                if (j != res.get(i).size() - 1)
                     System.out.print(res.get(i).get(j)+", ");
                else
                     System.out.print(res.get(i).get(j));
             }
          if (i != res.size() - 1)
             System.out.println("], ");
          else
             System.out.print("]");
        }
       System.out.println("]");
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void unite(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}

class Solution {
  static List<List<String>> accountsMerge(List<List<String>> accounts) {
    // code here
    Map<String, Integer> emailToIndex = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);

        // Map emails to indices and names
        for (int i = 0; i < n; ++i) {
            List<String> acc = accounts.get(i);
            for (int j = 1; j < acc.size(); ++j) {
                String email = acc.get(j);
                emailToIndex.put(email, i);
                emailToName.put(email, acc.get(0));
            }
        }

        // Union emails with the same owner
        for (List<String> acc : accounts) {
            int root = emailToIndex.get(acc.get(1));
            for (int j = 2; j < acc.size(); ++j) {
                uf.unite(root, emailToIndex.get(acc.get(j)));
            }
        }

        // Group emails by owner
        Map<Integer, Set<String>> mergedAccounts = new HashMap<>();
        for (List<String> acc : accounts) {
            int root = uf.find(emailToIndex.get(acc.get(1)));
            mergedAccounts.putIfAbsent(root, new TreeSet<>());
            for (int j = 1; j < acc.size(); ++j) {
                mergedAccounts.get(root).add(acc.get(j));
            }
        }

        // Build the result
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, Set<String>> entry : mergedAccounts.entrySet()) {
            List<String> account = new ArrayList<>();
            account.add(emailToName.get(entry.getValue().iterator().next()));
            account.addAll(entry.getValue());
            result.add(account);
        }

        return result;

  }
}
