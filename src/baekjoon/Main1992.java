package baekjoon;

import java.util.Scanner;

public class Main1992 {
	static int n;
	static int[][] array;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		array = new int[n][n];
		for(int i = 0; i < n; i++) {
			String str = sc.next();
			for(int j = 0; j < str.length(); j++) {
				array[i][j] = str.charAt(j) - '0';
			}
		}
		String result = quadTree(0,0,n);
		System.out.println(result);
		sc.close();
	}
	public static String quadTree(int row, int col, int size) {
		int checkResult = checkSquare(row, col, size);
		String result = "";
		if(checkResult == -1) {
			size /= 2;
			result = "(";
			result += quadTree(row, col, size);
			result += quadTree(row, col+size, size);
			result += quadTree(row+size, col, size);
			result += quadTree(row+size, col+size, size);
			result += ")";
		}else {
			result += String.valueOf(checkResult);
		}
		return result;
	}
	// array[row][col] 부터 size 만큼의 정사각형이 모두 같은지 체크
	// 모두 0이면 return 0
	// 모두 1이면 return 1
	// 0과 1이 섞여있으면 -1
	public static int checkSquare(int row, int col, int size) {
		int count0 = 0, count1 = 0;
		for(int i = row; i < row+size; i++) {
			for(int j = col; j < col+size; j++) {
				if(array[i][j] == 0) {
					count0++;
				}else if(array[i][j] == 1) {
					count1++;
				}
			}
		}
		if(count0 == size*size) {
			return 0;
		}else if(count1 == size*size) {
			return 1;
		}else {
			return -1;
		}
	}

}
