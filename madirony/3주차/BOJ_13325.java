/*
  link : https://www.acmicpc.net/problem/13325
  tier : G3
  type : tree/dp
*/
import java.util.*;
import java.io.*;

class Main
{
	static int k, size, ans = 0;
	static int[] warr;
	static int[] dp;
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		size = (int) (Math.pow(2, k+1)-1);
		warr = new int[size+1]; dp = new int[size+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 2; i <= size; i++) ans += warr[i] = Integer.parseInt(st.nextToken());
		int tmp = 0;
		for(int i = size; 1 < i; i-=2) {
			int a = warr[i] + dp[i];
			int b = warr[i-1] + dp[i-1];
			tmp += Math.abs(a-b);
			boolean flag = false;
			if(b < a) flag = true; 
			dp[i/2] = flag ? a : b;
		}
		System.out.println(ans+tmp);
	}
}
