package search;

import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (args[0].equals("--data")) {
            File input = new File(args[1]);
            System.out.println(input.getAbsolutePath());
            var reader = new FileReader();
            reader.read(input);
            var engine = new SearchEngine(reader.getInvertedIndex(), reader.getPeople());
            UserInterface ui = new UserInterface(scanner, engine);

            ui.start();
        }


    }
}
