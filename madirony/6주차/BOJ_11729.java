/*
  link : https://www.acmicpc.net/problem/11729
  tier : G5
  type : recursion
*/
import java.util.*;
import java.io.*;

class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int K = 1;
        for (int i = 0; i < N; i++) K *= 2;
        K -= 1;

        sb.append(K).append('\n');
        hanoi(N, 1, 2, 3);
        System.out.print(sb);
    }

    static void hanoi(int n, int from, int tmp, int to) {
        if (n == 0) return;
        hanoi(n - 1, from, to, tmp);
        sb.append(from).append(' ').append(to).append('\n');
        hanoi(n - 1, tmp, from, to);
    }
}
