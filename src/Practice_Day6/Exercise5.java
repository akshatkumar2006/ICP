package Practice_Day6;

public class Exercise5 {

	public static void main(String[] args) {
		print(3);
	}

	public static void print(int n) {
		// TODO Auto-generated method stub
		if(n == 1) {
			System.out.print(1);
			return;
		}
		
		print(n - 1);
		System.out.print(n);
		print(n - 1);
	}
	
}
