import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine()); // 횟수
		String[] arr = new String[n];

		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = st.nextToken();
			int num = Integer.parseInt(arr[i]);
			
		}
		Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
		
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(arr[i]);
			sb.append(num).append(" ");
		}
		System.out.println(sb);
		 

	}
}