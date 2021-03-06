package com.cckeep.leetcode.algorithms;

/**
 *
 * 剑指 Offer 13. 机器人的运动范围
 * @author: jixd
 * @date: 2021/3/6 4:18 下午
 */
public class Offer13 {
    int m,n,k;
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        visited = new boolean[m][n];
        return dfs(0,0,0,0);
    }


    public int dfs(int i,int j,int si,int sj){
        if (i >= m || j >= n || si + si > k || visited[i][j]) return 0;
        visited[m][n] = true;
        return 1 + dfs(i + 1,j,(si + 1) % 10 == 0 ? si - 8 : si + 1,sj) + dfs(i,j+1,si,(sj + 1) % 10 == 0 ? sj - 8 : si + 1);
    }
}
