import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n =Integer.parseInt(bf.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i =0; i< n;i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		int ans =0;
		int left =0;
		int right = n-1;
		while(left<right) {
			if(arr[left]<=arr[right]) {
				int dist = (right-left-1)* arr[left];
				if(ans<dist) ans =dist;
				left++;
			}else {
				int dist = (right-left-1)* arr[right];
				if(ans<dist) ans =dist;
				right--;
			}
		}
		System.out.println(ans);
	}
	
}
