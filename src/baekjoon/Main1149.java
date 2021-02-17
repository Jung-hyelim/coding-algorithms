package baekjoon;

import java.util.Scanner;

public class Main1149 {
	static int COLOR_CNT = 3;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] dp = new int[n][COLOR_CNT];
		int[][] pays = new int[n][COLOR_CNT];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < COLOR_CNT; j++) {
				pays[i][j] = sc.nextInt();
			}
		}

		dp[0][0] = pays[0][0];
		dp[0][1] = pays[0][1];
		dp[0][2] = pays[0][2];
		
		for(int i = 1; i < n; i++) {
			dp[i][0] = Integer.min(dp[i-1][1], dp[i-1][2]) + pays[i][0];
			dp[i][1] = Integer.min(dp[i-1][0], dp[i-1][2]) + pays[i][1];
			dp[i][2] = Integer.min(dp[i-1][1], dp[i-1][0]) + pays[i][2];
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < COLOR_CNT; i++) {
			if(dp[n-1][i] < min) min = dp[n-1][i];
		}
		System.out.println(min);
		
		sc.close();
	}
	// 참고 : https://sihyungyou.github.io/baekjoon-1149/
}
