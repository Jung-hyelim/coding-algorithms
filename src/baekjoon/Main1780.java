package baekjoon;

import java.util.Scanner;

public class Main1780 {
	static final int DIFF = 999;
	static int[][] array; // 행렬
	static int[] result = new int[3]; // 결과 : -1,0,1 개수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 크기
		array = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				array[i][j] = sc.nextInt();
			}
		}
		
		recursion(0, 0, n);
		
		for(int r : result) {
			System.out.println(r);
		}
		sc.close();
	}
	public static void recursion(int x, int y, int size) {
		// (x,y) 부터 size 만큼의 정사각형이 모두 같은수로 채워져 있는지 확인.
		int temp = check(x, y, size);
		if(temp == DIFF) {
			// 다르다면, 9등분하여 recursion 실행
			size /= 3;
			recursion(x, y, size);
			recursion(x, y + size, size);
			recursion(x, y + size * 2, size);
			recursion(x + size, y, size);
			recursion(x + size, y + size, size);
			recursion(x + size, y + size * 2, size);
			recursion(x + size * 2, y, size);
			recursion(x + size * 2, y + size, size);
			recursion(x + size * 2, y + size * 2, size);
		}else {
			// 같은수라면 결과값 ++
			result[temp+1]++;
		}
	}
	public static int check(int x, int y, int size) {
		int a = array[x][y];
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(array[x+i][y+j] != a) {
					return DIFF;
				}
			}
		}
		return a;
	}
}
