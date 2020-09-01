package baekjoon;

import java.util.Scanner;

public class Main14888 {
	static int[] sign;
	static int[] nums;
	static int n;
	static Long max = Long.MIN_VALUE;
	static Long min = Long.MAX_VALUE;
	static int cntSign = 4;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 수의 개수
		nums = new int[n];
		sign = new int[cntSign];
		for(int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		for(int i = 0; i < cntSign; i++) {
			sign[i] = sc.nextInt();
		}
		
		recursion(1, nums[0], sign[0], sign[1], sign[2], sign[3]);

		System.out.println(max);
		System.out.println(min);
		
		sc.close();
	}
	public static void recursion(int cnt, long result, int plus, int minus, int multiply, int division) {
		if(n == cnt) {
			if(max < result) {
				max = result;
			}
			if(min > result) {
				min = result;
			}
			return;
		}
		if(plus > 0) {
			recursion(cnt+1, result + nums[cnt], plus-1, minus, multiply, division);
		}
		if(minus > 0) {
			recursion(cnt+1, result - nums[cnt], plus, minus-1, multiply, division);
		}
		if(multiply > 0) {
			recursion(cnt+1, result * nums[cnt], plus, minus, multiply-1, division);
		}
		if(division > 0) {
			recursion(cnt+1, result / nums[cnt], plus, minus, multiply, division-1);
		}
	}
}
