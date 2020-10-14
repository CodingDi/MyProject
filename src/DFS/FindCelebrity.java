package DFS;

import javax.management.ObjectName;
import javax.management.relation.*;
import java.util.List;
import java.util.Map;

public class FindCelebrity implements Relation {

    /* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

        int numberOfPeople;
        public int findCelebrity(int n) {
            numberOfPeople = n;
            int candidate = 0;

            for (int i = 0; i < n; i++) {
                if (i == candidate) {
                    continue;
                }
                if (knows(candidate, i)) {
                    candidate = i;//candidate dont know any 0 to i-1, so 0 - (i-1) can't be candidate
                }
                if (isCelebrity(candidate)) {
                    return candidate;
                }
            }

            return -1;
        }

    private boolean knows(int candidate, int i) {
            return false;
    }

    private boolean isCelebrity(int candidate) {
            for (int i = 0; i < numberOfPeople; i++) {
                if (candidate == i) {
                    continue;
                }
                if (knows(candidate, i) || !knows(i, candidate)) {
                    return false;
                }
            }
            return true;

    }

    @Override
    public List<ObjectName> getRole(String roleName) throws IllegalArgumentException, RoleNotFoundException, RelationServiceNotRegisteredException {
        return null;
    }

    @Override
    public RoleResult getRoles(String[] roleNameArray) throws IllegalArgumentException, RelationServiceNotRegisteredException {
        return null;
    }

    @Override
    public Integer getRoleCardinality(String roleName) throws IllegalArgumentException, RoleNotFoundException {
        return null;
    }

    @Override
    public RoleResult getAllRoles() throws RelationServiceNotRegisteredException {
        return null;
    }

    @Override
    public RoleList retrieveAllRoles() {
        return null;
    }

    @Override
    public void setRole(Role role) throws IllegalArgumentException, RoleNotFoundException, RelationTypeNotFoundException, InvalidRoleValueException, RelationServiceNotRegisteredException, RelationNotFoundException {

    }

    @Override
    public RoleResult setRoles(RoleList roleList) throws IllegalArgumentException, RelationServiceNotRegisteredException, RelationTypeNotFoundException, RelationNotFoundException {
        return null;
    }

    @Override
    public void handleMBeanUnregistration(ObjectName objectName, String roleName) throws IllegalArgumentException, RoleNotFoundException, InvalidRoleValueException, RelationServiceNotRegisteredException, RelationTypeNotFoundException, RelationNotFoundException {

    }

    @Override
    public Map<ObjectName, List<String>> getReferencedMBeans() {
        return null;
    }

    @Override
    public String getRelationTypeName() {
        return null;
    }

    @Override
    public ObjectName getRelationServiceName() {
        return null;
    }

    @Override
    public String getRelationId() {
        return null;
    }
}
