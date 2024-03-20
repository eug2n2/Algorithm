import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int[] sortedArr;
	static int[] brr;
	static int k;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		k = 0;// 일치한 인덱스 체크 0부터하겠다는 의미
		arr = new int[n];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		brr = new int[n];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			brr[i] = Integer.parseInt(st.nextToken());
		}
		sortedArr = arr.clone();
		check();
		mergeSort(0, n - 1);

		System.out.println(k == n ? 1 : 0);
	}

	public static void merge(int left, int middle, int right) {
		int i = left;
		int j = middle + 1;
		int idx = left;
		while (i <= middle && j <= right) {
			if (arr[i] <= arr[j]) { // 크기가 맞다면 arr에 저장
				checkChange(sortedArr[idx],arr[i],idx);
				sortedArr[idx++] = arr[i++];
				check();

			} else {
				checkChange(sortedArr[idx],arr[j],idx);
				sortedArr[idx++] = arr[j++];
				check();

			}
		}
		// 둘중에 하나라도 n1, n2가 일치한다면, 종료가 됨
		// 그러면 남은원소도 arr에 저장해줘야함

		while (i <= middle) {
			checkChange(sortedArr[idx],arr[i],idx);
			sortedArr[idx++] = arr[i++];
			check();

		}
		while (j <= right) {
			checkChange(sortedArr[idx],arr[j],idx);
			sortedArr[idx++] = arr[j++];
			check();
		}
		for(int ii=left ;ii<=right;ii++ ) {
			arr[ii]=sortedArr[ii];
		}
	}

	public static void mergeSort(int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;
			mergeSort(left, middle);
			mergeSort(middle + 1, right);
			merge(left, middle, right);
		}
	}

	public static void checkChange(int a, int b, int idx) {
		if(a!=b && k!=n && idx<k) {
			System.out.println(0);
			System.exit(0);
		}
	}
	public static void check() {
		while(k<n&& sortedArr[k]== brr[k]) {
			k++;
		}
	}
}