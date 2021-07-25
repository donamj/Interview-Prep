/*
    Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

    The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

    It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

    Example 1:
        Input: candidates = [2,3,6,7], target = 7
        Output: [[2,2,3],[7]]
        Explanation:
        2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
        7 is a candidate, and 7 = 7.
        These are the only two combinations.

    Example 2:
        Input: candidates = [2,3,5], target = 8
        Output: [[2,2,2,2],[2,3,3],[3,5]]
*/
import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum (int[] candidates, int target)
    {
    Arrays.sort(candidates);

        List<List<Integer>> results = new ArrayList<>();
        combinationSumHelper(results, new ArrayList<>(), candidates, target, 0);
        return results;
    }

    public void combinationSumHelper(List<List<Integer>> results, List<Integer> tempResult, int[] candidates, int target, int start) {
        if (target == 0) {
            results.add(new ArrayList<>(tempResult));
            return;
        }
        for (int i=start; i<candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            if (i != 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            tempResult.add(candidates[i]);
            combinationSumHelper(results, tempResult, candidates, target - candidates[i], i);
            tempResult.remove(tempResult.size()-1);
        }
    }
}
