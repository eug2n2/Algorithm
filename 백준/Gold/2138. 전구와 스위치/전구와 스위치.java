import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int[] b;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		String s1 = bf.readLine();
		String s2 = bf.readLine();
		// i-1, i, i+1 을 변경하는 것을 -> i, i+1, i+2 를 변경해서 생각하자
		// 문제: 1번 스위치는 1,2,3를변경하는건데 (1,2 )만 변경할 수 있음
		// 1번 스위치만 별도로 생각하자...
		int[] a = new int[n+1]; // 맨마지막 스위치누르면, n-2, n-1 만 스위치 꺼짐.. 그 경우 인덱스 에러 발생우려가 되어서..
		b = new int[n+1];
		int[] c = new int[n+1];
		for (int i = 0; i < n; i++) {
			a[i] = s1.charAt(i) - '0'; // 1번 스위치 안킴
			c[i] = s1.charAt(i) - '0'; // 1번 스위치 킴
			b[i] = s2.charAt(i) - '0';
		}
		// 1번 스위치 킴
		c[0] = 1 - c[0];
		c[1] = 1 - c[1];
		int tmp1 = turn(a, 0);
		int tmp2 = turn(c,1); // 스위치 이미켰으니까
		if (tmp1 == -1) {
			System.out.println(tmp2);
		} else if (tmp2 == -1) {
			System.out.println(tmp1);
		} else {
			System.out.println(Math.min(tmp1, tmp2));
		}
	}

	public static int turn(int[] array, int cnt) {
		for (int i = 0; i < n-1; i++) {
			if (array[i] != b[i]) {
				cnt++;
				array[i]=1-array[i];
				array[i+1]=1-array[i+1];
				array[i+2]=1-array[i+2];
			}
		}
		if(array[n-1]!= b[n-1]) return -1;
		return cnt;
	}
}
