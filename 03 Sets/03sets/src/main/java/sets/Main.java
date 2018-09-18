package sets;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Integer> members = new HashSet<>();
        members.add(1);
        members.add(2);
        members.add(3);
        Sets intSet = new SetsImpl<Integer>(false, false,members);

        Set<Integer> secondMembers = new HashSet<>();
        secondMembers.add(3);
        secondMembers.add(4);
        secondMembers.add(5);

        Sets<Integer> secondSet = new SetsImpl(true, false, secondMembers);

        Sets unionedSet = intSet.union(secondSet);

        unionedSet.printFormatted("Union Set: ");

        Sets intersection = intSet.intersection(secondSet);
        intersection.printFormatted("Intersection Set: ");

        Set<Integer> thirdMembers = new HashSet<>();
        thirdMembers.add(1);
        thirdMembers.add(2);
        thirdMembers.add(3);
        thirdMembers.add(4);

        Sets<Integer> thirdSet = new SetsImpl(thirdMembers);
        System.out.println(intSet.compareTo(thirdSet));
        
        intSet.printFormatted("Set A: ");
        secondSet.printFormatted("Set B: ");
        
//        Sets complementSet = intSet.complement(secondSet);
        Sets complementSet = intSet.complement(null);
        complementSet.printFormatted("Complement Set --> ");
    }
}
