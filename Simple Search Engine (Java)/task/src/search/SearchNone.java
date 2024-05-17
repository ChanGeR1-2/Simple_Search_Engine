package search;

import java.util.ArrayList;
import java.util.Map;

public class SearchNone extends Search {
    public SearchNone(Map<String, ArrayList<Integer>> invertedIndex, ArrayList<String> people) {
        super(invertedIndex, people);
    }

    @Override
    public void search(String search) {
        String[] parts = search.split(" ");
        ArrayList<String> foundPeople = new ArrayList<>(this.people);
        for (String string : this.invertedIndex.keySet()) {
            for (String element : parts) {
                if (element.equalsIgnoreCase(string)) {
                    for (int value : this.invertedIndex.get(string)) {
                        foundPeople.remove(this.people.get(value));
                    }
                }
            }

        }
        System.out.println(foundPeople.size() + " persons found.");
        for (String person : foundPeople) {
            System.out.println(person);
        }
    }
}
