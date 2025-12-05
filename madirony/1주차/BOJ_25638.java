/*
  link : https://www.acmicpc.net/problem/25638
  tier : P5
  type : tree/graph/dfs/dp
*/
import java.util.*;
import java.io.*;

class Main
{
	static int N;
	static int[] color;
	static List<List<Integer>> list = new ArrayList<>();
	static int[] parent;
	static long[] subR, subB;
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		long[] ans = new long[N+1];
		color = new int[N+1]; parent = new int[N+1];
		subR = new long[N+1]; subB = new long[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) color[i] = Integer.parseInt(st.nextToken());
		for(int i = 0; i <= N; i++) list.add(new ArrayList<>());
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list.get(u).add(v);
			list.get(v).add(u);
		}
		
		if(2 < N) {
			dfs(1, 0);
			long totalR = subR[1];
			long totalB = subB[1];
			
			for (int u = 1; u <= N; u++) {
			    long preR = 0, preB = 0, sum = 0;
			    
			    List<Integer> tmp = list.get(u);
			    int size = tmp.size();
			
			    for (int j = 0; j < size; j++) {
			        int v = tmp.get(j);
			        long R, B;
			        if (v == parent[u]) { R = totalR - subR[u]; B = totalB - subB[u]; }
			        else { R = subR[v]; B = subB[v]; }
			        
			        sum += R*preB + B*preR;
			        preR += R;
			        preB += B;
			    }
			    ans[u] = sum;
			}
		}
		
		int q = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < q; i++) {
			if(N <= 2) {
				sb.append('0').append('\n');
				continue;
			}
		    int num = Integer.parseInt(br.readLine());
		    sb.append(ans[num]).append('\n');
		}
		System.out.print(sb);
	}
	
	private static void dfs(int u, int p) {
		parent[u] = p;
		if(color[u] == 1) subR[u] = 1;
		else subB[u] = 1;
		List<Integer> tmp = list.get(u);
		for(Integer i : tmp) {
			if(i == p) continue;
			dfs(i, u);
			subR[u] += subR[i];
			subB[u] += subB[i];
		}
	}
}
