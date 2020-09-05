package Amazon;

import java.util.*;

public class OptimalUtilization {
    /*
    * Given 2 lists a and b. Each element is a pair of integers
    * where the first integer represents the unique id and the second integer represents a value.
    * Your task is to find an element from a and an element form b
    * such that the sum of their values is less or equal to target and as close to target as possible.
    * Return a list of ids of selected elements.
    * If no pair is possible, return an empty list.
    *
    * Example 1:
    * Input:
    * a = [[1, 2], [2, 4], [3, 6]]
    * b = [[1, 2]]
    * target = 7
    * Output: [[2, 1]]
    * Explanation:
    * There are only three combinations [1, 1], [2, 1], and [3, 1],
    * which have a total sum of 4, 6 and 8, respectively.
    * Since 6 is the largest sum that does not exceed 7, [2, 1] is the optimal pair.
    * There were no hints explicitly mentioned in the problem description but in the editor,
    * it was explicitly mentioned that "return type should be a list of tuples".
    * So for zero pairs need to return [()] and this passes all test cases
     */

    public static List<List<Integer>> aircraftUtilization(int target, int[][] a, int[][] b){
        List<List<Integer>> res = new ArrayList<>();

       // if(len1 == 0 || len2 == 0) return res;
        Arrays.sort(a, (arr1,arr2) -> (arr1[1] - arr2[1]));
        Arrays.sort(b, (arr1, arr2) -> (arr1[1] - arr2[1]));
        int left = a.length;
        int i = 0;
        int j = b.length - 1;
        int goal = Integer.MIN_VALUE;
        Map<Integer, List<List<Integer>>> map = new HashMap<>();

        while(i < left && j >= 0){
            int sum = a[i][1] + b[j][1];
            //case1. invalid
            if(sum > target) {
                j--;
                continue;
            }
            //case2.when sum <= target
            if(sum >= goal){
                int r = j;
                map.putIfAbsent(sum, new ArrayList<>());
                // when duplication
                while(r >= 0 && b[r][1] == b[j][1]){
                    List<Integer> list = new ArrayList<>();
                    list.add(a[i][0]);
                    list.add(b[r][0]);
                    map.get(sum).add(list);
                    r--;
                }
                goal = sum;//update the largest target
            }
            i++;//move left pointer
        }
        return map.get(goal) == null ? new ArrayList<>(): map.get(goal);
    }

//    public static void main(String[] args) {
//
//        int maxTravelDists = -56;
//        int[][] forwardRouteLists ={ {1,1},{2,-3},{3,2},{4,1},{5,7},{6,11}};
//
//        int[][] returnRouteLists ={{1,-2},{2,0},{3,-5},{4,-1},{5,-1},{6,5}};
//
//        System.out.println(aircraftUtilization(maxTravelDists, forwardRouteLists, returnRouteLists));
//
//    }

}
