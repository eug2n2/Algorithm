import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int k;
	static int tmp;// 저장횟수
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		tmp = 0;
		sb = new StringBuilder();
		int[] arr = new int[n];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		mergeSort(arr, 0, n - 1);
		if (tmp < k) {
			System.out.println("-1");
		} else {
			System.out.println(sb);
		}
	}

	public static void merge(int[] arr, int left, int middle, int right) {
		int n1 = middle - left + 1;
		int n2 = right - middle;
		int[] leftarr = new int[n1];
		int[] rightarr = new int[n2];
		System.arraycopy(arr, left, leftarr, 0, n1); // 원본배열, 시작인덱스, 복사할배열, 복사할 배열에서 시작인덱스, 개수
		System.arraycopy(arr, middle + 1, rightarr, 0, n2);
		int i = 0, j = 0, idx = left;
		while (i < n1 && j < n2) {
			if (leftarr[i] <= rightarr[j]) { // 크기가 맞다면 arr에 저장
				arr[idx] = leftarr[i++];
				tmp++;
				if (tmp == k) {
					for (int val:arr) {
						sb.append(val+" ");
					}
				}
			} else {
				arr[idx] = rightarr[j++];
				tmp++;
				if (tmp == k) {
					for (int val:arr) {
						sb.append(val+" ");
					}
				}
			}
			idx++;
		}
		// 둘중에 하나라도 n1, n2가 일치한다면, 종료가 됨
		// 그러면 남은원소도 arr에 저장해줘야함

		while (i < n1) {
			arr[idx++] = leftarr[i++];
			tmp++;
			if (tmp == k) {
				for (int val:arr) {
					sb.append(val+" ");
				}
			}
		}
		while (j < n2) {
			arr[idx++] = rightarr[j++];
			tmp++;

			if (tmp == k) {
				for (int val:arr) {
					sb.append(val+" ");
				}
			}
		}
	}

	public static void mergeSort(int[] arr, int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;
			mergeSort(arr, left, middle);
			mergeSort(arr, middle + 1, right);
			merge(arr, left, middle, right);
		}
	}
}
