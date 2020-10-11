package Array;

public class GasStation {

    class Solution {

        //https://blog.csdn.net/qq508618087/article/details/50990076
        //start from index 0 as the startIndex, each station, we add the gas and minus the cost
        //each index, we weill check if current station left > 0,
        //if not, we can only start from the next index and go back later on.
        //time:O(n)
        //space: O(1)
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int left = 0;//how much gas needed or left from index 0 till current
            int lack = 0;
            int startIndex = 0;

            for (int i = 0; i < gas.length; i++) {
                left += gas[i] - cost[i];
                //we can't start from startIndex, try next index i + 1
                if (left < 0) {
                    startIndex = i + 1;
                    lack += left;
                    left = 0;//clear up all pevious
                }
            }

            return left + lack >= 0 ? startIndex : -1;
        }
    }
}
