package baekjoon;

import java.util.*;

public class Main1238 {
	static int MAX = 20000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 학생수
		int m = sc.nextInt(); // 도로수
		int x = sc.nextInt(); // 파티장소
		
		// array 초기화
		int[][] array = new int[n][n];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(i == j) array[i][j] = 0;
				else array[i][j] = MAX;
			}
		}
		// 도로 입력
		int a, b, c;
		for(int i = 0; i < m; i++){
			a = sc.nextInt() - 1;
			b = sc.nextInt() - 1;
			c = sc.nextInt();
			array[a][b] = c;
		}
		// 플로이드 와샬
		for(int i = 0; i < n; i++){ // 중간
			for(int j = 0; j < n; j++){ // 시작
				for(int k = 0; k < n; k++){ // 끝
					if(array[j][i] + array[i][k] < array[j][k]) {
						array[j][k] = array[j][i] + array[i][k];
					}
				}
			}
		}
		// 왕복 거리 계산 & 최대값
		int maxDistance = 0;
		for(int i = 0; i < n; i++){
			if(maxDistance < array[i][x-1] + array[x-1][i]){
				maxDistance = array[i][x-1] + array[x-1][i];
			}
		}
		System.out.println(maxDistance);
		sc.close();
	}
}
