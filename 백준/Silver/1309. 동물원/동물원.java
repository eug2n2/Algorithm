import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine()); // 슛자 개수
		int[][] arr = new int[n][3]; //행 기준 0 왼쪽에만 1 오른쪽에만 2 둘다안 놓기
		arr[0][0]=1;
		arr[0][1]=1;
		arr[0][2]=1;
		for (int i=1;i<n;i++) {
			arr[i][2]= (arr[i-1][0]+arr[i-1][1]+arr[i-1][2])%9901;
			arr[i][0]= (arr[i-1][1]+arr[i-1][2])%9901;
			arr[i][1]= (arr[i-1][0]+arr[i-1][2])%9901;
		}
		int ans = (arr[n-1][0]+ arr[n-1][1]+arr[n-1][2])%9901;
		System.out.println(ans);
	}
}
