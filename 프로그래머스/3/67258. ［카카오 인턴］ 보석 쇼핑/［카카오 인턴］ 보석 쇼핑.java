// 시간복잡도 o(nlogn) 이하
import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int n = gems.length;
        Set<String> gemTypes = new HashSet<>(); // 모든 보석 종류
        for(int i =0;i<n;i++){
            gemTypes.add(gems[i]);
        }
        int kind = gemTypes.size(); // 보석 종류

        Map<String, Integer> gemCount = new HashMap<>();
        int minLen = n;
        int answerStart = 0, answerEnd = 0;

        int left = 0, right = 0;
        while (right < n) {
            // 현재 보석을 포함
            gemCount.put(gems[right], gemCount.getOrDefault(gems[right], 0) + 1);

            // 모든 보석을 포함하는 경우 -> 최소 길이 갱신 가능
            while (gemCount.size() == kind) {
                if (right - left < minLen) {
                    minLen = right - left;
                    answerStart = left;
                    answerEnd = right;
                }

                // 왼쪽 포인터 이동 (현재 보석 제거)
                gemCount.put(gems[left], gemCount.get(gems[left]) - 1);
                // 더 이상 제거할 수 없음 
                if (gemCount.get(gems[left]) == 0) {
                    gemCount.remove(gems[left]);
                }
                left++;
            }
            right++;
        }

        return new int[]{answerStart + 1, answerEnd + 1}; 
    }
}
