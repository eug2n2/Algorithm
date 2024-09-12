import java.util.*;

class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];

        for (int i = 0; i < balls.length; i++) {
            int targetX = balls[i][0];
            int targetY = balls[i][1];

            int tmp = 0; 
            int result = Integer.MAX_VALUE;

            // 좌 
            // (targetX, targetY)를 좌측 벽에 반사시키면 (-targetX, targetY)
            if (!(startY == targetY && startX >= targetX)) {
                tmp = distance(startX, startY, targetX * (-1), targetY);
                result = Math.min(tmp, result);
            }

            // 우
            if (!(startY == targetY && startX <= targetX)) {
                tmp = distance(startX, startY, m + (m - targetX), targetY);
                result = Math.min(tmp, result);
            }

            // 상
            if (!(startX == targetX && startY <= targetY)) {
                tmp = distance(startX, startY, targetX, n + (n - targetY));
                result = Math.min(tmp, result);
            }

            // 하
            if (!(startX == targetX && startY >= targetY)) {
                tmp = distance(startX, startY, targetX, targetY * (-1));
                result = Math.min(tmp, result);
            }
            answer[i] = result;
        }

        return answer;
    }

    public int distance(int ax, int ay, int bx, int by) {
        return (int) (Math.pow(ax - bx, 2) + Math.pow(ay - by, 2));
    }
}