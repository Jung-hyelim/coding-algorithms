package baekjoon;

import java.util.*;

public class Main1181 {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Map<Integer, SortedSet<String>> map = new HashMap<Integer, SortedSet<String>>();
		
		for(int i = 0; i < n; i++) {
			String input = sc.next();
			int length = input.length();
			
			if (map.get(length) == null) {
				SortedSet<String> sortedSet = new TreeSet<String>();
				sortedSet.add(input);
				map.put(length, sortedSet);
			} else {
				SortedSet<String> sortedSet = map.get(length);
				sortedSet.add(input);
			}
		}
		
		map.keySet().stream().sorted().forEach(i -> {
			for(String s : map.get(i)) {
				System.out.println(s);
			}
		});
		
		sc.close();
	}
}
