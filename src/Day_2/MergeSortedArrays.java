package Day_2;

public class MergeSortedArrays {
	class Solution {
		public void merge(int[] nums1, int m, int[] nums2, int n) {
			int[] ans = new int[m + n];

			int i = 0, j = 0, k = 0;

			while (i < m && j < n) {
				if (nums1[i] < nums2[j]) {
					ans[k++] = nums1[i];
					i++;
				} else if (nums1[i] == nums2[j]) {
					ans[k++] = nums1[i];
					ans[k++] = nums2[j];
					i++;
					j++;
				} else {
					ans[k++] = nums2[j];
					j++;
				}
			}

			while (i < m) {
				ans[k++] = nums1[i];
				i++;
			}

			while (j < n) {
				ans[k++] = nums2[j];
				j++;
			}

			for (int l = 0; l < n + m; l++) {
				nums1[l] = ans[l];
			}
		}
	}
}
