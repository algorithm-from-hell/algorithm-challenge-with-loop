package Hwan0518.day1;

import java.io.*;
import java.util.*;


public class 백준_1718_암호 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;



	public static void main(String[] args) throws IOException {

		String plainText = br.readLine();
		String encryptionKey = br.readLine();

		// encryption
		for (int i=0; i<plainText.length(); i++) {

			// 현재 문자
			char cur = plainText.charAt(i);

			// 현재 암호화 키
			char key = encryptionKey.charAt(i % encryptionKey.length());
			int val = key - 'a';

			// 공백인 경우
			if (cur == ' ') sb.append(" ");

				// 알파벳인 경우
			else {
				int idx = (cur - 'a' -1) - val;
				if (idx < 0) idx = (idx+26) % 26;

				sb.append((char) (idx+'a'));
			}
		}

		// result
		System.out.print(sb);
	}

}
