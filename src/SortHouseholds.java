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
    public void sortHouseholds(HashMap<String, Household> households, Boolean DEBUG){
        List<String> householdByKey = new ArrayList<>(households.keySet());
        Collections.sort(householdByKey);

        if (DEBUG){
            System.out.println("Sorted by Households: " + householdByKey);
        }
    }

    public void sortMembersByHousehold(ArrayList<String> sortedHouseholds, Boolean DEBUG){
        for(String household : sortedHouseholds){
        }
    }

}
