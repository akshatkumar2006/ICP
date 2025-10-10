package Practice_Day2;

public class MedianOfTwoSortedArrays {
	class Solution {
	    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	        return median(nums1, nums2);
	    }
	    public static double median(int[] arr, int[] arr2) {
			double median=0;
			int m=arr.length;
			int n=arr2.length;
			int[] arrr=new int[m+n];
			for (int i = 0; i < m; i++) {
				arrr[i]=arr[i];
			}
			merge(arrr,m,arr2,n);	
			if((m+n)%2==1) {
				int mid=(m+n+1)/2;
				median=arrr[mid-1];
			}
			else {
				int mid=(m+n)/2;
				median=(double)(arrr[mid-1]+arrr[mid])/2;
			}
			
			return median;
		}
		
		public static void merge (int[] arr, int m, int[] arr2,int n) {
			int i=m-1;
			int j=n-1;
			int k=m+n-1;
			while(j>=0) {
				if(i>=0 && arr[i]>arr2[j]) {
					arr[k--]=arr[i--];
				}
				else {
					arr[k--]=arr2[j--];
				}
			}
		}
	}
}
