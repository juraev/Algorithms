package uz.developer;

/**
 * Created by Hiro on 16/10/2017.
 */
public class Question {
    String question;
    String first;
    String second;
    String third;
    String fourth;
    String answer;
    public Question(String que) {
        question = que;
    }

    @Override
    public String toString() {
        return question + "\n" + first + "\n" + second + "\n" + third + "\n" + fourth + "\n" +  answer + "\n------------------------------------\n";
    }

}
