package com.cckeep.leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: jixd
 * @date: 2021/3/3 1:38 下午
 */
public class Solution887 {


    public static void main(String[] args) {

    }

    Map<Integer, Integer> map = new HashMap<>();

    public int superEggDrop(int K, int N) {
        return dp(K, N);
    }

    public int dp(int K, int N) {
        if (N == 0) return 0;
        if (K == 1) return N;
        if (map.containsKey(N * 100 + K)) {
            return map.get(N * 100 + K);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            res = Math.min(res, Math.max(dp(K, N - i), dp(K - 1, i - 1)) + 1);
        }
        map.put(N * 100 + K, res);
        return res;
    }

}
