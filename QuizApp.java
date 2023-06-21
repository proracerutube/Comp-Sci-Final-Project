import java.util.*;

// Is the main app
public class QuizApp {
    // Main method containing the questions and ways that they are asked
    public static void main(String[] args) {
        Question[] questions = {
            new Question("What planet is known as the 'Red Planet'?", 
                         new String[]{"Mercury", "Mars", "Jupiter", "Venus"}, 
                         1, "Easy"),
            new Question("Who wrote the 'Harry Potter' series?", 
                         new String[]{"J.K. Rowling", "Stephen King", "George R.R. Martin", "Agatha Christie"}, 
                         0, "Easy"),
            new Question("What is the world's largest ocean?", 
                         new String[]{"Atlantic Ocean", "Arctic Ocean", "Indian Ocean", "Pacific Ocean"}, 
                         3, "Easy"),
            new Question("What is the chemical symbol for gold?", 
                         new String[]{"G", "Go", "Au", "Ag"}, 
                         2, "Easy"),
            new Question("Which artist painted the Mona Lisa?", 
                         new String[]{"Vincent Van Gogh", "Leonardo da Vinci", "Pablo Picasso", "Claude Monet"}, 
                         1, "Easy"),
            new Question("What is the Pythagorean theorem?", 
                         new String[]{"a^2 + b^2 = c^2", "a^2 - b^2 = c^2", "a^2 * b^2 = c^2", "a^2 / b^2 = c^2"}, 
                         0, "Easy"),
            new Question("What's the smallest country in the world?", 
                         new String[]{"Vatican City", "Monaco", "Nauru", "San Marino"}, 
                         0, "Easy"),
            new Question("What's the square root of 256?", 
                         new String[]{"16", "32", "36", "12"}, 
                         0, "Easy"),
            new Question("What's the currency of India?", 
                         new String[]{"Rupiah", "Taka", "Rupee", "Yen"}, 
                         2, "Easy"),
            new Question("In Greek mythology, who is the god of the sea?", 
                         new String[]{"Zeus", "Hades", "Poseidon", "Ares"}, 
                         2, "Easy"),
            new Question("Who developed the theory of relativity?", 
                         new String[]{"Sir Isaac Newton", "Albert Einstein", "Galileo Galilei", "Nikola Tesla"}, 
                         1, "Medium"),
            new Question("What is the cube root of 27?", 
                         new String[]{"9", "3", "6", "4"}, 
                         1, "Medium"),
            new Question("What is the closest star to Earth besides the sun?", 
                         new String[]{"Alpha Centauri", "Betelgeuse", "Sirius", "Proxima Centauri"}, 
                         3, "Medium"),
            new Question("What is the scientific name of the process plants use to convert sunlight into food?", 
                         new String[]{"Respiration", "Osmosis", "Photosynthesis", "Transpiration"}, 
                         2, "Medium"),
            new Question("What is the world's largest island?", 
                         new String[]{"Australia", "Greenland", "New Guinea", "Madagascar"}, 
                         1, "Medium"),
            new Question("What food can never go bad?",
                         new String[]{"Canned tuna", "Honey", "Dark chocolate", "Peanut butter"},
                         1, "Medium"),
            new Question("What is the capital of Sweden?", 
                         new String[]{"Helsinki", "Oslo", "Copenhagen", "Stockholm"}, 
                         3, "Medium"),
            new Question("What is the lightest element on the periodic table?", 
                         new String[]{"Hydrogen", "Helium", "Lithium", "Beryllium"}, 
                         0, "Medium"),
            new Question("In what year did World War II end?", 
                         new String[]{"1942", "1945", "1950", "1948"}, 
                         1, "Medium"),
            new Question("In computing, what does CPU stand for?", 
                         new String[]{"Central Processing Unit", "Computer Processing Unit", "Central Performance Unit", "Central Processor Unit"}, 
                         0, "Medium"),
            new Question("Who was the first woman to win a Nobel Prize?", 
                         new String[]{"Marie Curie", "Rosalind Franklin", "Jane Goodall", "Margaret Thatcher"}, 
                         0, "Hard"),
            new Question("Who discovered penicillin?", 
                         new String[]{"Louis Pasteur", "Alexander Fleming", "Marie Curie", "Edward Jenner"}, 
                         1, "Hard"),
            new Question("Which Shakespeare play features the characters of Oberon and Titania?", 
                         new String[]{"Romeo and Juliet", "Hamlet", "Macbeth", "A Midsummer Night's Dream"}, 
                         3, "Hard"),
            new Question("What's the heaviest organ in the human body?", 
                         new String[]{"Heart", "Liver", "Lungs", "Brain"}, 
                         1, "Hard"),
            new Question("What is the name of the largest moon of Pluto?", 
                         new String[]{"Charon", "Nix", "Styx", "Hydra"}, 
                         0, "Hard"),
            new Question("In what year was the Magna Carta originally issued?", 
                         new String[]{"1066", "1492", "1215", "1776"}, 
                         2, "Hard"),
            new Question("What is the hexadecimal equivalent of the binary number 1010?", 
                         new String[]{"8", "A", "D", "E"}, 
                         1, "Hard"),
            new Question("In what modern-day country was the mathematician Pythagoras born?", 
                         new String[]{"Greece", "Egypt", "Italy", "Turkey"}, 
                         3, "Hard"),
            new Question("Which of these elements is a noble gas?", 
                         new String[]{"Hydrogen", "Oxygen", "Neon", "Nitrogen"}, 
                         2, "Hard"),
            new Question("Who was known as the 'Maid of Orleans'?", 
                         new String[]{"Joan of Arc", "Mary, Queen of Scots", "Cleopatra", "Marie Antoinette"}, 
                         0, "Hard"),
        };

        List<Question> easyQuestions = new ArrayList<>();
        List<Question> mediumQuestions = new ArrayList<>();
        List<Question> hardQuestions = new ArrayList<>();

        for(Question question : questions) {
            switch(question.getDifficulty()) {
                case "Easy":
                    easyQuestions.add(question);
                    break;
                case "Medium":
                    mediumQuestions.add(question);
                    break;
                case "Hard":
                    hardQuestions.add(question);
                    break;
            }
        }

        Collections.shuffle(easyQuestions);
        Collections.shuffle(mediumQuestions);
        Collections.shuffle(hardQuestions);

        Scanner scanner = new Scanner(System.in);

        System.out.println("How many questions would you like to answer?");
        int numQuestions = scanner.nextInt();
        scanner.nextLine();

        int score = 0;
        int currentDifficultyLevel = 0;
        List<Question> currentDifficultyQuestions = easyQuestions;

        for(int i = 0; i < numQuestions; i++) {
            if (easyQuestions.isEmpty() && mediumQuestions.isEmpty() && hardQuestions.isEmpty()) {
                System.out.println("There are no more questions. Ending the quiz now.");
                break;
            }

            while (currentDifficultyQuestions.isEmpty()) {
                if (currentDifficultyLevel > 0) {
                    currentDifficultyLevel--;
                    currentDifficultyQuestions = currentDifficultyLevel == 0 ? easyQuestions : mediumQuestions;
                }
                else if (!mediumQuestions.isEmpty()) {
                    currentDifficultyLevel++;
                    currentDifficultyQuestions = mediumQuestions;
                }
                else {
                    currentDifficultyLevel = 2;
                    currentDifficultyQuestions = hardQuestions;
                }
            }

            Question currentQuestion = currentDifficultyQuestions.remove(0);

            System.out.println(currentQuestion.getQuestion());
            List<String> choices = currentQuestion.getShuffledChoices();
            for(int j = 0; j < choices.size(); j++) {
                char option = (char)('A' + j);
                System.out.println(option + ": " + choices.get(j));
            }

            String userAnswer = scanner.nextLine().toUpperCase();
            if(userAnswer.charAt(0) == currentQuestion.getAnswer()) {
                System.out.println("Correct!");
                score += (currentDifficultyLevel + 1);
                if (currentDifficultyLevel < 2) {
                    currentDifficultyLevel++;
                    currentDifficultyQuestions = currentDifficultyLevel == 1 ? mediumQuestions : hardQuestions;
                }
            } else {
                System.out.println("Incorrect. The correct answer is " + currentQuestion.getAnswer() + ".");
                if (currentDifficultyLevel > 0) {
                    currentDifficultyLevel--;
                    currentDifficultyQuestions = currentDifficultyLevel == 0 ? easyQuestions : mediumQuestions;
                }
            }
        }

        System.out.println("Quiz complete. Your score is " + score + ".");
        scanner.close();
    }
}