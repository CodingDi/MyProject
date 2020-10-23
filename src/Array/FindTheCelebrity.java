package Array;

import javax.management.relation.Relation;

public class FindTheCelebrity {

    /* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

        int numberOfPeople ;
        public int findCelebrity(int n) {
            numberOfPeople = n;
            int candidate = 0;

            for (int i = 0; i < numberOfPeople; i++) {
                if (knows(candidate, i)) {
                    candidate = i;
                }
            }

            if (isCelebrity(candidate)) {
                return candidate;
            }

            return -1;
        }

        //check if the candidate is celebrity
        private boolean isCelebrity(int candidate) {
            for (int i = 0; i < numberOfPeople; i++) {
                if (i == candidate) {
                    continue;
                }
                if (knows(candidate, i) || !knows(i, candidate)) {
                    return false;
                }
            }
            return true;
        }

        private boolean knows(int candidate, int i) {
            return true;
        }

}
