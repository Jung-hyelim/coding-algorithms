package baekjoon;

import java.util.Scanner;

public class Main11404 {
	static int INF = 99999999;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] array = new int[n][n];
		// 초기화
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(i == j) array[i][j] = 0;
				else array[i][j] = INF;
			}
		}
		// 입력 
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			int c = sc.nextInt();
			if(array[a][b] > c) {
				array[a][b] = c;
			}
		}

		// floyd warshall
		// k = 거쳐가는 노드
		for(int k = 0; k < n; k++) {
			// i = 출발노드
			for(int i = 0; i < n; i++) {
				// j = 도착노드
				for(int j = 0; j < n; j++) {
					if(array[i][k] + array[k][j] < array[i][j]) {
						array[i][j] = array[i][k] + array[k][j];
					}
				}
			}
		}
		
		// 출력
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(array[i][j] == INF) array[i][j] = 0;
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		sc.close();
	}
// 참고 : https://m.blog.naver.com/PostView.nhn?blogId=ndb796&logNo=221234427842
}
