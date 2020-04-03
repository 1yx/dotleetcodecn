/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */

// s  ( ( ( ) ( ) ) ) ( )  )
// i  0 1 2 3 4 5 6 7 8 9  10
// dp 0 0 0 2 0 4 6 7 0 10 0
// @date Mar 12 2020
// class Solution {
//     public int longestValidParentheses(String s) {
//         int l = s.length(), res = 0;
//         if (l == 0) return 0;
//         int[] dp = new int[l]; // close parenthesis
//         for (int i = 1; i < l; i ++) {
//             if (s.charAt(i) == ')') {
//                 if (s.charAt(i - 1) == '(') {
//                     dp[i]= 2;
//                     if (i - 2 >= 0)
//                         dp[i] += dp[i - 2];
//                 } else if (i - 1 - dp[i - 1] >= 0 && s.charAt(i - 1 - dp[i - 1]) == '(') {
//                     dp[i] = dp[i - 1] + 2;
//                     if (i - 1 - dp[i - 1] - 1 >= 0)
//                         dp[i] += dp[i - 1 - dp[i - 1] - 1];
//                 }
//             }
//             res = Math.max(res, dp[i]);
//         }
//         return res;
//     }
// }


// s    ( ( ( ) ( ) ) ) ( )  )
// i  0 1 2 3 4 5 6 7 8 9 10 11
// dp 0 0 0 0 2 0 4 6 8 0 10 0
// class Solution {
//     public int longestValidParentheses(String s) {
//         int l = s.length(), res = 0;
//         if (l == 0) return 0;
//         int dp[] = new int[l + 1];
//         for (int i = 2; i <= l; i ++) {
//             if (s.charAt(i - 1) == '(') continue;
//             int open1 = i - 2, open2 = i - 2 - dp[i - 1];
//             if (s.charAt(open1) == '(')
//                 dp[i] = dp[open1] + 2;
//             else if (open2 >= 0 && s.charAt(open2) == '(') 
//                 dp[i] = dp[i - 1] + dp[open2] + 2;
//             res = Math.max(res, dp[i]);
//         }
//         return res;
//     }
// }



// @lc code=start
// @date Apr 1 2020
// s  ) ) ( ( ( ) ( ) ) ) (  )  )
// i  0 1 2 3 4 5 6 7 8 9 10 11 12
// dp 0 0 0 0 0 2 0 4 6 8 0  10 0
// @solution dp
class Solution {
    public int longestValidParentheses(String s) {
        int len = s.length(), res = 0;
        char[] parenthese = new char[len + 2];
        parenthese[0] = parenthese[1] = ')';
        System.arraycopy(s.toCharArray(), 0, parenthese, 2, len);
        int[] dp = new int[len + 2];
        for (int i = 2; i < len + 2; i ++) {
            if (parenthese[i] == '(') continue;
            int prev = i - 1, open = i - dp[prev] - 1;
            if (parenthese[prev] == '(')
                dp[i] = dp[prev - 1] + 2;
            else if (parenthese[open] == '(')
                dp[i] = dp[open - 1] + dp[prev] + 2;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

// @lc code=end

