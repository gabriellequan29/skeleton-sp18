import java.util.Calendar;

public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> characterDeque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i += 1) {
            Character character = word.charAt(i);
            characterDeque.addLast(character);
        }
        return characterDeque;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> characterDeque = wordToDeque(word);
        return isPalindromeHelper(characterDeque);
    }

    public boolean isPalindromeHelper(Deque<Character> characterDeque) {

        if (characterDeque.size() == 1 || characterDeque.size() == 0) {
            return true;
        } else {
            Character characterFirst = characterDeque.removeFirst();
            Character characterLast = characterDeque.removeLast();
            if (characterFirst != characterLast) {
                return false;
            } else {
                return isPalindromeHelper(characterDeque);
            }
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> characterDeque = wordToDeque(word);
        return isPalindromeHelper(characterDeque, cc);
    }

    public boolean isPalindromeHelper(Deque<Character> characterDeque, CharacterComparator cc) {

        if (characterDeque.size() == 1 || characterDeque.size() == 0) {
            return true;
        } else {
            Character characterFirst = characterDeque.removeFirst();
            Character characterLast = characterDeque.removeLast();
            if (cc.equalChars(characterFirst, characterLast)) {
                return isPalindromeHelper(characterDeque, cc);
            } else {
                return false;
            }
        }
    }
}
