import java.util.*;
public class primeNumberSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to look up until: ");
        int n = sc.nextInt();
        SinglyLinkedList primes = new SinglyLinkedList();
        SinglyLinkedList primesWithThree = new SinglyLinkedList();

        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                primes.append(new Node(i));
                if (containsDigitThree(i)) {
                    primesWithThree.append(new Node(i));
                }
            }
        }

        int sum = 0;
        Node current = primesWithThree.getHead();
        while (current != null) {
            sum += current.data;
            current = current.next;
        }
        System.out.println("Sum of primes with digit 3: " + sum);
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n)/2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean containsDigitThree(int n) {
        while (n > 0) {
            int digit = n % 10;
            if (digit == 3) {
                return true;
            }
            n /= 10;
        }
        return false;
    }
}