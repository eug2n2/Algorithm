import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map.put(a, map.getOrDefault(a, 0) + 1);
            // 구간에서 끝점은 미포함
            map.put(b, map.getOrDefault(b, 0) - 1);
        }

        List<Integer> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList); // 앞에서부터 차례로 봐야하니까

        int cnt = 0, maxCnt = 0;
        int sa = 0, sb = 0;
        boolean open= false; // 현재 답인 구간이라면 endpoint를 체크 해야되니까..
        for(int key : keyList) {
            cnt += map.get(key);
            if (cnt > maxCnt) {
                maxCnt = cnt;
                sa = key;
                open=true;
            }

            if (cnt < maxCnt && open) {
                sb= key;
                open=false;
            }
        }

        System.out.println(maxCnt);
        System.out.println(sa + " " + sb);
    }
}
