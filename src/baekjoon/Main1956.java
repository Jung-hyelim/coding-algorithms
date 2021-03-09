package baekjoon;

import java.util.Scanner;

public class Main1956 {
    static int MAX = 9999999;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt(); // 마을 개수
        int e = sc.nextInt(); // 도로 개수

        int[][] array = new int[v+1][v+1];
        for(int i = 0; i < e; i++) {
            array[sc.nextInt()][sc.nextInt()] = sc.nextInt();
        }
        for(int i = 1; i < v+1; i++) {
            array[i][i] = MAX;
        }
//        print(array, v);

        // 플로이드와샬
        for(int i = 1; i < v+1; i++) {  // 거쳐가는 노드
            for(int j = 1; j < v+1; j++) {  // 출발 노드
                for(int k = 1; k < v+1; k++) {  // 도착 노드
                    if(array[j][i] == 0 || array[i][k] == 0) continue;

                    if(array[j][k] > array[j][i] + array[i][k]) {
                        array[j][k] = array[j][i] + array[i][k];
                    }
                }
            }
        }
//        print(array, v);

        int min = MAX;
        for(int i = 1; i < v+1; i++) {
            if(min > array[i][i]) min = array[i][i];
        }
        if(min == MAX) min = -1;
        System.out.println(min);
        sc.close();
    }
    public static void print(int[][] array, int v) {
        System.out.println("=================");
        for(int i = 1; i < v+1; i++) {
            for(int j = 1; j < v+1; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
