package Week1;

import java.util.Scanner;

public class FindPower {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int n = scanner.nextInt();
        int result = FindPower(a,n);
        System.out.println(result);
    }

    public static int FindPower(int a, int n)
    {
        if (n == 0)
        {
            return 1;
        }
        else if (n < 0)
        {
            return 1 / FindPower(a, -(n));
        }
        else
        {
            int basePower = FindPower(a, n / 2);
            if (n % 2 == 0) {
                return basePower * basePower;
            } else
            {
                return basePower * basePower * a;
            }
        }
    }
}