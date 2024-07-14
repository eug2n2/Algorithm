import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] ch = new char[5][15];
        int max = 0;

        // 입력 및 배열 초기화
        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            if (max < str.length()) max = str.length();
            
            for (int j = 0; j < str.length(); j++) {
                ch[i][j] = str.charAt(j);
            }
        }

        // 세로로 읽어 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < 5; j++) {
                if (ch[j][i] == '\0') continue; //char 배열 기본값
                sb.append(ch[j][i]);
            }
        }
        System.out.println(sb.toString());
    }
}
