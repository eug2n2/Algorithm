import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer token = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(token.nextToken());
		}
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
		int cnt = 0;
		// 1.배열의 하나의 인덱스를 가리키는 Start 점과 End 점 두개를 만들자.(start는 시작지점, End는 끝점을 가리킨다.)
		int start = 0;
		int end = N-1;
		
    	while(start<end){
            int sum= arr[start] + arr[end];
            if (sum==M){
                cnt+=1;
            }
            if(sum<=M){
                start++;
            }
            else{
                end--;
            }
        }
		System.out.println(cnt);
	}

}