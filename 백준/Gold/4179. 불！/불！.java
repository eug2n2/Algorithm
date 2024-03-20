import java.util.*;
import java.awt.Point;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
            Queue<Point> queue = new LinkedList<Point>();
            Queue<Point> fq = new LinkedList<Point>(); // fire을 넣는 큐
            int[] firecount = new int[1000001]; // 초당 불개수 세는 리스트
            int[] jicount = new int[1000001]; // 지훈이 갈 수있는 개수  세는 리스트
            int n = sc.nextInt(); // 세로
            int second = 1;
            int m = sc.nextInt(); // 가로
            int sx = 0;
            int sy = 0;

            boolean goout = false;
            String[][] map = new String[n][m];
            int[][] visited = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] strArr = sc.next().split("");
                for (int j = 0; j < m; j++) {
                    visited[i][j] = 1000001; // 방문안했다의 의미가 1000001 , 방문과 거리의 역할을 동시에
                    map[i][j] = strArr[j];
                    if (strArr[j].equals("J")) {
                        sx = i; // 사람 시작점
                        sy = j;
                        jicount[1]+=1;
                    } else if (strArr[j].equals("F")) {
                        fq.add(new Point(i, j));
                        firecount[1] += 1;
                    }

                }
            }
            visited[sx][sy] = 1;
            queue.add(new Point(sx, sy));

            out: while (!queue.isEmpty()) {
                for (int ff = 0; ff < firecount[second]; ff++) {
                    Point f = fq.poll();
                    map = fire(map, fq, firecount, second + 1, f.x, f.y, n, m);
                }
                for (int gg = 0; gg < jicount[second]; gg++) {
                    Point p = queue.poll();
                    visited = search(map, visited,jicount,second+1,queue, p.x, p.y, n, m);
               
                if (p.x == 0 || p.x == n - 1 || p.y == m - 1 || p.y == 0) {
                    System.out.println(visited[p.x][p.y]);
                    goout = true;
                    break out;
                }
                }
                second++;
            }
            if (!goout) {
                System.out.println("IMPOSSIBLE");
            }
        }

    public static int[][] search(String[][] map, int[][] visited,int[] jicount, int second, Queue<Point> queue, int i, int j, int n, int m) {
        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            // 범위 확인
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                // 현재 위치가 1이고 방문하지 않은 경우
                if (map[nx][ny].equals(".") && visited[nx][ny] == 1000001) {
                    visited[nx][ny] = visited[i][j] + 1;
                    map[i][j] = ".";
                    map[nx][ny] = "J";
                    queue.add(new Point(nx, ny));
                    jicount[second] += 1;
                }
            }

        }
        return visited;
    }

    public static String[][] fire(String[][] map, Queue<Point> fq, int[] firecount, int second, int i, int j, int n, int m) {
        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            // 범위 확인
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                // 현재 위치가 1이고 방문하지 않은 경우
                if (map[nx][ny].equals(".")) {

                    map[nx][ny] = "F"; // 불번짐
                    fq.add(new Point(nx, ny));
                    firecount[second] += 1;
                }
            }

        }
        return map;
    }

}
