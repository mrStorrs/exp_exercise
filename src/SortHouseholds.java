import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public abstract class SortHouseholds {
    private HashMap<String, Household> households = new HashMap<>();

    /**
     * Sort Households by state -> city -> street ->
     * @param households
     */
    public List<String> sortHouseholds(HashMap<String, Household> households, Boolean DEBUG){
        List<String> householdByKey = new ArrayList<>(households.keySet());
        Collections.sort(householdByKey);

        if (DEBUG){
            System.out.println("Sorted by Households: " + householdByKey);
        }

        return householdByKey;
    }

    /**
     * This will accept a pre-sorted (you could input an un-sorted list as well.) list of households
     * to which it will then sort the members by lastName-> firstName. Following that it will remove
     * anyone under the age of 18.
     * @param sortedHouseholds
     * @param DEBUG
     */
    public void sortOver18MembersByHousehold(List<String> sortedHouseholds, Boolean DEBUG){
        for(String household : sortedHouseholds){
            System.out.println("sorting household: " + household);

            HashMap<String, Household> households;
            HashMap<String, HouseholdMember> members;

            households = Household.getHouseholds();
            members = households.get(household).getMembers();

            List<String> householdMembersByKey = new ArrayList<>(Household.getHouseholds().get(household).getMembers().keySet());
            Collections.sort(householdMembersByKey);

            for(String member : householdMembersByKey){
                if(members.get(member).getAge() < 18){
                    members.remove(member);

                    if(DEBUG){
                        System.out.println("Removing underage member: " + member);
                    }
                }
            }

            if (DEBUG){
                System.out.println("Sorted Members By Household: " + householdMembersByKey);
            }
        }
    }

}
