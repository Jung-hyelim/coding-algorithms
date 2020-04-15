package baekjoon;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main2178 {	

	static Map<String, Integer> distance = new HashMap<String, Integer>();
	static Queue<String> queue = new LinkedList<String>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n][m];
		for(int i = 0; i < n; i++) {
			char[] temp = sc.next().toCharArray();
			for(int j = 0; j < temp.length; j++) {
				map[i][j] = temp[j] - '0';
			}
		}
		
		distance.put("0,0", 1);
		queue.add("0,0,1");	// row, col, 거리 
		
		while(!queue.isEmpty()) {
			String current = queue.poll();
			String[] splited = current.split(",");

			int row = Integer.parseInt(splited[0]);
			int col = Integer.parseInt(splited[1]);
			int len = Integer.parseInt(splited[2]) + 1;
			
			map[row][col] = 2;	// 지나간 자리 표시 
			
			// 북 
			if(row > 0 && map[row-1][col] == 1) {
				String key = (row-1) + "," + col;
				checkKey(key, len);
			}
			// 동
			if((col+1) < m && map[row][col+1] == 1) {
				String key = row + "," + (col+1);
				checkKey(key, len);
			}
			// 남 
			if((row+1) < n && map[row+1][col] == 1) {
				String key = (row+1) + "," + col;
				checkKey(key, len);
			}
			// 서
			if(col > 0 && map[row][col-1] == 1) {
				String key = row + "," + (col-1);
				checkKey(key, len);
			}
		}
		
		System.out.println(distance.get((n-1)+","+(m-1)));
		
		sc.close();
	}
	public static void checkKey(String key, int length) {
		if(distance.containsKey(key)) {
			// 키가 있으면 전에 저장된 거리와 비교 
			int beforeLen = distance.get(key);
			if(beforeLen > length) {
				// 현재 거리가 더 작으면 셋팅 
				distance.put(key, length);
				queue.add(key + "," + length);
			}
		}else {
			// 키가 없으면 무조건 셋팅 
			distance.put(key, length);
			queue.add(key + "," + length);
		}
	}
}
