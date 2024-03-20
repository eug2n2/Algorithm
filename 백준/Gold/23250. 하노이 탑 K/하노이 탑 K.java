import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken()); // 숫자 정수
		long k = Long.parseLong(st.nextToken()); 

        //k참조 
        long target = k;
        
        // solve 메서드 호출
        solve(n, 1, 3, 2, target);
    }

    // 재귀적으로 탐색하는 메서드
    public static void solve(int n, int a, int c, int b, long target) {
       

        // l[0]이 2^(n-1)보다 작거나 같으면 solve 메서드를 호출합니다.
        if (target - (long)(Math.pow(2, n - 1)) + 1 <= 0) { //반보다 작으면  앞에서 빼는거임 
            solve(n - 1, a, b, c, target);
        } else {
            // 그렇지 않으면 l[0]에서 2^(n-1)을 뺀 값을 할당합니다.
        	target = target - (long)(Math.pow(2, n - 1)) + 1; // 반보다 크면 그냥 나머지 반만 탐색 
        }

        target -= 1;  // n번째 하노이 움직인거 제거 

        
        if (target == 0) {
            System.out.println(a +" "+ c);
            System.exit(0);
        }

        // k 가 반보다 크니까 후반부 하노이탑 
        if (target- (long)(Math.pow(2, n - 1)) + 1 <= 0) {
            solve(n - 1, b, c, a, target);
        } 
    }
}
