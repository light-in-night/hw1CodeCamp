/*
 HW1 Taboo problem class.
 Taboo encapsulates some rules about what objects
 may not follow other objects.
 (See handout).
*/
package assign1;

import java.util.*;

public class Taboo<T> {
    List<T> rules;

    /**
     * Constructs a new Taboo using the given rules (see handout.)
     *
     * @param rules rules for new Taboo
     */
    public Taboo(List<T> rules) {
        this.rules = new ArrayList<>(rules);
    }

    /**
     * Returns the set of elements which should not follow
     * the given element.
     *
     * @param elem element to not follow.
     * @return elements which should not follow the given element
     */
    @SuppressWarnings("unchecked")
	public Set<T> noFollow(T elem) {
        Set<T> noFollowSet = new HashSet<>();

        for (int i = 0; i < rules.size() - 1; i++) {
            if (rules.get(i) != null && rules.get(i + 1) != null) {
                if (rules.get(i).equals(elem)) {
                    noFollowSet.add(rules.get(i + 1));
                }
            }
        }
        return (Set<T>) (noFollowSet.isEmpty() ? Collections.emptySet() : noFollowSet);
    }

    /**
     * Removes elements from the given list that
     * violate the rules (see handout).
     *
     * @param list collection to reduce
     */
    public void reduce(List<T> list) {
        if (list.isEmpty())
            return;
        List<T> tabooedList = new ArrayList<>();
        tabooedList.add(list.get(0));
        Set<T> noFollowSet = noFollow(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            if (!noFollowSet.contains(list.get(i))) {
                tabooedList.add(list.get(i));
                noFollowSet = noFollow(list.get(i));
            }
        }

        list.clear();
        list.addAll(tabooedList);
    }
}
