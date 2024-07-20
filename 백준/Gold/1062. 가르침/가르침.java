import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int answer = 0;
    static boolean[] visited;
    static String[] word;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        if(k<5){
            System.out.println(0);
            return;
        }

        visited = new boolean[26];
        visited['a' - 'a'] = true;
        visited['c' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        word = new String[n];
        for(int i =0;i<n;i++){
            String str =bf.readLine();
            String tmp ="";
            for (int j =4; j < str.length()-4;j++){
                tmp += str.charAt(j);
            }
            word[i] = tmp;
        }
        dfs(0, 0);
        System.out.println(answer);
    }
    public static void dfs(int x, int len) {
        if(len == k - 5) {
            int count = 0;
            for(int i = 0; i < n; i++) { //뽑은 알파벳으로 몇개의 단어를 읽을 수 있는지 카운트.
                boolean read = true;
                for(int j = 0; j < word[i].length(); j++) {
                    if(!visited[word[i].charAt(j) - 'a']) {
                        read = false;
                        break;
                    }
                }
                if(read) count++;
            }
            answer = Math.max(answer, count);
            return;
        }

        for(int i = x; i < 26; i++) {
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            dfs(i+1, len + 1);
            visited[i] = false;

        }
    }
}