import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public abstract class SortHouseholds {
    /**
     * Sort given Households Hashmap by state -> city -> street
     * @param households a hash map holding all Household objects to be sorted
     */
    public List<String> sortHouseholds(HashMap<String, Household> households, Boolean DEBUG){
        List<String> householdByKey = new ArrayList<>(households.keySet());
        Collections.sort(householdByKey);

        if (DEBUG){
            System.out.println("*DEBUG* Sorted by Households: " + householdByKey);
        }

        return householdByKey;
    }

    /**
     * Sort all members passed in by hashmap, while removing anyone below the minimum age.
     * @param members hash map holding all members to be sorted
     * @param minimumAge minimum age of members that should be returned
     * @return returns all sorted members without anyone below the minimum age.
     */
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
     * This will sort all members within each household. This will display they household,
     * then all members associated with that household before moving onto the next household.
     * @param minimumAge the minimum age of the members to be included in the list
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
            System.out.println(householdObj.getInfo());

            for(String member : sortedMembers){
                HouseholdMember memberObj = HouseholdMember.getMembers().get(member);
                System.out.println("\t" + memberObj.getMemberInfo());
            }
        }
    }

    /**
     * This will sort ALL members regardless of household by Last->First. Households may be displayed at the top.
     * @param displayHouseholds whether or not the households should be displayed at the top.
     * @param minimumAge the minimum age of the members you want to be shown.
     */
    public void sortAllMembers(Boolean displayHouseholds, int minimumAge, Boolean DEBUG){
        HashMap<String, Household> households = Household.getHouseholds();

        //see if we need to display households
        if (displayHouseholds){
            //get all households
            //sort households
            List<String> sortedHouseholds = sortHouseholds(households, DEBUG);
            for(String household : sortedHouseholds){
                Household currentHousehold = households.get(household);

                System.out.println(currentHousehold.getInfo());
            }
        }

        //sort members then display them.
        HashMap<String, HouseholdMember> members = HouseholdMember.getMembers();
        List<String> sortedMembers = sortMembers(members, minimumAge, DEBUG);
        for(String member : sortedMembers){
            HouseholdMember memberObj = HouseholdMember.getMembers().get(member);
            if(memberObj != null){ //ensure that the member was not removed due to low age.
                Household membersHouseholdObj = memberObj.getHousehold();
                System.out.println(
                        "\t" + memberObj.getMemberInfo()
                        + ", " + membersHouseholdObj.getAddress());
            }

        }
    }

}
