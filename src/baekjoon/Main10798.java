package baekjoon;

import java.util.Scanner;

public class Main10798 {
	public static void main(String[] args) {
		int n = 5;
		Scanner sc = new Scanner(System.in);
		String[] str = new String[n];
		int[] len = new int[n];
		int max = 0;
		for(int i = 0; i < n; i++) {
			str[i] = sc.next();
			len[i] = str[i].length();
			if(max < len[i]) {
				max = len[i];
			}
		}
		
		for(int i = 0; i < max; i++) {
			for(int j = 0; j < n; j++) {
				if(len[j] >= (i+1)) {
					System.out.print(str[j].charAt(i));
				}
			}
		}
		sc.close();
	}
}
