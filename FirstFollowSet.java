import java.util.*;

public class FirstFollowSet {
    private final String[] termTokens = {"a", "b", "c"}; // Example terminal tokens
    private final String[] nonTermTokens = {"E", "A", "B", "C"}; // Example non-terminal tokens
    private RuleStack rules;
    private Map<String, Set<String>> firstSet;
    private Map<String, Set<String>> followSet;

    // Check if a string is a terminal
    private boolean isTerminal(String str) {
        return Arrays.asList(termTokens).contains(str);
    }

    // Check if a string is a non-terminal
    private boolean isNonTerminal(String str) {
        return Arrays.asList(nonTermTokens).contains(str);
    }

    // Define a production rule
    private class Rule {
        String def, token;

        public Rule(String t, String d) {
            token = t;
            def = d;
        }

        public String toString() {
            return token + " " + def + '\n';
        }
    }

    // Define the grammar rules
    public class RuleStack {
        List<Rule> rules;

        public RuleStack() {
            rules = new ArrayList<>();
        }

        // Method to add a production rule
        public void addRule(String rule) {
            String[] parts = rule.split(" -> ");
            Rule newRule = new Rule(parts[0], parts[1]);
            rules.add(newRule);
        }
    }

    public FirstFollowSet() {
        rules = new RuleStack(); // Initialize rule stack
        firstSet = new HashMap<>();
        followSet = new HashMap<>();
    }

    // Method to compute First set for a given string
    public Set<String> findFirstSet(String str) {
        Set<String> result = new HashSet<>();

        if (isTerminal(str)) {
            result.add(str);
        } else if (isNonTerminal(str)) {
            for (Rule rule : rules.rules) {
                if (rule.token.equals(str)) {
                    String[] tokens = rule.def.split(" ");
                    result.addAll(findFirstSet(tokens[0]));
                }
            }
        }

        return result;
    }

    // Method to compute Follow set for a given non-terminal
    public Set<String> findFollowSet(String nonTerm) {
        // Implement your logic here
        // ...
        return new HashSet<>(); // Placeholder
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an instance of FirstFollowSet
        FirstFollowSet ffSet = new FirstFollowSet();

        // Prompt the user to enter production rules
        System.out.println("Enter production rules in the format 'A -> B C', enter 'done' to finish:");
        String input = scanner.nextLine();
        while (!input.equals("done")) {
            ffSet.rules.addRule(input);
            input = scanner.nextLine();
        }

        // Compute and display FIRST sets for each non-terminal
        for (String nonTerm : ffSet.nonTermTokens) {
            ffSet.firstSet.put(nonTerm, ffSet.findFirstSet(nonTerm));
            System.out.println("First set of " + nonTerm + ": " + ffSet.firstSet.get(nonTerm));
        }

        scanner.close();
    }
}
