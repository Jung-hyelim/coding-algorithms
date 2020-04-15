package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main7785 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();	// 테스트케이스 
		Set<String> set = new HashSet<String>();
		for(int i = 0; i < n; i++) {
			String name = sc.next();
			String action = sc.next();
			
			if(action.equals("enter")) {
				set.add(name);
			}else {
				set.remove(name);
			}
		}
		
		List<String> list = new ArrayList<String>(set);
		Collections.sort(list, Comparator.reverseOrder());
		for(String str : list) {
			System.out.println(str);
		}
		sc.close();
	}
}
