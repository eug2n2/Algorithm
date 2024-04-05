import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());// 정점개수
		int m = Integer.parseInt(bf.readLine());// 정점개수
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int[] map= new int[n];
		for (int i = 0; i < n; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(map);
		int left =0;
		int right =  n-1;
		int ans =0;
		while(left<right) {
			int t =map[left]+map[right];
			if(t==m)  {
				ans++;
				right--;
			}
			else if (t>m) right--;
			else left++;
		}
		System.out.println(ans);
	}

}
