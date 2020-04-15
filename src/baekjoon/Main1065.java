package baekjoon;

import java.util.Scanner;

public class Main1065 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int result = 0;
		if(n < 100) {
			result = n;
		}else {
			result = 99;
			while(n > 100) {
				if(n == 1000) {
					n--;
					continue;
				}
				int x = n;
				int[] temp = new int[3];
				for(int i = 0; i < 3; i++) {
					temp[i] = x % 10;
					x /= 10;
				}
				if((temp[2] - temp[1]) == (temp[1] - temp[0])) {
					result++;
				}
				n--;
			}
		}
		System.out.println(result);
		sc.close();
	}
}
