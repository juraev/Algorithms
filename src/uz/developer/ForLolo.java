package uz.developer;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import static uz.developer.K.n;

/**
 * Created by Hiro on 16/10/2017.
 */
public class ForLolo {

    public static void main(String[] args) {
        ArrayList<Question> questions = new ArrayList<>();
        Question question;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/Users/gitarist/Desktop/i.txt"));
            String line;
            String temp;
            int i = 0;
            line = reader.readLine();
            while (line != null) {
                if (line.startsWith("Вопрос No")) {
                    line = "";
                    temp = reader.readLine();
                    while (!temp.contains("Варианты ответа:")&&!temp.contains("1.")){
                        line = line + temp;
                        temp = reader.readLine();
                    }
                    question = new Question(line);
                    line = "";
                    if (temp.contains("Варианты ответа:"))
                        temp = reader.readLine();
//                    line = line + temp;
                    while (!temp.startsWith("2.")) {
                        line = line + temp;
                        temp = reader.readLine();
                    }
                    question.first = line.substring(3);
                    line = temp;
                    while (!(temp = reader.readLine()).contains("Правиль")) {
                        if (temp.startsWith("3.")) {
                            question.second = line.substring(3);
                            line = temp;
                            while (!(temp = reader.readLine()).startsWith("Правиль")) {
                                if (temp.startsWith("4.")) {
                                    question.third = line.substring(3);
                                    line = temp;
                                    while (!(temp = reader.readLine()).startsWith("Правиль")) {
                                        line = line + temp;
                                    }
                                    question.fourth = line.substring(3);
                                } else line = line + temp;
                                if (temp.contains("Правиль")) break;
                            }
                            if (question.third == null) {
                                question.third = line.substring(3);
                            }
                        } else line = line + temp;
                        if (temp.contains("Правиль")) break;
                    }
                    if (question.second == null) {
                        question.second = line.substring(3);
                    }
                    line = temp;
//                    System.out.println(temp);
                    try {
                        temp = reader.readLine();
                        if (temp.contains("http://")) {
                            reader.readLine();
                            temp = reader.readLine();
                        }
                        while (!temp.contains("Вопрос No")&&!temp.contains("Билет")) {
                            line = line + temp;
                            if (temp.startsWith("Билет")) reader.readLine();
                            temp = reader.readLine();
                        }
                    } catch (NullPointerException e) {
                        break;
                    } finally {
                        question.answer = line.substring(19);
                        line = temp;
                        questions.add(question);
                    }
                } else {
                    line = reader.readLine();
                }
            }
            Arrays.stream(questions.toArray()).forEach(System.out::print);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(questions.size());
    }
}
