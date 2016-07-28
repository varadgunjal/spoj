import java.util.*;
import java.lang.*;

public class ArithmeticSeq {
    public static Map<Integer, Integer> digitCount = new HashMap<Integer, Integer>();

    public static void countDigits(int n) {

        while (n > 0) {
            int digit = n % 10;

            if (!digitCount.containsKey(digit)) {
                digitCount.put(digit, 1);
            } else {
                int oldCount = digitCount.get(digit);
                digitCount.put(digit, oldCount + 1);
            }

            n = (int) n / 10;
        }
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int d = scanner.nextInt();
        int n = scanner.nextInt();
        int x = scanner.nextInt();


        // List<Integer> seq = new ArrayList<Integer>();

        for (int i = 0; i <= n; i++) {
            int s = a + (i * d);
            countDigits(s);
        }
        
        int xCount = digitCount.get(x);
        System.out.println(xCount);
    }
}
