package baekjoon;

import java.util.Scanner;

public class Main1019 {
	static long[] array = new long[10];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		solve(1, n, 1);
		for(int i = 0; i < 10; i++) {
			System.out.print(array[i] + " ");
		}
		sc.close();
	}
	public static void solve(int start, int end, int ten) {
		// start를 ++시키면서 일의자리수를 0으로 만든다.
		while(start % 10 != 0 && start <= end) {
			calc(start, ten);
			start++;
		}
		if(start > end) return;
		// end를 --시키면서 일의자리수를 9로 만든다.
		while(end % 10 != 9 && end >= start) {
			calc(end, ten);
			end--;
		}
		// 0~9 자리수 계산
		int cnt = (end / 10) - (start / 10) + 1;
		for(int i = 0; i < 10; i++) {
			array[i] += cnt * ten;
		}
		// 다음자리수 계산
		solve(start / 10, end / 10, ten * 10);
	}
	public static void calc(int n, int ten) {
		while(n > 0) {
			array[n%10] += ten;
			n /= 10;
		}
	}
}
