import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int r = Integer.parseInt(bf.readLine());
		String[] map = new String[r];
		HashMap<String, Integer> hm = new HashMap<>();
		for (int i = 0; i < r; i++) {
			map[i] = bf.readLine();
		}
		int ans = 0;
		String str = map[0];
		String str1 = map[1];

		for (int i = 0; i < r - 1; i++) {
			for (int j = i + 1; j < r; j++) {
				int tmp = 0;
				for (int size = 0; size < Math.min(map[i].length(), map[j].length()); size++) {
					if (map[i].charAt(size) == map[j].charAt(size)) {
						tmp++;
					} else {
						break;
					}
				}
				if (ans < tmp) {
					ans = tmp;
					str = map[i];
					str1 = map[j];
				}
			}
		}
		System.out.println(str);
		System.out.println(str1);

	}

}