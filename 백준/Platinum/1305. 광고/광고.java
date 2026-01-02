
import java.io.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int L = Integer.parseInt(bf.readLine());
		String S = bf.readLine();

		int[] pi = buildLPS(S);
		int minLen = L - pi[L - 1]; // 최소 광고 길이
		System.out.println(minLen);
	}

	private static int[] buildLPS(String pattern) {
		int length = pattern.length();
		int[] pi = new int[length];
		int j = 0;

		for (int i = 1; i < length; i++) {
			while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = pi[j - 1];
			}
			if (pattern.charAt(i) == pattern.charAt(j)) {
				j++;
				pi[i] = j;
			}
		}
		return pi;
	}
}
