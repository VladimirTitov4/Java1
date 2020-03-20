/**
 * Java 1 Homework 3
 *
 * @author Vladimir Titov
 * @modified 18/03/20
 */

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        //task1();
        task2(getWords("words.txt"));
        //System.out.println(Arrays.toString(getWords("words.txt")));
    }

    public static void task1() {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        int x = rand.nextInt(10);

        for (int i = 1; i <= 3; i++) {
            System.out.println("Попробуйте угадать число от 0 до 9");
            int num = sc.nextInt();

            if (num == x) {
                System.out.println("Вы угадали!");
                break;
            } else if (num > x) {
                System.out.println("Вы ввели слишком большое число");
            } else {
                System.out.println("Вы ввели слишком малое число");
            }
            if (i == 3) System.out.println("3 попытки истекли");
        }

        System.out.println("Вы хотите сыграть ещё ? 1 - да, 0 - нет");
        int answer = sc.nextInt();
        if (answer == 1) task1();
    }

    public static int getLinesNumber(String fileName) {
        int lineNumber = 0;
        try {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            LineNumberReader lineNumberReader = new LineNumberReader(fileReader);

            while (lineNumberReader.readLine() != null) {
                lineNumber++;
            }

            lineNumberReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lineNumber;
    }

    public static String[] getWords(String providedFile) {
        String[] wordsArray = new String[getLinesNumber(providedFile)];
        try {
            FileReader file = new FileReader(providedFile);
            Scanner scan = new Scanner(file);

            int i = 0;

            while(scan.hasNextLine()) {
                wordsArray[i] = scan.nextLine();
                i++;
            }

            file.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return wordsArray;
    }

    public static void task2(String[] words) {

        Random rand = new Random();
        int x = rand.nextInt(words.length);
        String rightWord = words[x];

        boolean win = false;
        String blank = "###############";

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Попробуйте угадать фрукт ");
            String answer = sc.next();

            if (answer.equals(rightWord)) {
                System.out.println("Вы угадали");
                break;
            }

            System.out.println("Вы не угадали");
            char[] blankArray = blank.toCharArray();
            int len = 0;
            len = Math.min(answer.length(), rightWord.length());

            for (int i = 0; i < len; i++) {
                if (answer.charAt(i) == rightWord.charAt(i)) {
                    blankArray[i] = rightWord.charAt(i);
                }
            }
            System.out.println(blankArray);
        }
    }
}
