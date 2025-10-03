package Practice_Day6;

public class Exercise6 {

	public static void main(String[] args) {
		System.out.println(countSetBits(10));
	}
	
	static int countSetBits(int n) {
		if(n == 0) {
			return 0;
		}
		
		return countSetBits(n & (n - 1)) + 1;
	}
	
}
