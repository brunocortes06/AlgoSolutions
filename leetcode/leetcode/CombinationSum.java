/*
Given a set of candidate numbers (C) (without duplicates) and a target number 
(T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);

        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> list, int sum, int[] candidates, int target, int position) {
        if (sum == target) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = position; i < candidates.length; ++i) {
            list.add(candidates[i]);
            dfs(result, list, sum + candidates[i], candidates, target, i + 1);
            list.remove(list.size() - 1);
        }
    }

}
