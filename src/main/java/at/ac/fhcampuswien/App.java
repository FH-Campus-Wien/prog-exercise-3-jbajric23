package at.ac.fhcampuswien;

import java.util.Random;
import java.util.Scanner;

public class App {

    // Implement all methods as public static
    // Methode 1 --> Loop bis 31 durchführen, if wenn i < 10
    // Modulo 7 für Zeilenumbruch nach Sonntag (2ter Count)
    public static void oneMonthCalendar(int numDay, int startDays) {
        int col,rows;
        col = 0;
        rows = 0;
        for (int i = 1; i <= 7; i++) {
            if (i == startDays) {
                for (int j = 1; j <= numDay; j++) {
                    if (j < 10) {
                        System.out.print(" " + j + " ");
                    } else {
                        System.out.print(j + " ");
                    }
                    col++;
                    if (col % 7 == 0) {
                        if (rows < 5) {
                            System.out.println("");
                        }
                        rows++;
                    }
                }
            } else if (col < startDays) {
                System.out.print("   ");
                col++;
            }
            if (numDay < 3) {
                System.out.print("");
            }
        }
        if (col%7 != 0) {
            System.out.println();
        }
    }

    // Aufgabe 2 -> Pseudo Random Numbers
    // if Loop definieren, Konstante variablen deklarieren -> Final

   public static long[] lcg(long seed) {
        long[] arrSeed = new long[10];
        long a,c,ml;
        double m;
        m = Math.pow(2, 31);
        a = 1103515245;
        c = 12345;
        ml = new Double(m).longValue();

        int i = 0;
        while (i<arrSeed.length) {
            if (i == 0) arrSeed[i] = (a*seed+c)%ml;
            else arrSeed[i] = (a*arrSeed[i-1]+c)%ml;
            i++;
        }
        return arrSeed;
   }

    // Aufgabe 3 -> guesingGame()
    // API für Random Zahlen verwenden -> Math.random() or nextInt()
    public static void guessingGame(int numToGuess) {
        Scanner scanner3 = new Scanner(System.in);
        for (int i = 1; i <= 10; i++) {
            System.out.print("Guess number " + i + ": ");
            int guess = scanner3.nextInt();
            if (i == 10) {
                System.out.print("You lost! Have you ever heard of divide & conquer?" + System.lineSeparator());
                break;
            }
            if (guess > numToGuess) {
                System.out.print("The number AI picked is lower than your guess." + System.lineSeparator());
                continue;
            } else if (guess < numToGuess) {
                System.out.print("The number AI picked is higher than your guess." + System.lineSeparator());
                continue;
            } else if (guess == numToGuess) {
                System.out.print("You won wisenheimer!" + System.lineSeparator());
                break;
            }
        }
    }

    public static int randomNumberBetweenOneAndHundred() {
        Random ran = new Random();
        int randomNum = ran.nextInt(100);
        boolean bool = true;
        return randomNum;
    }

    // Aufgabe 4 --> return false, wenn Array Längen nicht ident sind
    public static boolean swapArrays(int[] num1, int[] num2) {
        if (num1.length != num2.length) return false;
        else {
            int temp;
            for (int i = 0; i < num1.length; i++) {
                temp = num1[i];
                num1[i] = num2[i];
                num2[i] = temp;
            }
            return true;
        }
    }

    // Aufgabe 5 --> Am Schluss machen, da Schwirigstes
    // API toCharArray() verwenden! sonst keine API´s
    // Erstes Wort meist gesondert betrachten!
    // Buchstaben -> in Ascii Tabelle nachschauen
    // ((int)('a' - 'A'));
    // ### Z --> sop('z' - 32); ###
    public static String camelCase(String sentence) {
        boolean boolcc = true;
        char[] c1 = sentence.toCharArray();
        StringBuilder bd = new StringBuilder();
        for (int i=0;i<c1.length;i++) {
            if (c1[i] <= 'z' && c1[i] >= 'a') {
                if (boolcc != false){
                    c1[i] -= 32;
                    boolcc = false;
                }
                bd.append(c1[i]);
            } else if (c1[i] <= 'Z' && c1[i] >= 'A') {
                if (!boolcc) {
                    c1[i] += 32;
                }
                boolcc = false;
                bd.append(c1[i]);
            } else if (c1[i] == ' ') {
                boolcc = true;
            }
        }
        return bd.toString();
    }

    // Aufgabe 6 - Check Digit
    public static void main(String[] args) {
        // String[] args -> Strings, damit eine main() laufen kann
        /* Aufruf von args
        for (int i==0; a<args.length; i++) {
        System.out.println(args[i]);
        }*/
       /* int[] numbers41 = {4,3,2};
        int[] numbers42 = {6,8,10};
        boolean returnValue4  = swapArrays(numbers41, numbers42);
        if (!swapArrays(numbers41, numbers42)) {
            System.out.println("Error");
        } */
         App exercise3 = new App();

        System.out.println("Task 1: One Month Calender");
        exercise3.oneMonthCalendar(30,6);

        System.out.println("\nTask 2: Pseudo Random Numbers");
        exercise3.lcg(12345);

        System.out.println("\nTask 3: Guessing Game");
        int ranNum = exercise3.randomNumberBetweenOneAndHundred();
        exercise3.guessingGame(ranNum);


        System.out.println("\nTask 4: Swap Arrays");
        int[] arr1 = new int[]{100, 202, 30, 14, 15, 16};
        int[] arr2 = new int[]{1, 2, 3, 4, 5, 6};
        exercise3.swapArrays(arr1, arr2);

        System.out.println("\nTask 5: Camel Case");
        exercise3.camelCase("MyNameIsntAlice");

        System.out.println("\nTask 6: Check Digit");
        //exercise3.checkDigit();
    }
}
