package search;

import java.util.*;

public class UserInterface {
    private Scanner scanner;
    private SearchEngine engine;

    public UserInterface(Scanner scanner, SearchEngine engine) {
        this.scanner = scanner;
        this.engine = engine;
    }

    public void start() {
        loop:
        while (true) {
            System.out.println("=== Menu ===\n1. Find a person\n2. Print all people\n0. Exit");
            String input = this.scanner.nextLine();
            switch (input) {
                case "0":
                    System.out.println("Bye!");
                    break loop;
                case "1":
                    String strategy;
                    while (true) {
                        System.out.println("Select a matching strategy: ALL, ANY, NONE");
                        strategy = this.scanner.nextLine();
                        if (strategy.matches("ALL|ANY|NONE")) {
                            break;
                        }
                    }
                    engine.setStrategy(strategy);
                    System.out.println("Enter a name or email to search all suitable people.");
                    String search = this.scanner.nextLine();
                    engine.search(search);
                    break;
                case "2":
                    System.out.println("=== List of people ===");
                    engine.printAll();
                    break;
                default:
                    System.out.println("Unsuitable input.");
                    break;
            }
        }
    }



}
