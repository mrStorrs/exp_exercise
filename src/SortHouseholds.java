import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public abstract class SortHouseholds {
    private HashMap<String, Household> households = new HashMap<>();

    /**
     * Sort given Households Hashmap by state -> city -> street
     */
    public List<String> sortHouseholds(HashMap<String, Household> households, Boolean DEBUG){
        List<String> householdByKey = new ArrayList<>(households.keySet());
        Collections.sort(householdByKey);

        if (DEBUG){
            System.out.println("*DEBUG* Sorted by Households: " + householdByKey);
        }

        return householdByKey;
    }

    public List<String> sortMembers(HashMap<String, HouseholdMember> members, int minimumAge, Boolean DEBUG){
        List<String> membersByKey = new ArrayList<>(members.keySet());
        Collections.sort(membersByKey);

        //look for members that don't meet the age requirement and remove them.
        for(String member : membersByKey){
            if(HouseholdMember.getMembers().get(member).getAge() < minimumAge){
                members.remove(member);

                if(DEBUG){
                    System.out.println("*DEBUG* Removing underage member: " + member);
                }
            }
        }

        if (DEBUG){
            System.out.println("*DEBUG* Sorted Members: " + membersByKey);
        }

        return membersByKey;
    }


    /**
     * This will accept a pre-sorted (you could input an un-sorted list as well.) list of households
     * to which it will then sort the members by lastName-> firstName. Option to remove under age given
     * @param DEBUG
     */
    public void sortAllMembersByHousehold(int minimumAge, Boolean DEBUG){
        //get all households
        HashMap<String, Household> households = Household.getHouseholds();
        //sort households.
        List<String> sortedHouseholds = sortHouseholds(households, DEBUG);

        //find members for each household, sort, then print out infos.
        for(String household: sortedHouseholds){
            Household householdObj = households.get(household);
            //used for member sorting
            HashMap<String, HouseholdMember> members = householdObj.getMembers();
            List<String> sortedMembers = sortMembers(members, minimumAge, DEBUG);

            //print Household & # of occupants
            System.out.println(
                    householdObj.getStreet()
                    + ", " + householdObj.getCity()
                    + ", " + householdObj.getState()
                    + " --- Household size: " + householdObj.getMembers().size()
            );

            for(String member : sortedMembers){
                HouseholdMember memberObj = HouseholdMember.getMembers().get(member);
                System.out.println(
                        "\t" + memberObj.getFirstName()
                        + " " + memberObj.getLastName()
                        + ", " + memberObj.getAge()
                );
            }
        }
    }

    public void sortAllMembers(Boolean displayHouseholds, int minimumAge, Boolean DEBUG){
        //see if we need to display households
        if (displayHouseholds){
            //get all households
            HashMap<String, Household> households = Household.getHouseholds();
            //sort households
            List<String> sortedHouseholds = sortHouseholds(households, DEBUG);
            for(String household : sortedHouseholds){
                Household currentHousehold = households.get(household);

                System.out.println(
                        currentHousehold.getStreet()
                        + ", " + currentHousehold.getCity()
                        + ", " + currentHousehold.getState()
                        + " --- Household size: " + currentHousehold.getMembers().size()
                );
            }
        }
        HashMap<String, HouseholdMember> members = HouseholdMember.getMembers();
        List<String> membersByKey = new ArrayList<>(members.keySet());
        Collections.sort(membersByKey);

        for(String member : membersByKey){
            HouseholdMember memberObj = HouseholdMember.getMembers().get(member);
            System.out.println(
                    "\t" + memberObj.getFirstName()
                            + " " + memberObj.getLastName()
                            + ", " + memberObj.getAge()
            );
        }
    }

}
