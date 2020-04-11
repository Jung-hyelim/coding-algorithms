package baekjoon;

import java.util.Scanner;

public class Main2979 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] fee = new int[4];
		for(int i = 1; i < 4; i++) {
			fee[i] = sc.nextInt() * i;
		}
		
		int maxIndex = 0;
		int[] array = new int[101];
		for(int i = 0; i < 3; i++) {
			int a = sc.nextInt();	// 주차장 도착 시간
			int b = sc.nextInt();	// 주차장 떠난 시간
			
			for(int j = a; j < b; j++) {
				array[j]++;
			}
			if(maxIndex < b) {
				maxIndex = b;
			}
		}
		
		int result = 0;
		for(int i = 1; i < maxIndex; i++) {
			result += fee[array[i]];
		}
		System.out.println(result);
		sc.close();
	}

}
