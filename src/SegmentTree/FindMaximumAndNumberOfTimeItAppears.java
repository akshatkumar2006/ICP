package SegmentTree;

import SegmentTree.FindMaximumAndNumberOfTimeItAppears.Pair;

public class FindMaximumAndNumberOfTimeItAppears {
    static Pair[] tree;
    public static void main(String[] args) {
        int n = 5;
        int[] arr = {1, 3, -2, 8, -7};
        tree = new Pair[4*n];
        createTree(arr, n);
        update(n,2, 8);
        Pair res = findMax(n, 2, 4);
        System.out.println(res.max + " " + res.count);
    }

    private static void update(int n, int idx, int val) {
        updateQuery(0, 0, n - 1, idx, val);
    }

    private static void updateQuery(int idx, int l, int r, int i, int val) {
        if(l == r){
            tree[idx] = new Pair(val, 1);
            return;
        }

        int mid = l + (r - l)/2;
        if(i <= mid){
            updateQuery(2*idx + 1, l, mid, i, val);
        }else{
            updateQuery(2*idx + 2, mid + 1, r, i, val);
        }

        tree[idx] = makePair(tree[2*idx + 1], tree[2*idx + 2]);
    }

    private static Pair findMax(int n, int si, int ei) {
        return query(0, si, ei, 0, n - 1);
    }

    private static Pair query(int i, int si, int ei, int l, int r) {
        if (si > r || ei < l) {
            return new Pair(Integer.MIN_VALUE, 0);
        }

        if (l >= si && r <= ei) {
            return tree[i];
        }

        int mid = l + (r - l)/2;
        return makePair(query(2*i + 1, si, ei, l, mid), query(2*i + 2, si, ei, mid + 1, r));
    }

    public static void createTree(int[] arr, int n) {
        buildTree(arr, 0, 0, n - 1);
    }

    public static void buildTree(int[] arr, int idx, int l, int r){
        if(l == r){
            tree[idx] = new Pair(arr[l], 1);
            return;
        }

        int mid = l + (r - l)/2;
        buildTree(arr, 2*idx + 1, l, mid);
        buildTree(arr, 2*idx + 2, mid + 1, r);
        tree[idx] = makePair(tree[2*idx + 1], tree[2*idx + 2]);
    }

    public static Pair makePair(Pair a, Pair b) {
        if(a.max > b.max){
            return a;
        }
        if (a.max < b.max) {
            return b;
        }
        return new Pair(a.max, a.count + b.count);
    }

    static class Pair {
        int max;
        int count;
        public Pair(int v, int c){
            this.max = v;
            this.count = c;
        }
    }
}
