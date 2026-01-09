package Hwan0518.day40;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class 백준_2841_외계인의_기타_연주 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n, f;
	static PriorityQueue<Integer>[] pressed;

	public static void main(String[] args) throws IOException {

		// input
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		f = Integer.parseInt(st.nextToken());

		pressed = new PriorityQueue[f];
		for (int i=0; i<f; i++) pressed[i] = new PriorityQueue<>((o1,o2) -> o2-o1);

		// play
		int cnt = 0;

		for (int i=0; i<n; i++) {

			st = new StringTokenizer(br.readLine());

			int string = Integer.parseInt(st.nextToken());
			int fret = Integer.parseInt(st.nextToken());

			cnt += press(string, fret);
		}

		// result
		System.out.print(cnt);
	}


	static int press(int string, int fret) {

		int cnt = 0;

		// string에서, 지금 누르고 있는 가장 큰 fret 확인
		Integer cur = pressed[string].poll();

		// 아무것도 누르고 있지 않은 경우 -> 바로 누름
		if (cur == null) {
			cnt ++;
			pressed[string].offer(fret);
			System.out.println("init -> 바로 누름 ("+string+","+fret+")");
		}

		// 현재 눌러야할 fret이 더 큰 경우 -> 바로 누름
		else if (fret > cur) {
			cnt ++;
			pressed[string].offer(cur); // 작은fret 제거하면 안됨
			pressed[string].offer(fret);
			System.out.println("더 큼 -> 바로 누름 ("+string+","+fret+")");
		}

		// 현재 눌러야할 fret보다 작은 경우 -> 더 큰 fret 모두 제거
		else if (fret < cur) {

			while (cur > fret) {
				System.out.println("더 작음 -> 큰 부분 제거 ("+string+","+cur+")");
				cnt ++;
				cur = pressed[string].poll();
				if (cur == null) break;
			}

			// cur이 fret보다 작은 경우
			if (cur != null && cur < fret) {
				cnt ++;
				pressed[string].offer(cur); // 작은 fret 제거하면 안됨
				pressed[string].offer(fret);
				System.out.println("제거 끝남 -> 바로 누름 ("+string+","+fret+")");
			}

			// cur이 fret과 같다면 -> 손가락을 움직이지 않는다
			else if (cur != null && cur == fret) {
				System.out.println("제거 끝남 -> 같아서 움직이지 않음");
				pressed[string].offer(cur);
			}

			// cur이 null이라면 -> 아무것도 선택한게 없으므로 바로 누름
			else {
				System.out.println("제거 끝남 -> 아무것도 없으므로 바로 누름 ("+string+","+fret+")");
				cnt ++;
				pressed[string].offer(fret);
			}
		}

		// 현재 눌러야할 fret과 cur이 같은 경우 -> 손가락을 움직이지 않는다
		else {
			System.out.println("같음");
			pressed[string].offer(cur);
		}

		// result
		return cnt;
	}

}
