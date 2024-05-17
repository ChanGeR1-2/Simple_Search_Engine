package search;

import java.util.ArrayList;
import java.util.Map;

public class SearchEngine {
    private Map<String, ArrayList<Integer>> invertedIndex;
    private ArrayList<String> people;
    private Search strategy;

    public SearchEngine(Map<String, ArrayList<Integer>> invertedIndex, ArrayList<String> people) {
        this.invertedIndex = invertedIndex;
        this.people = people;
    }

    public Map<String, ArrayList<Integer>> getInvertedIndex() {
        return this.invertedIndex;
    }

    public void printAll() {
        this.people.stream().forEach(person -> System.out.println(person.trim()));
    }

    public void setStrategy(String strategy) {
        switch(strategy) {
            case "ALL":
                this.strategy = new SearchAll(this.invertedIndex, this.people);
                break;
            case "ANY":
                this.strategy = new SearchAny(this.invertedIndex, this.people);
                break;
            case "NONE":
                this.strategy = new SearchNone(this.invertedIndex, this.people);
                break;
        }
    }

    public void search(String search) {
        this.strategy.search(search);
    }
}
