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
        long[] arr = new long[10];
        long a,c,ml;
        double m;
        m = Math.pow(2, 31);
        a = 1103515245;
        c = 12345;
        ml = new Double(m).longValue();

        int i = 0;
        while (i<arr.length) {
            if (i == 0) arr[i] = (a*seed+c)%ml;
            else arr[i] = (a*arr[i-1]+c)%ml;
            i++;
        }
        return arr;
   }

    // Aufgabe 3 -> guesingGame()
    // API für Random Zahlen verwenden -> Math.random() or nextInt()

    // Aufgabe 4 --> return false, wenn Array Längen nicht ident sind
    public static boolean swapArrays(int[] num1, int[] num2) {
        if (num1.length != num2.length) return false;
        return true;
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

        System.out.println("Task 1: Largest Number");
        exercise3.oneMonthCalendar(30,6);

        System.out.println("\nTask 2: Stairs");
        exercise3.lcg(12345);

        System.out.println("\nTask 3: Pyramide");
        // exercise3.guesingGame();

        System.out.println("\nTask 4: Raute");
        //exercise3.swapArrays();

        System.out.println("\nTask 5: Notendurchschnitt");
        exercise3.camelCase("MyNameIsntAlice");

        System.out.println("\nTask 6: Fröhliche Zahlen");
        //exercise3.checkDigit();
    }
}
