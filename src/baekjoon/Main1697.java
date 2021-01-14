package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1697 {
	static int MAX;
	static int cnt = 0;
	static boolean[] visit;
	static int k;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 시작지점
		k = sc.nextInt(); // 종료지점
		MAX = Integer.max(n, k) * 2;
		
		visit = new boolean[MAX+1];
		visit[n] = true;
		List<Integer> list = new ArrayList<Integer>();
		list.add(n);
		search(list);
		System.out.println(cnt);
		sc.close();
	}
	public static void search(List<Integer> list) {
		List<Integer> newList = new ArrayList<Integer>();
		for(int i : list) {
			if(i == k) {
				return;
			}
			if(i > 0 && !visit[i - 1]) {
				visit[i - 1] = true;
				newList.add(i - 1);
			}
			if(i < MAX && !visit[i + 1]) {
				visit[i + 1] = true;
				newList.add(i + 1);
			}
			if((i * 2) < MAX && !visit[i * 2]) {
				visit[i * 2] = true;
				newList.add(i * 2);
			}
		}
		cnt++;
//		System.out.println("before : " + list.toString() + ", after : " + newList.toString());
		if(!newList.isEmpty()) search(newList);
	}
}
