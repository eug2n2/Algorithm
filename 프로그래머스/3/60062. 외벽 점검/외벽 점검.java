import java.util.*;

class Solution {
    static int answer, w, u;
    
    public int solution(int n, int[] weak, int[] dist) {
        w = weak.length;
        u = dist.length;
        Arrays.sort(dist);
        answer = u + 1;
        boolean[] vis = new boolean[w];
        select(n, weak, vis, dist, 0);
        if (answer == u + 1) return -1;
        return answer;
    }
    
    public void dfs(int n, int[] weak, boolean[] vis, int[] dist, int val, int start, int startidx) {
        if (answer <= val) return;
        if (val == u + 1) return;
        
        // 현재 상태 저장
        boolean[] tempVis = new boolean[w];
        System.arraycopy(vis, 0, tempVis, 0, w);
        
        // 시계방향으로 확인
        for (int i = startidx; i < w; i++) {
            if (vis[i]) continue;
            
            if (dist[u-1-val] + start < weak[i]) {
                select(n, weak, vis, dist, val + 1);
                // 상태 복원
                System.arraycopy(tempVis, 0, vis, 0, w);
                return;
            }
            
            vis[i] = true;
            if (countVisited(vis) == w) {
                answer = Math.min(answer, val + 1);
                return;
            }
        }
        
        // 원형으로 0을 지나는 경우 처리
        if (dist[u-1-val] + start >= n) {
            for (int i = 0; i < startidx; i++) {
                if (vis[i]) continue;
                
                if (dist[u-1-val] + start < weak[i] + n) {
                    select(n, weak, vis, dist, val + 1);
                    // 상태 복원
                    System.arraycopy(tempVis, 0, vis, 0, w);
                    return;
                }
                
                vis[i] = true;
                if (countVisited(vis) == w) {
                    answer = Math.min(answer, val + 1);
                    return;
                }
            }
        }
        
        select(n, weak, vis, dist, val + 1);
        // 상태 복원
        System.arraycopy(tempVis, 0, vis, 0, w);
    }
    
    public void select(int n, int[] weak, boolean[] vis, int[] dist, int val) {
        if (val == u || answer <= val) return;
        
        boolean[] tempVis = new boolean[w];
        System.arraycopy(vis, 0, tempVis, 0, w);
        
        for (int i = 0; i < w; i++) {
            if (vis[i]) continue;
            dfs(n, weak, vis, dist, val, weak[i], i);
            System.arraycopy(tempVis, 0, vis, 0, w);
        }
    }
    
    private int countVisited(boolean[] vis) {
        int count = 0;
        for (boolean v : vis) {
            if (v) count++;
        }
        return count;
    }
}