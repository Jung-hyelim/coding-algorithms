package baekjoon;

import java.util.Scanner;

public class Main1654 {
	static int k, n;
	static int[] array;
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		k = sc.nextInt();
		n = sc.nextInt();
		array = new int[k];
		
		long max = 0;
		for (int i = 0; i < k; i++) {
			array[i] = sc.nextInt();
			if (max < array[i]) {
				max = array[i];
			}
		}
		
		long result = recursion(0, max+1);
		System.out.println(result);
		sc.close();
	}
	
	public static long recursion(long min, long max) {
		if ((min+1) >= max) return min;
		
		long mid = (min + max) / 2;
		long len = check(mid);
		if (len >= n) {
			return recursion(mid, max);
		} else {
			return recursion(min, mid);
		}
	}
	public static long check(long len) {
		int count = 0;
		for (int i = 0; i < k; i++) {
			count += (array[i] / len);
		}
		return count;
	}
}
