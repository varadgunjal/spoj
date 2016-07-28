import java.util.*;
import java.lang.*;

public class PrimeGenerator {
	
	public static List<Integer> findPrimes(int start, int end) {
		List<Integer> primes = new ArrayList<Integer>();
		List<Integer> allPrimesToTest = new ArrayList<Integer>();
		

		for (int i = 1; i <= ((int) Math.round(Math.sqrt(end))); i++) {
			if (i == 1) {
				continue;
			}
			
			boolean isPrime = true;
			
			for (int j: allPrimesToTest) {
				if (j <= ((int) Math.round(Math.sqrt(i)))) {
					if (i % j == 0) {
						isPrime = false;
						break;
					}
				}
			}
			
			
			if (isPrime) {
				allPrimesToTest.add(i);
			}
			
		}
		
		for (int i = start; i <= end; i++) {
			if (i == 1) {
				continue;
			}
			
			boolean isPrime = true;
			for (int j: allPrimesToTest) {
				if (i % j == 0 && i != j) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				primes.add(i);
			}
		}
		
		return primes;
	}
	
	public static void main (String[] args) throws java.lang.Exception {

		Scanner scanner = new Scanner(System.in);
		int numCases = scanner.nextInt();
		
		for (int i = 0; i < numCases; i++) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			List<Integer> primes = findPrimes(start, end);
			
			for (int x: primes) {
				System.out.println(x);
			}

			System.out.println();
		}
	}
}
