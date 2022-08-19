// Time Complexity : O(N*3) = O(N)
// Where N is number of rows in costs array
// Space Complexity : O(N*3) = O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/*
The bruteforce approach would be checking three different possibilities, at index 0 starting with R , next
possibility would be starting with B and starting with G. Then we would take the minimum from all these three
paths. The DP solution would be constructing at each level from both, we would take the minimum cost and
traverse to root node.
 */


class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs[0].length==0) return 0;
        int n = costs.length;
        int[][] dp = new int[n+1][3];

        int caseR = costs[n-1][0];
        int caseB = costs[n-1][1];
        int caseG = costs[n-1][2];

        for(int i=n-2;i>=0;i--){
            int tempR = caseR;
            int tempB = caseB;

            caseR = costs[i][0] + Math.min(caseB, caseG);
            caseB = costs[i][1] + Math.min(tempR, caseG);
            caseG = costs[i][2] + Math.min(tempB, tempR);
        }

        return Math.min(caseR, Math.min(caseB, caseG));
    }
}