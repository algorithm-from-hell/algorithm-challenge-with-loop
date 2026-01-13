package Hwan0518.day9;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 백준_1173_운동 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();


	public static void main(String[] args) throws IOException {

		// input
		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m0 = Integer.parseInt(st.nextToken());
		int m1 = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		// workout
		int curM = m0;
		int workoutT = 0;
		int curT = 0;
		while (workoutT != n) {

			// 운동 아예 못하는 경우
			if (m0 + t > m1) break;

			// workout
			if (curM + t <= m1) {
				curM += t;
				workoutT ++;
			}

			// rest
			else {
				curM = Integer.max(m0, curM-r);
			}

			curT ++;
		}

		// result
		System.out.print(workoutT != n ? -1 : curT);
	}

}
