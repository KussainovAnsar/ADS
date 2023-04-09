package Week1;
import java.util.Scanner;

public class CalculatingGCD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(findGCD(a, b));
    }

    public static int findGCD(int a, int b)
    {
        if (b == 0)
        {
            return a;
        }
        else if (a == 0) {
            return b;
        }
        else
        {
            return findGCD(b, a % b);
        }
    }
}
