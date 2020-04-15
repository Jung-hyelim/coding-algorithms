package baekjoon;

import java.util.HashMap;
import java.util.Scanner;

public class Main2015 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] array = new int[n];
		int[] pSum = new int[n];	// pSum[i] : 0~i번째 까지의 합
		int sum = 0;
		for(int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
			sum += array[i];
			pSum[i] = sum;
		}

		// (j~i까지의 합이 k) pSum[i]-pSum[j]=k 인 i,j를 찾아야 하므로
		// 모든 X=pSum[j]인 j의 개수를 구해놓는다.
		HashMap<Integer, Long> map = new HashMap<>();
		
		Long count = 0L;
		for(int i = 0; i < n; i++) {
			// 0~i까지 부분합이 k이면, count+1
			if(pSum[i] == k) {
				count++;
			}
			
			// i까지 부분합 - k 가 이전에 존재하면
			if(map.get(pSum[i] - k) != null) {
				count += map.get(pSum[i] - k);
			}
			
			// i까지 부분합을 map에 저장
			if(map.containsKey(pSum[i])) {
				map.put(pSum[i], map.get(pSum[i]) + 1);
			}else {
				map.put(pSum[i], 1L);
			}
		}
		System.out.println(count);
		sc.close();
	}
}
// 참고1 : https://www.crocus.co.kr/602
// 참고2 : http://codersbrunch.blogspot.com/2016/12/2015-4.html
