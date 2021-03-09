package baekjoon;

import java.util.*;

public class Main11725 {
    static Map<Integer, List<Integer>> map = new HashMap<>();
    static int[] result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 노드 개수

        int a, b;
        for(int i = 1; i < n; i++) {
            a = sc.nextInt();
            b = sc.nextInt();

            putMap(a, b);
            putMap(b, a);
        }

        result = new int[n+1];
        setParent(1, map.get(1));

        for(int i = 2; i < n+1; i++) {
            System.out.println(result[i]);
        }

        sc.close();
    }
    public static void putMap(int a, int b) {
        if(!map.containsKey(a)) {
            map.put(a, new ArrayList<>());
        }
        map.get(a).add(b);
    }
    public static void setParent(int index, List<Integer> list) {
        for(int i : list) {
            if(result[i] != 0) continue;
            result[i] = index;
            setParent(i, map.get(i));
        }
    }
}
