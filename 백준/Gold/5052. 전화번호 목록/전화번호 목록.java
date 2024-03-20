import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= t; tc++) {
			String ans ="YES";
			int n = Integer.parseInt(bf.readLine());
			String[] arr = new String[n];
			for (int i=0;i<n;i++) {
				arr[i]=bf.readLine();
			}
			Arrays.sort(arr);
			if(!check(n,arr)) {
				ans="NO";
			}
			System.out.println(ans);
		}
	}
	 public static boolean check(int n, String[] arr) {
	        for (int i = 0; i < n - 1; i++) {
	            if (arr[i + 1].startsWith(arr[i])) {
	                return false;
	            }
	        }
	 
	        return true;
	    }
	 
}