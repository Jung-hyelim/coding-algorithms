package baekjoon;

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main2668 {
	public static int n;
	public static int[] array;
	
	public static SortedSet<Integer> set = new TreeSet<Integer>();
	public static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // n칸
		array = new int[n+1];
		visit = new boolean[n+1];
		for(int i = 1; i <= n; i++) {
			array[i] = sc.nextInt();
		}
		
		for(int i = 1; i <= n; i++) {
			dfs(i, i);
			visit = new boolean[n+1];
		}
		
		System.out.println(set.size());
		for(int i : set) {
			System.out.println(i);
		}
		
		sc.close();
	}
	
	public static void dfs(int start, int current) {
		if(visit[current]) {
			if(start == current) {
				set.add(start);
			}
		}else {
			visit[current] = true;
			dfs(start, array[current]);
		}
	}

}
