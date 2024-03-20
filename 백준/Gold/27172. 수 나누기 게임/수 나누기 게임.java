import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());// 행
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int[] card = new int[n];
		boolean[] check= new boolean[1000001];
		for (int i = 0; i < n; i++) {
			card[i] = Integer.parseInt(st.nextToken());
			check[card[i]]= true;
		}
		int[] score= new int[1000001];
		for (int i : card) {
			for (int j= i*2; j<1000001;j+=i) {
				if (check[j]) {
					score[i]++;
					score[j]--;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int num :card) {
			sb.append(score[num]+" ");
		}
		System.out.println(sb);
	}


}