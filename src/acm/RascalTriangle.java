package acm;

import java.util.Scanner;

public class RascalTriangle {

	public static int rascal(int n, int m) {
		int answer = 0;
		if(m > (n/2)){
			answer = (n - ((m/2) + 1)) + n;
		}
		else{
			answer = (n - (m + 1)) + n;
			answer = (n * (m + 1)) - (n - (m +1));
		}
		return answer;

	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter row: ");
		int n = input.nextInt();
		System.out.println("Enter column: ");
		int m = input.nextInt();

		int answer = rascal(n, m);
		System.out.println(answer);
	}
}
