package a_exam;

import java.util.HashMap;
import java.util.Map;

public class task_3_1_Dictionary {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("No argument given");
            return;
        }

        String word = args[0];
        Map<Character, Integer> characters = new HashMap<>();

        for (char c : word.toCharArray()) {
            c = Character.toLowerCase(c);

            if (characters.containsKey(c)) {
                characters.put(c, characters.get(c) + 1);
            } else {
                characters.put(c, 1);
            }
        }

        System.out.println(characters);
    }
}
