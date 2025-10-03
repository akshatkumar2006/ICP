package Practice_Day6;

public class Exercise2 {

	public static void main(String[] args) {
		System.out.println(sum(12345));
	}
	
	public static int sum(int n) {
		if(n == 0) {
			return 0;
		}
		
		int rem = n%10;
		return sum(n/10) + rem;
	}

}
