package search;

import java.util.ArrayList;
import java.util.Map;

public abstract class Search {
    protected Map<String, ArrayList<Integer>> invertedIndex;
    protected ArrayList<String> people;

    public Search(Map<String, ArrayList<Integer>> invertedIndex, ArrayList<String> people) {
        this.invertedIndex = invertedIndex;
        this.people = people;
    }

    public abstract void search(String search);

}
