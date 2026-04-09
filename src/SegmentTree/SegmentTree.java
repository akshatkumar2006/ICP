package SegmentTree;

public class SegmentTree {
    static int[] tree;
    public static void main(String[] args) {
        int n = 5;
        int[] arr = {1, 3, -2, 8, -7};
        tree = new int[4 * n];
        createTree(arr, n); // O(N) each of the node is followed during construction
        display();
        updateTree(1, 6, n); // O(logN) because of the height of the tree
        display();
        int result = queryOp(1, 3, n); // O(logN)
        System.out.println(result);

//        Lazy Propagation (Range Update): O(log n) — Lazy updates are deferred and applied only when needed, maintaining logarithmic time
    }

    private static int queryOp(int i, int j, int n) {
        return queryOp(0, i, j, 0, n - 1);
    }

    private static int queryOp(int idx, int i, int j, int l, int r) {
        if(l > j || r < i){
            return 0;
        }

        if(l >= i && r <= j){
            return tree[idx];
        }

        int mid = (l + r)/2;
        return queryOp(2 * idx + 1, i, j, l, mid) + queryOp(2 * idx + 2, i, j, mid + 1, r);
    }

    private static void updateTree(int idx, int val, int n) {
        updateTree(idx, val, 0, 0, n - 1);
    }

    private static void updateTree(int idx, int val, int i, int l, int r) {
        if(l == r){
            tree[i] = val;
            return;
        }

        int mid = (l + r)/2;
        if(idx <= mid){
            updateTree(idx, val, 2*i + 1, l, mid);
        }else{
            updateTree(idx, val, 2*i + 2, mid + 1, r);
        }

        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
    }

    public static void createTree(int[] arr, int n) {
        buildTree(arr, 0, 0, n - 1);
    }

    public static void buildTree(int[] arr, int idx, int l, int r) {
        if(l == r){
            tree[idx] = arr[l];
            return;
        }

        int mid = (l + r) / 2;
        buildTree(arr, 2 * idx + 1, l, mid);
        buildTree(arr, 2 * idx + 2, mid + 1, r);

        tree[idx] = tree[2 * idx + 1] + tree[2 * idx + 2];
    }

    private static void display() {
        for (int ele : tree){
            System.out.print(ele + " ");
        }
        System.out.println();
    }
}
