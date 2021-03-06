package com.zxd.test.leetcode;

/**
 * @ClassName IsInterleave_97
 * @Description https://leetcode-cn.com/problems/interleaving-string/
 * @Author xiaodong.zou
 * @Date 2020/7/18 22:03
 * @Version 1.0
 */

//97. 交错字符串
//        给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
//
//        示例 1:
//
//        输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//        输出: true
//        示例 2:
//
//        输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//        输出: false
public class IsInterleave_97 {

    public static void main(String[] args) {
        IsInterleave_97 interleave = new IsInterleave_97();
        System.out.println(interleave.isInterleave("aabcc",  "dbbca", "aadbbcbcac"));
        System.out.println(interleave.isInterleave("aabcc",  "dbbca", "aadbbbaccc"));
    }

    /**
     * 方法一：动态规划
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();
        if (n + m != t) {
            return false;
        }
        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    f[i][j] = f[i][j] || (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }
        return f[n][m];
    }
}
