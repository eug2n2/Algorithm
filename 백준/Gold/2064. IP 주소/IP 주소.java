import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder network = new StringBuilder();
        StringBuilder subnet = new StringBuilder();
        int n =Integer.parseInt(bf.readLine());
        String[][] array = new String[n][4];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(),".");
            for(int j =0;j<4;j++){
                array[i][j] = st.nextToken();
            }
        }
        Boolean avail=true;
        for (int i = 0; i < 4; i++) {
            int min = Integer.parseInt(array[0][i]);
            int max = Integer.parseInt(array[0][i]);
            for(int j=1; j<n; j++) {
                min = min & Integer.parseInt(array[j][i]);
                max = max | Integer.parseInt(array[j][i]);
            }
//            System.out.println(min +" " +max);
            if(min == max&& avail){
                network.append(min).append(".");
                subnet.append(255).append(".");
            }else if (avail){
                network.append(min).append(".");
                subnet.append(255-(max-min)).append(".");
                avail=false;

            }else{ // 한번 0이면 그대로 0
                network.append(0).append(".");
                subnet.append(0).append(".");
            }

        }
        // 마지막 점 지우자
        network.deleteCharAt(network.length() - 1);
        subnet.deleteCharAt(subnet.length() - 1);
        System.out.println(network);
        System.out.println(subnet);
    }
}