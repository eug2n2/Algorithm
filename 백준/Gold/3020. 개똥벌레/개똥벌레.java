import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[] cave = new int[h+1];
        for(int i =0;i<n/2;i++){ // 석순, 종유석 순
            int s = Integer.parseInt(bf.readLine());
            int j = Integer.parseInt(bf.readLine());
            cave[0]++;// 입장
            cave[s]--;// 퇴실
            cave[h]--;// 퇴실
            cave[h-j]++;
        }
        int now = 0;
        for(int i = 0; i <=h; i++) {
            now += cave[i];
            cave[i] = now;
        }
        int min = n;
        int cnt = 0;
        for(int i = 0; i <h; i++){ // 1번째구간 = 높이 0에서 지나간다로 이해하면됨, 즉 h구간= 높이 h-1 까지만 하면 됨
            if(min > cave[i]){
                min = cave[i];
                cnt = 1;
            }else if(min == cave[i]){
                cnt++;
            }
        }
        System.out.println(min+" "+cnt);
    }
}