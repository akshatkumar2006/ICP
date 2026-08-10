package Phase_3.Day_2;

public class EqualSubsetSum {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 11, 1};
        int sum = 0;
        for(int ele : arr){
            sum+=ele;
        }

        if((sum & 1) == 1){
            System.out.println(false);
        }else {
            System.out.println(equalSubset(arr, arr.length, sum / 2));
        }
    }
    public static boolean equalSubset(int[] arr, int n, int cap){
        if(n == 0 && cap != 0){
            return false;
        }

        if(cap == 0){
            return true;
        }

        if(arr[n - 1] <= cap){
            return equalSubset(arr, n - 1, cap - arr[n - 1]) || equalSubset(arr, n - 1, cap);
        }else{
            return equalSubset(arr, n - 1, cap);
        }
    }
}
