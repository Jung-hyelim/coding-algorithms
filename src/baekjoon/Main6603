package baekjoon;

import java.util.Scanner;

public class Main6603 {
	static int k;
	static int[] num;
	static int[] lotto = new int[6];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			k = sc.nextInt(); // 숫자 개수
			if(k == 0) {
				break;
			}
			num = new int[k]; // 입력 숫자
			for(int i = 0; i < k; i++) {
				num[i] = sc.nextInt();
			}
			
			pick(0, 0);
			System.out.println();
		}
		sc.close();
	}
	public static void pick(int index, int cnt) {
		if(cnt == 6) {
			for(int i = 0; i < 6; i++) {
				System.out.print(lotto[i] + " ");
			}
			System.out.println();
			return;
		}
		if(index == k) {
			return;
		}
		
		for(int i = index; i < k; i++) {
			lotto[cnt] = num[i];
			pick(i+1, cnt+1);
		}
	}
}
