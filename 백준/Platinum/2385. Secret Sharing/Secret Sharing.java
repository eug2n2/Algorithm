import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {
	public static String first = "";
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		 boolean can = false;
		int n = Integer.parseInt(bf.readLine()); // 횟수
		  ArrayList<String> arr = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr.add(st.nextToken());
			if(arr.get(i).charAt(0)!='0') can= true;
		}
		
		if(!can) {
			System.out.println("INVALID");
			return;
		}
		  ArrayList<String> ans = new ArrayList<>();
	        for (int i = 0; i < n; i++) {
	            if (arr.get(i).charAt(0) == '0') continue;
	           //0 으로시작하는게아니라면 정렬해서 조합정리 
	            ArrayList<String> tmp = new ArrayList<>(arr); // arr배열 복사 
	            tmp.remove(i); // arr.get(i)를 처음으로 두고 정렬할 것이므로 일단 제거 (나중에 붙여줌)

	            Collections.sort(tmp, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));

	            StringBuilder c = new StringBuilder(arr.get(i));
	            for (String x : tmp) { //arr.get(i)원소 제외 다복사 
	                c.append(x);
	            }
	            ans.add(c.toString());
	        }

	        Collections.sort(ans);
	        System.out.println(ans.get(0));

	}
}