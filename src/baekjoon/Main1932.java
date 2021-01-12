package baekjoon;

import java.util.Scanner;

public class Main1932 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 삼각형 크기
		int[][] triangle = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= i; j++) {
				triangle[i][j] = sc.nextInt();
			}
			for(int j = i+1; j < n; j++) {
				triangle[i][j] = 0;
			}
		}
//		print(triangle, n);
		
		int[][] sum = new int[n][n];
		sum[0][0] = triangle[0][0];
		for(int i = 1; i < n; i++) {
			sum[i][0] = sum[i-1][0] + triangle[i][0];
			
			for(int j = 1; j <= i; j++) {
				sum[i][j] = Integer.max(sum[i-1][j-1], sum[i-1][j]) + triangle[i][j];
			}
		}
//		print(sum, n);
		
		int max = 0;
		for(int i = 0; i < n; i++) {
			if(max < sum[n-1][i]) {
				max = sum[n-1][i];
			}
		}
		System.out.println(max);
		sc.close();
	}
	public static void print(int[][] arr, int n) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
