
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(bf.readLine());


        StringBuilder sbS = new StringBuilder(N);
        StringBuilder sbP = new StringBuilder(N);

        for (int row = 0; row < 2; row++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                if (row == 0) sbS.append(st.nextToken());
                else sbP.append(st.nextToken());
            }
        }

        String S = sbS.toString(); 
        String P = sbP.toString(); 

        String SS = S + S; 

        // KMP 준비: 패턴 P의 LPS 배열
        int[] lps = buildLPS(P);

        // KMP 검색: SS에서 P를 찾되, 시작 위치가 N-1 이하인 매칭만 카운트
        int ans = 0;
        int i = 0; // SS index
        int j = 0; // P index

        // SS는 길이 2N까지 보지만, 매칭의 시작 위치 i - j 가 N-1 이하여야 함
        while (i < SS.length()) {
            if (SS.charAt(i) == P.charAt(j)) {
                i++;
                j++;
                if (j == P.length()) {
                    int start = i - j;
                    if (start < N) {
                        ans++;
                    }

                    j = lps[j - 1];
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
            if (i - j >= N) break;
        }

        int g = gcd(ans, N);
        ans /= g;
        N /= g;
        System.out.println(ans + "/" + N);
    }

    // LPS : 패턴 내의 접두사·접미사의 최대 공통 부분 문자열 길이
    private static int[] buildLPS(String pattern) {
		int length = pattern.length();
			int[] pi = new int[length];
			int j = 0; // 지금까지 일치한 길이 (앞에서부터 fix되는 부분 : 접두사)

			for(int i = 1; i < length; i++) { // 접미사
				while(j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
					j = pi[j-1]; // 같았던 부분까지로 돌아감 
				}

				if(pattern.charAt(i) == pattern.charAt(j)) {
					j++;
					pi[i] = j;
				}
			}

			return pi;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
