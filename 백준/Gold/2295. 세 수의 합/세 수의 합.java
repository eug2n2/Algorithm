import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Main {
	static ArrayList<Integer> al;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			set.add(Integer.parseInt(bf.readLine()));
		}
		al = new ArrayList<>(set);
		Collections.sort(al);
	
		int[] twoValuesSum = new int[(al.size() * (al.size() + 1)) / 2];
		int count = 0;
		for (int i = 0; i < al.size(); i++) {
			for (int j = i; j < al.size(); j++) {
				twoValuesSum[count++] = al.get(i) + al.get(j);
			}
		}
		Arrays.sort(twoValuesSum);
		int answer = -1;
		for (int i = 0; i <  al.size(); i++) {
			for (int j = 0; j <  al.size(); j++) {
				if (binarySearch(twoValuesSum,  al.get(i)-  al.get(j))) {
					answer = Math.max(answer,al.get(i));
				}
			}
		}
		System.out.println(answer);
	}

	private static boolean binarySearch(int[] arr, int value) {
		int l = 0;
		int r = arr.length - 1;
		while (l <= r) {
			int m = (l + r) / 2;
			if (arr[m] > value) {
				r = m - 1;
			} else if (arr[m] < value) {
				l = m + 1;
			} else{
				return true;
			}
		}
		return false;
	}
}
