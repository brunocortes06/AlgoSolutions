/*
 * Given n balloons, indexed from 0 to n-1. Each balloon is 
 * painted with a number on it represented by array nums. 
 * You are asked to burst all the balloons. If the you burst 
 * balloon i you will get nums[left] * nums[i] * nums[right] 
 * coins. Here left and right are adjacent indices of i. 
 * After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the 
balloons wisely.
- You may imagine nums[-1] = nums[n] = 1. They are not real 
therefore you can not burst them.
- 0 <= n <= 500, 0 <= nums[i] <= 100

Example
Given [4, 1, 5, 10]
Return 270

nums = [4, 1, 5, 10] burst 1, get coins 4 * 1 * 5 = 20
nums = [4, 5, 10]    burst 5, get coins 4 * 5 * 10 = 200 
nums = [4, 10]       burst 4, get coins 1 * 4 * 10 = 40
nums = [10]          burst 10, get coins 1 * 10 * 1 = 10

Total coins 20 + 200 + 40 + 10 = 270
 */
public class BurstBalloons {

    /**
     * @param nums a list of integer
     * @return an integer, maximum coins
     */
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] coin = new int[nums.length + 2];
        for (int i = 0; i < nums.length; ++i) {
            coin[i + 1] = nums[i];
        }
        coin[0] = coin[nums.length + 1] = 1;
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 1; i < nums.length - 1; ++i) {
            for (int j = 0; j <= i; ++j) {
                int tmp = Integer.MIN_VALUE;
                for (int k = i; k > j; --k) {
                    tmp = Math.max(tmp, dp[i][k - 1] + dp[k + 1][j] + 
                            nums[i - 1] * nums[k] * nums[j + 1]);
                }
                dp[i][j] = tmp;
            }
        }
        return dp[0][nums.length - 1];
    }

}
