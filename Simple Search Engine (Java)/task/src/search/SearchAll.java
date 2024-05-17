package search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SearchAll extends Search {
    public SearchAll(Map<String, ArrayList<Integer>> invertedIndex, ArrayList<String> people) {
        super(invertedIndex, people);
    }

    @Override
    public void search(String search) {
        String[] words = search.toLowerCase().split(" ");
        ArrayList<String> found = new ArrayList<>();

        for (String person : this.people) {
            boolean matchFound = true;
            int appropriateSearch = 0;
            for (String word : words) {
                for (String element: this.invertedIndex.keySet()) {
                    if (element.equalsIgnoreCase(word)) {
                        appropriateSearch++;
                    }
                }
                if (!person.toLowerCase().contains(word)) {
                    matchFound = false;
                    break;
                }
            }

            if (matchFound && appropriateSearch == words.length) {
                found.add(person);
            }
        }
        if (found.isEmpty()) {
            System.out.println("No matching people found.");
        } else {
            System.out.println(found.size() + " persons found.");
            found.stream().forEach(person -> System.out.println(person));
        }

    }
}