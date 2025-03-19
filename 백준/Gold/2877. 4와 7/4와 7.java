import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int k = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();  // String 대신 StringBuilder 사용
        
        int tmp = 1;
        while (true) {
            int powerOfTwo = (int) Math.pow(2, tmp);
            if (k - powerOfTwo <= 0) {
                break;
            }
            k -= powerOfTwo;
            tmp++;
        }
        
        int cnt = tmp - 1;
        for (int i = 0; i < tmp; i++) {
            int half = (int) Math.pow(2, cnt);
            if (k <= half) {
                answer.append(4);
            } else {
                k -= half;
                answer.append(7);
            }
            cnt--;
        }
        
        System.out.println(answer);
    }
}
