import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int empty = 0;
	static int k;
	static int[] imlist;
	static int[] ilist;
	static String str;
	static int n;
	static int num;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		str = st.nextToken(); // 숫자 문자로 
		num = Integer.parseInt(str); // 숫자 정수

		n = str.length(); // 정수 자릿수
		k = Integer.parseInt(st.nextToken()); // k 개수
		imlist = new int[k]; // 되는 점만 저장
		ilist = new int[n]; // list index; num에 해당하는 imlist의  인덱스를 저장 -1이면 0이라는거(첫자리 한정)

		st = new StringTokenizer(bf.readLine()); //입력받기 
		for (int i = 0; i < k; i++) {
			imlist[i] = Integer.parseInt(st.nextToken());
		}
		//입력한 값 657 3 ; 1 5 7 이라고 하면 ; 첫번째 자리가(백의자리) 1,5,7 중 1번째 인덱스인 5를 사용할거니까 
		// ilist[0]=1; 이라고 인덱스 저장하려고 만든거임
		Arrays.sort(imlist);
		dfs(0); // index는 자리
		for (int i = 0; i < n; i++) { //출력 
			if (i == 0 && ilist[i] == -1) {
				continue;
			} else {
				System.out.print(imlist[ilist[i]]);
			}
		}
	}

	public static void dfs(int index) {
		if (index >= n) { //n자리 수 초과라면 return (그만)
			return;
		}
		int a = str.charAt(index) - '0';
		if (index == 0 && a < imlist[0]) { //첫번째 자리라면 0으로 처리(어차피 수는 두자리수로 입력되니까)
			ilist[index] = -1;
			for (int j = index + 1; j < n; j++) {
				ilist[j] = k - 1;
			}
		} else if (index > 0 && a < imlist[0]) { // 첫번째 자리가 아닌데 인덱스 최솟값보다 작다면 , 전 자리의 수를 낮출거다 
			int i = 1;
			while (index - i >= 0) {// 0번째 인덱스까지만 반복 
				if (ilist[index - i] > 0) { // 전자리의숫자를 감소할건데 전자리의 인덱스가 1이상이되어야 감소를 할수있겠지 // 0이라면 자리수를 줄여야함(3->2)
					ilist[index - i]--; 
					break;
				} else if (index == i) { //첫번째 자리라면 첫자리는 0이어도돼 
					ilist[0] = -1;
					break;
				}
				i++;
			}
			for (int j = index - i + 1; j < n; j++) { // 숫자가 어긋난 거 제외하고는다 최댓값으로 채울거야 
				ilist[j] = k - 1;
			}

		} else if (a >= imlist[0]) { 
			int i = 0;
			boolean same = false;
			while (i < k && a >= imlist[i]) {
				if (a == imlist[i]) { //일치하기 
					same = true;
				}
				ilist[index] = i;
				i++;
			}
			if (same) { //자리 일치한다면 다음 자릿수는 재귀로 검색  
				dfs(index + 1);
			} else if (!same) {
				for (int j = index + 1; j < n; j++) { //일치하지않다면 그 뒤로 자릿수는 최대로 채우기 
					ilist[j] = k - 1;
				}
			}
		}

	}
}