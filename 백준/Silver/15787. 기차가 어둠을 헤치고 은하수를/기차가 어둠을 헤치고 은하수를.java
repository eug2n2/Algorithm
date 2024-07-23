import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] train = new int[n][20];
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken())-1;
            switch(a){
                case 1:
                    int x = Integer.parseInt(st.nextToken());
                    train[b][x-1] = 1;
                    break;

                case 2:
                    int y = Integer.parseInt(st.nextToken());
                    train[b][y-1] = 0;
                    break;
                case 3:
                    for(int j = 19; j >=1; j--){
                        train[b][j] = train[b][j-1];
                    }
                    train[b][0] =0;
                    break;
                case 4:
                    for(int j = 0; j < 19; j++){
                        train[b][j] = train[b][j+1];
                    }
                    train[b][19] =0;
                    break;
            }
        }
        int answer =n;
        for(int i = 0; i < n; i++){
            String str="";
            for(int j = 0; j < 20; j++){
                str+=train[i][j];
            }
//            System.out.println(str);
            if(set.contains(str)){
               answer--;
            }else{
                set.add(str);
            }
        }
        System.out.println(answer);
    }
}