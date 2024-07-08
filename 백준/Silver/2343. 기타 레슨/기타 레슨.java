import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int answer =Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n =Integer.parseInt(st.nextToken());
		int m =Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		int end =0;
		st = new StringTokenizer(bf.readLine());
		for(int i =0;i<n;i++) {
			arr[i]= Integer.parseInt(st.nextToken()); // 자연수 (순서대로 주어진다)
			end+= arr[i];
		}
		int start =1;
		while(start<=end) {
	
			int mid =  start + (end - start) / 2;
			int cnt =1;
			int tmp =0;
			for(int i =0;i<n;i++) {
				if(arr[i]>mid|| cnt>m) {
					cnt=m+1; //	start = mid+1; 처리하겠금
					break;
				}
				if (arr[i]+tmp<=mid) {
					tmp+=arr[i];
					continue;
				}else {
					tmp=arr[i];
					cnt++;
				}
			}
//			System.out.println(start+" "+end+ "  "+ mid+ " "+cnt);
			if(cnt>m) {
				start = mid+1;
			}else {
				answer=Math.min(answer, mid);
				end = mid-1;
			}
		}
		System.out.println(answer);
	}
	
	
}
