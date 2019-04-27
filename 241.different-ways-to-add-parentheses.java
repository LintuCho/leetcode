import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * [241] Different Ways to Add Parentheses
 *
 * https://leetcode.com/problems/different-ways-to-add-parentheses/description/
 *
 * algorithms
 * Medium (46.31%)
 * Total Accepted:    56.1K
 * Total Submissions: 121K
 * Testcase Example:  '"2-1-1"'
 *
 * Given a string of numbers and operators, return all possible results from
 * computing all the different possible ways to group numbers and operators.
 * The valid operators are +, - and *.
 * 
 * Example 1:
 * 
 * 
 * Input: "2-1-1"
 * Output: [0, 2]
 * Explanation: 
 * ((2-1)-1) = 0 
 * (2-(1-1)) = 2
 * 
 * Example 2:
 * 
 * 
 * Input: "2*3-4*5"
 * Output: [-34, -14, -10, -10, 10]
 * Explanation: 
 * (2*(3-(4*5))) = -34 
 * ((2*3)-(4*5)) = -14 
 * ((2*(3-4))*5) = -10 
 * (2*((3-4)*5)) = -10 
 * (((2*3)-4)*5) = 10
 * 
 * 
 */
class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> list = new ArrayList<>();
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        if (!(input.contains("-") || input.contains("+") || input.contains("*"))) {
            list.add(Integer.valueOf(input));
            return list;
        }
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+') {
                left = diffWaysToCompute(input.substring(0, i));
                right = diffWaysToCompute(input.substring(i + 1));
                for (int var : left) {
                    for (int varr : right) {
                        // if (!list.contains(var + varr))
                        list.add(var + varr);
                    }
                }
            }
            if (input.charAt(i) == '*') {
                left = diffWaysToCompute(input.substring(0, i));
                right = diffWaysToCompute(input.substring(i + 1));
                for (int var : left) {
                    for (int varr : right) {
                        // if (!list.contains(var * varr))
                        list.add(var * varr);
                    }
                }
            }
            if (input.charAt(i) == '-') {
                left = diffWaysToCompute(input.substring(0, i));
                right = diffWaysToCompute(input.substring(i + 1));
                for (int var : left) {
                    for (int varr : right) {
                        // if (!list.contains(var - varr))
                        list.add(var - varr);
                    }
                }
            }
        }
        Collections.sort(list);
        return list;
    }
}
