package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Main9205 {
	static int MAX = 102;
	static int MAX_METER = 1000; // 한번에 갈 수 있는 거리

	public static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int countMeter(Point a, Point b) {
		// a와 b 사이의 거리(미터)를 계산
		return (Math.abs(b.x - a.x) + Math.abs(b.y - a.y));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); // 테스트케이스
		while (t > 0) {

			int n = sc.nextInt() + 2; // 집,편의점,페스티벌 개수
			ArrayList<Point> list = new ArrayList<Point>(); // 집,편의점,페스티벌 좌표
			for (int i = 0; i < n; i++) {
				list.add(new Point(sc.nextInt(), sc.nextInt()));
			}
			int[][] arr = new int[n][n]; // 각 거리대비 필요한 맥주 개수

			// 초기화
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i != j)
						arr[i][j] = MAX;
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i == j)
						continue;
					Point p1 = list.get(i);
					Point p2 = list.get(j);
					int cnt = countMeter(p1, p2);
					if (cnt <= MAX_METER) {
						arr[i][j] = 1;
					}
				}
			}

			// 플로이드와샬
			for (int i = 0; i < n; i++) { // 중간지점
				for (int j = 0; j < n; j++) { // 시작지점
					for (int k = 0; k < n; k++) {// 종료지점
						if ((arr[j][i] + arr[i][k]) < arr[j][k]) {
							arr[j][k] = (arr[j][i] + arr[i][k]);
						}
					}
				}
			}
			
			if(arr[0][n-1] > 0 && arr[0][n-1] < MAX) {
				System.out.println("happy");
			}else {
				System.out.println("sad");
			}
		}
		sc.close();
	}
}
