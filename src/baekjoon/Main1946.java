package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main1946 {
	public static class Score {
		int paper;
		int interview;
		public Score(int paper, int interview) {
			this.paper = paper;
			this.interview = interview;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); // 테스트 케이스
		int[] result = new int[t];
		
		for(int i = 0; i < t; i++) {
			int n = sc.nextInt(); // 지원자 수
			ArrayList<Score> list = new ArrayList<Score>(); // 지원자 점수 리스트 
			for(int j = 0; j < n; j++) {
				list.add(new Score(sc.nextInt(), sc.nextInt()));
			}
			
			// 서류 점수로 정렬 
			Collections.sort(list, new Comparator<Score>() {
				@Override
				public int compare(Score o1, Score o2) {
					if(o1.paper < o2.paper) {
						return -1;
					}else if(o1.paper > o2.paper) {
						return 1;
					}else {
						return 0;
					}
				}
			});

			int cnt = 1; // 합격자수
			int min = list.get(0).interview;
			for(int j = 1; j < n; j++) {
				if(list.get(j).interview < min) {
					min = list.get(j).interview;
					cnt++;
				}
			}
			result[i] = cnt;
		}

		// 출력
		for(int i : result) {
			System.out.println(i);
		}
		sc.close();
	}

}
