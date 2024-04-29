import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		List<String> numbers = new ArrayList<>();
		int max = 0;

		String line;
		while ((line = bf.readLine()) != null && !line.isEmpty()) {
			numbers.add(line);
		}
		Collections.sort(numbers, (a, b) -> (b + a).compareTo(a + b));

		StringBuilder sb = new StringBuilder();
		for (String num : numbers) {
			sb.append(num);
		}
		System.out.println(sb);

	}
}