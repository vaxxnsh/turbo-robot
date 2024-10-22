import java.util.Scanner;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the starting number of the range: ");
        int start = scanner.nextInt();

        System.out.print("Enter the ending number of the range: ");
        int end = scanner.nextInt();

        boolean[] prime = new boolean[end + 1];
        for (int i = 0; i <= end; i++) {
            prime[i] = true;
        }

        for (int p = 2; p * p <= end; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= end; i += p) {
                    prime[i] = false;
                }
            }
        }

        System.out.println("Prime numbers between " + start + " and " + end + ":");
        for (int i = Math.max(start, 2); i <= end; i++) {
            if (prime[i]) {
                System.out.print(i + " ");
            }
        }

        scanner.close();
    }
}
