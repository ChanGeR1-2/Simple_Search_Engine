package search;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class FileReader {
    private Map<String, ArrayList<Integer>> invertedIndex;
    private ArrayList<String> people;

    public FileReader() {
        this.invertedIndex = new HashMap<>();
        this.people = new ArrayList<>();
    }

    public void read(File file) {
        try (Scanner scanner = new Scanner(file.toPath())) {
            int lineNumber = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                this.people.add(line);
                String[] words = line.split(" ");

                for (String word : words) {
                    if (!this.invertedIndex.containsKey(word)) {
                        this.invertedIndex.put(word, new ArrayList<>());
                    }
                    ArrayList<Integer> lineNumbers = this.invertedIndex.get(word);
                    if (!lineNumbers.contains(lineNumber)) {
                        lineNumbers.add(lineNumber);
                    }
                }
                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, ArrayList<Integer>> getInvertedIndex() {
        return this.invertedIndex;
    }

    public ArrayList<String> getPeople() {
        return this.people;
    }
}
