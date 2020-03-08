package baekjoon;

import java.util.*;
public class Main9663{
    static int[] array;

	public static boolean validate(int row, int a) {
		for(int i = 0; i < row; i++) {
			if(array[i] == a) return false;
			if((row-i) == Math.abs(a-array[i])) return false;
		}
		return true;
	}
	public static int nQueen(int n, int row) {
		if(n == row) return 1;

		int result = 0;
		for(int i = 0; i < n; i++) {
			if(validate(row, i)) {
				array[row] = i;
				result += nQueen(n, row+1);
			}
		}
		return result;
	}
	public static void main(String args[]){
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		array = new int[n];

		int result = nQueen(n, 0);
		System.out.println(result);
		sc.close();
	}
}