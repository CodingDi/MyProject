package DFS;

import java.util.ArrayList;
import java.util.List;

public class AllPermutationOfSubsets {
        public List<String> allPermutationsOfSubsets(String set) {
            // Write your solution here
            List<String> res = new ArrayList<>();
            if (set == null) {
                return res;
            }

            char[] arr = set.toCharArray();
            StringBuilder sb = new StringBuilder();
            helper(res, arr, 0);
            return res;
        }

        private void helper(List<String> res, char[] arr, int index) {
            //base case
            res.add(new String(arr, 0, index));
            if (index == arr.length) {
                return;
            }

            for (int i = index; i < arr.length; i++) {
                swap(arr, i, index);
                helper(res, arr, index + 1);
                swap(arr, index, i);
            }
        }

        private void swap(char[] arr, int left, int right) {
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
        }

}
