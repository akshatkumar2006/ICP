package Phase_3.Day_2;

public class GridNegativeCount {
    public static void main(String[] args) {
        int[][] arr = {
            {5, 4, -3, -4},
            {-2, -3, -4, -5},
            {8, 7, 6, -5},
            {3, 1, -5, -8}
        };

        int cnt = 0;
        for(int[] a : arr){
            cnt+=binarySearch(a);
        }
        System.out.println(cnt);
    }

    public static int binarySearch(int[] a){
        int l = 0, h = a.length - 1;
        while(l <= h){
            int mid = l + (h - l)/2;
            if(a[mid] < 0){
                h = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        return a.length - l;
    }
}
