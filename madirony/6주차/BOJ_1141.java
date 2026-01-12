/*
  link : https://www.acmicpc.net/problem/1141
  tier : S1
  type : string/greedy
*/
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) arr[i] = br.readLine();

        Arrays.sort(arr);
        int cnt = 0;
        
        for (int i = 0; i < N - 1; i++) {
            if (!arr[i+1].startsWith(arr[i])) cnt++;
        }
        cnt++; 
        System.out.println(cnt);
    }
}
