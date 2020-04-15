package baekjoon;

import java.util.Scanner;

public class Main11047 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();	// 동전개수
		int k = sc.nextInt();	// 금액
		int[] coins = new int[n];
		for(int i = 0; i < n; i++) {
			coins[i] = sc.nextInt();
		}
		
		int count = 0;
		int changes = k;
		for(int i = n-1; i >= 0; i--) {
			if(changes / coins[i] > 0) {
				count += changes / coins[i];
				changes %= coins[i];
			}
		}
		System.out.println(count);
		sc.close();
	}

}
