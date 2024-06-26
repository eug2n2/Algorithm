import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();	//트리 정보 리스트
    static int[] depth;		//깊이 저장 배열
    static int[][] parent;	//부모 노드 저장 DP
    static int height = 0, N;
    public static void main(String[] args) throws IOException{
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        //최대 높이 구하기
        for(int i=1;i<=N;i*=2)
            height++;
        parent = new int[N+1][height];
        depth = new int[N+1];
        for(int i=0;i<=N;i++)
            tree.add(new ArrayList<>());
            
        //트리 정보 저장하기
        for(int i=1;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        setTree(1, 1, 0);	//트리 형태 구성 및 높이 설정
        parentInit();		//점화식을 통해 부모 노드 DP 구성
        int M = Integer.parseInt(br.readLine());
        //M개를 LCA진행
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(LCA(a, b) + "\n");	//LCA결과 BufferedWriter 저장
        }
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
    //트리의 형태를 만드는 재귀 함수
    static void setTree(int c, int d, int p){
        depth[c] = d;		//깊이 저장
        parent[c][0] = p;	//부모 노드 저장
        //자식 노드들 탐색!
        for(int next : tree.get(c)){
            if(next == p)
                continue;
            setTree(next, d+1, c);
        }
    }
    //부모 노드에 대한 DP 점화식을 이용하여 구성하는 함수
    static void parentInit(){
        for(int i=1;i<height;i++){
            for(int j=1;j<=N;j++){
                parent[j][i] = parent[parent[j][i-1]][i-1];
            }
        }
    }
    //이분탐색을 이용하여 LCA를 진행하는 함수
    static int LCA(int a, int b) {
        int ah = depth[a];
        int bh = depth[b];
        //ah가 항상 크다고 설정!
        if (ah < bh) {
            int temp = b;
            b = a;
            a = temp;
        }
        //높이 동일하게 맞추기
        for (int i = height-1; i >= 0; i--) {
            //depth[a] - depth[b]는 깊이의 차
            //깊이의 차만큼 이동
            if (Math.pow(2, i) <= depth[a] - depth[b])
                a = parent[a][i];
        }
        //a와 b가 같다면 이미 공통 조상 노드에 도착했다고 판단
        if(a == b)
            return a;
        //동시에 거슬러 올라가기
        for (int i = height-1; i >= 0; i--) {
            if (parent[a][i] != parent[b][i]) {
                a = parent[a][i];
                b = parent[b][i];
            }
        }
        return parent[a][0];	
    }
}