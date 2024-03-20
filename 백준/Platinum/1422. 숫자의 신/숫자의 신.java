import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int k = Integer.parseInt(st.nextToken()); // 슛자 개수
		int n = Integer.parseInt(st.nextToken()); // 횟수
		String[] arr = new String[k];
		int max=0;
		for (int i =0;i<k;i++) {
			arr[i]=bf.readLine();
			int num =Integer.parseInt(arr[i]);
			if(max<num) {
				max =num;
			}
		}
		Arrays.sort(arr,(o1,o2)->(o2+o1).compareTo(o1+o2));
		StringBuilder sb = new StringBuilder();
		boolean dup =false; // 중복 안햇다 
		for (int i=0;i<k;i++) {
			int num =Integer.parseInt(arr[i]);
			sb.append(num);
			if(max==num&&!dup) {
				dup=true;
				for (int j=k;j<n;j++) {
					sb.append(num);
				}
			}
		}
		System.out.println(sb);
	}
}
