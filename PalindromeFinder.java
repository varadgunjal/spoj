import java.util.Scanner;

/**
 * Created by varad on 7/28/16.
 * Returns next Palindrome number for arbitrarily long number
 */
public class Palin {

    private static char[] digitChars;
    private static int numSize = 0;

    public static void getDigits(String n) {
        int index = 0;
        digitChars = n.toCharArray();
        numSize = digitChars.length;
    }

    public static boolean isPalin() {
        for (int i = 0; i < ((int) numSize / 2); i++) {
            if (!(digitChars[i] == digitChars[numSize - i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void process() {
        if (isPalin()) {

            int indexToChange = (int) numSize / 2;
            char middleChar = digitChars[indexToChange];
            if (middleChar != '9') {
                int middleDigit = Character.getNumericValue(middleChar);
                middleDigit += 1;
                digitChars[indexToChange] = Character.forDigit(middleDigit, 10);
                if (numSize % 2 == 0) {
                    digitChars[numSize - indexToChange - 1] = Character.forDigit(middleDigit, 10);
                }

            } else {
                digitChars[indexToChange] = '0';
                if (numSize % 2 == 0) {
                    digitChars[numSize - indexToChange - 1] = '0';
                }

                if (numSize % 2 != 0) {
                    int index = indexToChange - 1;

                    while (index >= 0 && digitChars[index] == '9') {
                        digitChars[index] = '0';
                        digitChars[numSize - index - 1] = '0';
                        //                    System.out.println(new String(digitChars));
                        index -= 1;
                    }

                    if (index >= 0) {
                        int n1 = Character.getNumericValue(digitChars[index]) + 1;
                        digitChars[index] = Character.forDigit(n1, 10);
                        digitChars[numSize - index - 1] = Character.forDigit(n1, 10);
                    } else {
                        char[] newDigitChars = new char[numSize + 1];
                        newDigitChars[0] = '1';
                        System.arraycopy(digitChars, 0, newDigitChars, 1, numSize);
                        newDigitChars[newDigitChars.length - 1] = '1';
                        digitChars = newDigitChars;
                    }

                } else {
                    int index = indexToChange + 1;

                    while (index < numSize && digitChars[index] == '9') {
                        digitChars[index] = '0';
                        digitChars[numSize - index - 1] = '0';
                        //                    System.out.println(new String(digitChars));
                        index += 1;
                    }

                    if (index < numSize) {
                        int n1 = Character.getNumericValue(digitChars[index]) + 1;
                        digitChars[index] = Character.forDigit(n1, 10);
                        digitChars[numSize - index - 1] = Character.forDigit(n1, 10);
                    } else {
                        char[] newDigitChars = new char[numSize + 1];
                        newDigitChars[0] = '1';
                        System.arraycopy(digitChars, 0, newDigitChars, 1, numSize);
                        newDigitChars[newDigitChars.length - 1] = '1';
                        digitChars = newDigitChars;
                    }
                }


            }

        } else {        // INPUT NOT PALINDROME
            digitChars[numSize - 1] = digitChars[0];
            int middleIndex = (int) (numSize - 1) / 2;
            int index = 1;

            while (!isPalin()) {
                if (digitChars[index] > digitChars[numSize - index - 1]) {
                    digitChars[numSize - index - 1] = digitChars[index];
                } else {
                    int first = Character.getNumericValue(digitChars[index]);
                    int last = Character.getNumericValue(digitChars[numSize - index - 1]);
                    double avg = (first + last) / 2.0;
                    int newDigit = (int) Math.ceil(avg);

                    digitChars[index] = Character.forDigit(newDigit, 10);
                    digitChars[numSize - index - 1] = Character.forDigit(newDigit, 10);
                }
                index += 1;
            }
        }
    }

    public static void main (String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        int numCases = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < numCases; i++) {
            String num = scanner.nextLine();
            getDigits(num);
            process();

            String nextPalin = new String(digitChars);
            System.out.println(nextPalin);
        }
    }
}
