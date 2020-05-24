package baekjoon;

import java.util.Scanner;

public class Main1120 {
	static char[] aa;
	static char[] bb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		
		aa = a.toCharArray();
		bb = b.toCharArray();
		
		int minCnt = getCnt(0);
		
		if(aa.length != bb.length) {
			for(int i = 1; i <= bb.length - aa.length; i++) {
				int cnt = getCnt(i);
				if(minCnt > cnt) {
					minCnt = cnt;
				}
			}
		}
		
		System.out.println(minCnt);
		sc.close();
	}
	public static int getCnt(int index) {
		int cnt = 0;
		for(int i = 0; i < aa.length; i++) {
			if(aa[i] != bb[i + index]) {
				cnt++;
			}
		}
		return cnt;
	}
}
