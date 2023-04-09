package Week1;

import java.util.Scanner;
public class FindPrime
{
    static int i = 2;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(findPrime(n));
    }

    public static String findPrime(int n) {

        if (n <= 1) {
            return "Composite";
        }

        if (n == i) {
            return "Prime";
        }

        if (n % i == 0)
        {
            return "Composite";
        }
        i++;
        return findPrime(n);

    }
}
