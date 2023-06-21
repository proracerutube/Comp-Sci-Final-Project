import java.util.*;

// Defines question and uses arrays and other data types to ask the questions
class Question {
    private final String question;
    private List<String> choices;
    private int correctIndex;
    private final String difficulty;

    public Question(String question, String[] choices, int correctIndex, String difficulty) {
        this.question = question;
        this.choices = new ArrayList<>(Arrays.asList(choices));
        this.correctIndex = correctIndex;
        this.difficulty = difficulty;
    }

    public String getQuestion() {
        return this.question;
    }

    public String getDifficulty() {
        return this.difficulty;
    }

    public List<String> getShuffledChoices() {
        List<String> shuffledChoices = new ArrayList<>(choices);
        Collections.shuffle(shuffledChoices);
        correctIndex = shuffledChoices.indexOf(choices.get(correctIndex));
        return shuffledChoices;
    }

    public char getAnswer() {
        return (char)('A' + correctIndex);
    }
}