import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        int[] A1 = {1, 3, 6, 1, 6, 6, 9, 9};
        System.out.println("Expected: 19, Got: " + sol.solution(A1));

        // Test Case 2
        int[] A2 = {5, 1, 4, 3};
        System.out.println("Expected: -1, Got: " + sol.solution(A2));

        // Test Case 3
        int[] A3 = {2, 2, 2, 3, 2};
        System.out.println("Expected: 11, Got: " + sol.solution(A3));

        // Edge Case 4: Only two same elements
        int[] A4 = {10, 10};
        System.out.println("Expected: 20, Got: " + sol.solution(A4));

        // Edge Case 5: Long array with repeated elements
        int[] A5 = new int[100000];
        Arrays.fill(A5, 7);
        System.out.println("Expected: 700000, Got: " + sol.solution(A5));
    }
}

class Solution {
    public int solution(int[] A) {
        int n = A.length;
        Map<Integer, Integer> firstIndexMap = new HashMap<>();
        int maxSum = -1;

        // Prefix sum array
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + A[i];
        }

        for (int i = 0; i < n; i++) {
            if (!firstIndexMap.containsKey(A[i])) {
                firstIndexMap.put(A[i], i);
            } else {
                int startIdx = firstIndexMap.get(A[i]);
                int sum = prefixSum[i + 1] - prefixSum[startIdx];
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}
