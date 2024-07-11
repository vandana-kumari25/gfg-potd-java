/*
Author : Vandana Kumari 
Date : 11/07/2024
Problem : Maximum Connected group
Problem Link : https://www.geeksforgeeks.org/problems/maximum-connected-group/1
*/

//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends




class Solution {
     private static final int[] ROW_DIRECTIONS = {-1, 1, 0, 0};
    private static final int[] COL_DIRECTIONS = {0, 0, -1, 1};

    public int MaxConnection(int grid[][]) {
        // Your code here
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        int maxGroupSize = 0;

        // Step 1: Find all connected groups of 1's and their sizes
        List<Integer> groupSizes = new ArrayList<>();
        int[][] groupIds = new int[n][n];
        int currentGroupId = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int groupSize = dfs(grid, visited, i, j, currentGroupId, groupIds);
                    groupSizes.add(groupSize);
                    maxGroupSize = Math.max(maxGroupSize, groupSize);
                    currentGroupId++;
                }
            }
        }

        // Step 2: Try changing each 0 to 1 and calculate the potential new group size
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> adjacentGroups = new HashSet<>();
                    int potentialGroupSize = 1; // If we change this cell to 1

                    for (int k = 0; k < 4; k++) {
                        int newRow = i + ROW_DIRECTIONS[k];
                        int newCol = j + COL_DIRECTIONS[k];
                        if (isValid(newRow, newCol, n) && grid[newRow][newCol] == 1) {
                            int adjacentGroupId = groupIds[newRow][newCol];
                            if (!adjacentGroups.contains(adjacentGroupId)) {
                                potentialGroupSize += groupSizes.get(adjacentGroupId - 1);
                                adjacentGroups.add(adjacentGroupId);
                            }
                        }
                    }

                    maxGroupSize = Math.max(maxGroupSize, potentialGroupSize);
                }
            }
        }

        return maxGroupSize;
    }

    private static int dfs(int[][] grid, boolean[][] visited, int row, int col, int groupId, int[][] groupIds) {
        int n = grid.length;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{row, col});
        visited[row][col] = true;
        groupIds[row][col] = groupId;
        int groupSize = 0;

        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            int currentRow = cell[0];
            int currentCol = cell[1];
            groupSize++;

            for (int i = 0; i < 4; i++) {
                int newRow = currentRow + ROW_DIRECTIONS[i];
                int newCol = currentCol + COL_DIRECTIONS[i];
                if (isValid(newRow, newCol, n) && grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                    stack.push(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                    groupIds[newRow][newCol] = groupId;
                }
            }
        }

        return groupSize;
    }

    private static boolean isValid(int row, int col, int n) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }
}

    