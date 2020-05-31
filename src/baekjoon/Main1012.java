package baekjoon;

import java.util.Scanner;

public class Main1012 {
	static int m,n;
	static int[][] array;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); // 테스트 케이스
		for(int z = 0; z < t; z++) {
			m = sc.nextInt(); // 배추밭 가로길이
			n = sc.nextInt(); // 배추밭 세로길이
			int k = sc.nextInt(); // 배추 개수
			array = new int[m][n]; // 배추밭
			for(int i = 0; i < k; i++) {
				array[sc.nextInt()][sc.nextInt()] = 1; // 배추 위치 표시 
			}
			
			int cnt = 0;
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					if(array[i][j] == 1) {
						cnt++;
						change(i, j);
					}
				}
			}
			System.out.println(cnt);
		}
		sc.close();
	}
	public static void change(int i, int j) {
		array[i][j] = 2;
		// 상 하 좌 우 이어진곳을 확인
		if(i > 0 && array[i-1][j] == 1) {
			change(i-1, j);
		}
		if((i+1) < m && array[i+1][j] == 1) {
			change(i+1, j);
		}
		if(j > 0 && array[i][j-1] == 1) {
			change(i, j-1);
		}
		if((j+1) < n && array[i][j+1] == 1) {
			change(i, j+1);
		}
	}
}
