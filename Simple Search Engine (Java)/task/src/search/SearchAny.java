package search;

import java.util.ArrayList;
import java.util.Map;

public class SearchAny extends Search {
    public SearchAny(Map<String, ArrayList<Integer>> invertedIndex, ArrayList<String> people) {
        super(invertedIndex, people);
    }

    @Override
    public void search(String search) {
        boolean found = false;
        ArrayList<String> foundPeople = new ArrayList<>();
        String[] parts = search.split(" ");

        for (String string : this.invertedIndex.keySet()) {
            for (String element: parts) {
                if (element.equalsIgnoreCase(string)) {
                    found = true;
                    for (int value : this.invertedIndex.get(string)) {
                        if (!foundPeople.contains(this.people.get(value))) {
                            foundPeople.add(this.people.get(value));
                        }
                    }
                }
            }
        }
        System.out.println(foundPeople.size() + " persons found.");
        for (String person: foundPeople) {
            System.out.println(person);
        }
        if (!found) {
            System.out.println("No matching people found.");
        }
    }
}
