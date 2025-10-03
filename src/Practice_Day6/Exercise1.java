package Practice_Day6;

public class Exercise1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(f(3));
		System.out.println(f(4));
		System.out.println(f(5));
		System.out.println(f(6));
	}
	
	public static int f(int n) {
		// TODO Auto-generated method stub
		if( n <= 1) {
			return n;
		}
		
		if((n & 1) == 0) {
			return n + f(n/2);
		}else {
			return f((n+1)/2) + f((n - 1)/2);
		}
	}

}
