// Time Complexity : O(N*M)
// Where N is number of coins in an array and M is the amount
// Space Complexity : O(N*M)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/*
Similar solution to CoinChange-1, here are counting all the possbilities whereas in CoinChange-1 we coinsidered
minimum count of coins. Both time and space complexity are same for both the problems.
 */

class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;

        int[][] dp = new int[m+1][n+1];

        dp[0][0] = 1;

        for(int i=1;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }

        return dp[m][n];
    }
}