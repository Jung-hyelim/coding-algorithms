package baekjoon;

import java.util.Scanner;

public class Main4963 {
	static int[] tmpX = { 1, -1, 0, 0, 1, -1, 1, -1 };
	static int[] tmpY = { 0, 0, 1, -1, 1, -1, -1, 1 };
	static int[][] array;
	static boolean[][] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w, h, cnt;
		while (true) {
			w = sc.nextInt();
			h = sc.nextInt();

			if (w == 0 && h == 0)
				break;

			cnt = 0;
			array = new int[h][w];
			visit = new boolean[h][w];

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					array[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!visit[i][j] && array[i][j] == 1) {
						cnt++;
						check(i, j, h, w);
					}
				}
			}
			System.out.println(cnt);
		}
		sc.close();
	}

	public static void check(int x, int y, int h, int w) {
		int newX, newY;
		for (int i = 0; i < 8; i++) {
			newX = x + tmpX[i];
			newY = y + tmpY[i];
			if (newX < h && newX >= 0 && newY < w && newY >= 0 && !visit[newX][newY] && array[newX][newY] == 1) {
				visit[newX][newY] = true;
				check(newX, newY, h, w);
			}
		}
	}
}
