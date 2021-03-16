package nl.hu.cisq1.lingo.trainer.domain;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
public class Validator {
    private final String guess;
    private final String word;

    public List<Mark> validate() {
        HashMap<Character, Integer> availableChars = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (letter != guess.charAt(i)) {
                int count = availableChars.getOrDefault(letter, 0);
                availableChars.put(letter, count + 1);
            }
        }
        List<Mark> marks = new ArrayList<>();
        for (int i = 0; i < guess.length(); i++) {
            char letter = guess.charAt(i);
            char actualLetter = word.charAt(i);
            if (letter == actualLetter) {
                marks.add(Mark.CORRECT);
            } else {
                int count = availableChars.getOrDefault(letter, 0);
                if (count > 0) {
                    marks.add(Mark.PRESENT);
                    availableChars.put(letter, count - 1);
                } else marks.add(Mark.ABSENT);
            }
        }
        return marks;
    }
}
