package baekjoon;

import java.util.Scanner;

public class Main11053 {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] input = new int[n];
		for(int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}
		int[] array = new int[n];
		for(int i = 0; i < n; i++) {
			array[i] = 1;
			for(int j = 0; j < i; j++) {
				if(input[i] > input[j] && array[i] <= array[j]) {
					array[i]++;
				}else if(input[i] == input[j]) {
					array[i] = array[j];
				}
			}
		}
		int max = 0;
		for(int i = 0; i < n; i++) {
			if(max < array[i]) {
				max = array[i];
			}
		}
		System.out.println(max);
		sc.close();
	}
}