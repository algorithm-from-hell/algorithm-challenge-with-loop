/*
  link : https://www.acmicpc.net/problem/1047
  tier : P5
  type : greedy/brute-force
*/
import java.util.*;
import java.io.*;

class Main
{
	static int N;
	static Tree[] arr;
	static class Tree {
		int x, y, t;
		Tree(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;
		}
	}
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); arr = new Tree[N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			arr[i] = new Tree(x, y, t);
		}
		int ans = N - 1;
        int[] tarr = new int[N];
        
		for (int i = 0; i < N; i++) {
		    for (int j = 0; j < N; j++) {
		        for (int k = 0; k < N; k++) {
		            for (int l = 0; l < N; l++) {
		                int minX = Math.min(arr[i].x, arr[j].x), maxX = Math.max(arr[i].x, arr[j].x);
		                int minY = Math.min(arr[k].y, arr[l].y), maxY = Math.max(arr[k].y, arr[l].y);
		
		                int size = (maxX-minX)*2 + (maxY-minY)*2;
		                int cnt = 0, sum = 0, cnt2 = 0;
		
		                for (int m = 0; m < N; m++) {
		                    Tree t = arr[m];
		                    if (t.x < minX || t.x > maxX || t.y < minY || t.y > maxY) { cnt++; sum += t.t; }
		                    else tarr[cnt2++] = t.t;
		                }
		                Arrays.sort(tarr, 0, cnt2);
		
		                int added = 0;
		                for(int m = cnt2-1; 0 <= m; m--) {
		                	if(size <= sum) break;
		                	sum += tarr[m]; added++;
		                }
		
		                if (size <= sum) ans = Math.min(ans, cnt + added);
		            }
		        }
		    }
		}
		System.out.println(ans);
	}
}
