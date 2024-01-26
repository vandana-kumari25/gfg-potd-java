/*
Author : Vandana Kumari
Date   : 26/01/2024
Problem : Fractional Knapsack
Problem Link: https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
*/


import java.io.*;
import java.util.*;
import java.lang.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while(t--> 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++) {
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.6f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}



/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class itemComparator implements Comparator<Item>{
    public int compare(Item a, Item b){
        double r1 = (double)a.value / a.weight;
        double r2 = (double)b.value / b.weight;
        if(r1 > r2){
            return -1;
        }else if(r1 < r2){
            return 1;
        }
        return 0;
    }
}

class Solution{
    double fractionalKnapsack(int W, Item arr[], int n){
        Arrays.sort(arr, new itemComparator());
        int curWeight = 0;
        double finalvalue = 0.0;
        for(int i = 0; i < n; i++){
            if(curWeight + arr[i].weight <= W){
                curWeight += arr[i].weight;
                finalvalue += arr[i].value;
            }else{
                int remain = W - curWeight;
                finalvalue += arr[i].value * ((double) remain / arr[i].weight);
                break;
            }
        }
        return finalvalue;
    }
}