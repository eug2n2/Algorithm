import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int ans =0;
		Arrays.sort(arr);
		for (int i = 0; i < n; i++) {
			if(twopointer(arr[i],i)){
				ans++;
			}
		}
		System.out.println(ans);
	}
	public static boolean twopointer (int val , int e) {
		int start =0;
		int end = n-1;
		
		while(start<end) {
			if(start ==e) { //자기 자신 제외
				start++;
				continue;
			} 
			if(end ==e) {
				end--;
				continue;
			} 
			if(arr[start]+arr[end]==val) {
				return true;
			}
			if(arr[start]+arr[end]<val) {
				start++;
				
			}else {
				end--;
			}
		}
		return false;
	}
}
