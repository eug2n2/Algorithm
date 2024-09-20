import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(bf.readLine());
        int answer = 1;
        char[][] map = new char[x][x];
        for (int i = 0; i < x; i++) {
            String str = bf.readLine();
            for (int j = 0; j < x; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < x; i++) {
            int rs = 0;
            int rcolor = -1;
            int cs = 0;
            int ccolor = -1;
            for (int j = 0; j < x; j++) {
                if (rcolor != number(map[i][j])) {
                    answer = Math.max(rs, answer);
                    rcolor = number(map[i][j]);
                    rs = 1;
                } else {
                    rs++;
                }
                if (ccolor != number(map[j][i])) {
                    answer = Math.max(cs, answer);
                    ccolor = number(map[j][i]);
                    cs = 1;
                } else {
                    cs++;
                }
            }
            answer = Math.max(rs, answer);
            answer = Math.max(cs, answer);

            if (answer == x) {
                System.out.println(x);
                return;
            }
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                char ch = map[i][j];
                for (int k = 0; k < 4; k++) {
                    int os = 0;
                    int ocolor = -1;
                    int ns = 0;
                    int ncolor = -1;
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    int as = 0;
                    int acolor = -1;
                    if (nx < 0 || ny < 0 || nx >= x || ny >= x) continue;
                    char ch1 = map[nx][ny];
                    if (ch == ch1) continue; // 색 다른 것 만 변경됨

                    if (k < 2) {
                        for (int a = 0; a < x; a++) {
                            int ntmp = number(map[nx][a]);
                            int otmp = number(map[i][a]);
                            int atmp = number(map[a][j]);
                            if (a == j) {
                                otmp = number(ch1);
                                ntmp = number(ch);
                            }
                            if (a == nx) {
                                atmp = number(map[i][j]);
                            }
                            if (a == i) {
                                atmp = number(map[nx][j]);
                            }
                            if (ocolor != otmp) {
                                answer = Math.max(os, answer);
                                ocolor = otmp;
                                os = 1;
                            } else {
                                os++;
                            }

                            if (ncolor != ntmp) {
                                answer = Math.max(ns, answer);
                                ncolor = ntmp;
                                ns = 1;
                            } else {
                                ns++;
                            }
                            if (acolor != atmp) {
                                answer = Math.max(as, answer);
                                acolor = atmp;
                                as = 1;
                            } else {
                                as++;
                            }
                        }
                    } else {
                        for (int a = 0; a < x; a++) {
                            int ntmp = number(map[a][ny]);
                            int otmp = number(map[a][j]);
                            int atmp = number(map[i][a]);
                            if (a == i) {
                                otmp = number(ch1);
                                ntmp = number(ch);
                            }
                            if (a == ny) {
                                atmp = number(map[i][j]);
                            }
                            if (a == j) {
                                atmp = number(map[i][ny]);
                            }
                            if (ocolor != otmp) {
                                answer = Math.max(os, answer);
                                ocolor = otmp;
                                os = 1;
                            } else {
                                os++;
                            }

                            if (ncolor != ntmp) {
                                answer = Math.max(ns, answer);
                                ncolor = ntmp;
                                ns = 1;
                            } else {
                                ns++;
                            }
                            if (acolor != atmp) {
                                answer = Math.max(as, answer);
                                acolor = atmp;
                                as = 1;
                            } else {
                                as++;
                            }
                        }
                    }
                    answer = Math.max(os, answer);
                    answer = Math.max(ns, answer);
                    answer = Math.max(as, answer);
                    if (answer == x) {
                        System.out.println(x);
                        return;
                    }
                }
            }
        }
        System.out.println(answer);

    }

    private static int number(char ch) {
        switch (ch) {
            case 'C':
                return 1;
            case 'P':
                return 2;
            case 'Z':
                return 3;
            case 'Y':
                return 0;

        }
        return 0;
    }
}