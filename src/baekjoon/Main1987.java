package baekjoon;

import java.util.Scanner;

public class Main1987 {
	static int r, c;
	static char[][] array;
	// 오른쪽, 왼쪽, 아래, 위 순서 
	static int[] row = {0, 0, 1, -1};
	static int[] col = {1, -1, 0, 0};
	static int max = 0;
	static boolean[] alpa = new boolean[26];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();	// 세로칸 개수 
		c = sc.nextInt();	// 가로칸 개수 
		array = new char[r][c];
		
		for(int i = 0; i < r; i++) {
			array[i] = sc.next().toCharArray();
		}
		
		alpa[array[0][0] - 'A'] = true;
		dfs(0, 0, 1);
		System.out.println(max);
		
		sc.close();
	}
	public static void dfs(int x, int y, int count) {
		if(max < count) {
			max = count;
		}
		
		int nextX, nextY;
		for(int i = 0; i < 4; i++) {
			nextX = x + row[i];
			nextY = y + col[i];
			
			if(nextX < 0 || nextX >= r || nextY < 0 || nextY >= c ) {
				continue;
			}
			
			char c = array[nextX][nextY];
			if(alpa[c - 'A']) {
				continue;
			}
			
			alpa[c - 'A'] = true;
			dfs(nextX, nextY, count+1);
			alpa[c - 'A'] = false;
			
		}
	}
}
