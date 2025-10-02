package Practice_Day3;

public class Traversal {
	public static void main(String[] args) {
		int[][] matrix = { 
				{ 1, 2, 3 },
				{ 4, 5, 6 },
				{ 7, 8, 9 }
				};
		
		rowWiseTraversal(matrix);
		System.out.print("\n" + "--------" + "\n");
		columnWiseTraversal(matrix);
		System.out.print("\n" + "--------" + "\n");
		reverseTraversal(matrix);
		System.out.print("\n" + "--------" + "\n");
		spiralTraversal(matrix);
		System.out.print("\n" + "--------" + "\n");
		
		int[][] res = oneDToTwoD(new int[]{1,2,3,4}, 2, 2);
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[0].length; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
		System.out.print("\n" + "--------" + "\n");
	}

	public static void rowWiseTraversal(int[][] matrix) {
		// TODO Auto-generated method stub
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
		}
	}

	public static void columnWiseTraversal(int[][] matrix) {
		// TODO Auto-generated method stub
		for (int j = 0; j < matrix[0].length; j++) {
			for (int i = 0; i < matrix.length; i++) {
				System.out.print(matrix[i][j] + " ");
			}
		}
	}

	public static void reverseTraversal(int[][] matrix) {
		// TODO Auto-generated method stub
		for (int i = matrix.length - 1; i >= 0; i--) {
			for (int j = matrix[0].length - 1; j >= 0; j--) {
				System.out.print(matrix[i][j] + " ");
			}
		}
	}
	
	public static void spiralTraversal(int[][] matrix) {
		// TODO Auto-generated method stub
		int m = matrix.length;
		int n = matrix[0].length;
		
		int totalEle = m*n;
		
		int minr = 0, maxr = m - 1, minc = 0, maxc = n - 1;
		
		while(totalEle>0) {
			for(int i = minc; i <= maxc && totalEle>0; i++) {
				System.out.print(matrix[minr][i] + " ");
				totalEle--;
			}
			minr++;
			
			for(int i = minr; i <= maxr && totalEle>0; i++) {
				System.out.print(matrix[i][maxc] + " ");
				totalEle--;
			}
			maxc--;
			
			for(int i = maxc; i >= minc && totalEle>0; i--) {
				System.out.print(matrix[maxr][i] + " ");
				totalEle--;
			}
			maxr--;
			
			for(int i = maxr; i >= minr && totalEle>0; i--) {
				System.out.print(matrix[i][minc] + " ");
				totalEle--;
			} 
			minc++;
			
		}
	}
	
	public static int[][] oneDToTwoD(int[] arr, int m, int n){
		int[][] res = new int[m][n];
		
		int k = 0;
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				res[i][j] = arr[k++];
			}
		}
		
		return res;
	}
}
