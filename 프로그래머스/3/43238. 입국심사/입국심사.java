class Solution {
    public long solution(int n, int[] times) {
        long left = 1;
        int max = 0;
        for (int t : times) {
            max = Math.max(max, t);
        }
        long right = (long) max * n;
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;  

            long people = 0;

            // ⭐ mid 시간 동안 몇 명 처리 가능한지 계산
            for (int t : times) {
                people += mid / t;
                if (people >= n) break;
            }

            if (people >= n) {
                answer = mid;       // 가능 → 더 줄여보기
                right = mid - 1;
            } else {
                left = mid + 1;     // 부족 → 늘리기
            }
        }

        return answer;
    }
}