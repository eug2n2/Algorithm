import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
    static String[] str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        str = new String[n + 1];
        
        for (int i = 1; i <= n; i++) str[i] = br.readLine();
        
        int [] right = new int[n + 1];
        int [] child = new int[n + 1];
        
        for (int i = 0; i < n - 2; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	if (right[a] == 0) {
        		right[a] = b;
        	} else {
        		right[child[a]] = b;
        	}
        	if (child[b] == 0) {
        		child[a] = b;
        	} else child[a] = child[b];

        }
        
        st = new StringTokenizer(br.readLine());
    	int a = Integer.parseInt(st.nextToken());
    	int b = Integer.parseInt(st.nextToken());
    	
    	if (right[a] == 0) {
    		right[a] = b;
    	} else {
    		right[child[a]] = b;
    	}
    	if (child[b] == 0) {
    		child[a] = b;
    	} else child[a] = child[b];
    	
    	while (right[a] != 0) {
    		sb.append(str[a]);
    		a = right[a];
    	}
    	sb.append(str[a]);
    	System.out.println(sb);
    }
}
