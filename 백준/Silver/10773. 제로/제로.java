import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        ArrayList<Integer> graph = new ArrayList<>(); //리스트의 길이가 가변적이라서 사용 
// 입력 받은 값이 0이면서 ArrayList에 값이 있는 경우(확인하는법:find함수), 최근 값 지우기
        for (int i = 0; i < k; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a != 0) {
                graph.add(a);
            } else if (a == 0 && find(graph)) {   
                graph.set(recent(graph), 0);
            }
        }

        int sum = 0;
        //for each 
        for (Integer value : graph) { 
            sum += value;
        }

        System.out.println(sum);
    }
//0으로만 이루어져있는지 확인 함수 
    private static boolean find(ArrayList<Integer> graph) { 
        for (int i = 0; i < graph.size(); i++) {
            if (graph.get(i) != 0) {
                return true;
            }
        }
        return false;
    }
     //0이아닌 가장 최근 수 역순으로 탐색함수 
    private static int recent(ArrayList<Integer> graph) {
        for (int i = graph.size() - 1; i >= 0; i--) {
            if (graph.get(i) != 0) {
                return i;
            }
        }
        return -1;

    }
}