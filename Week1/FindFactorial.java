package Week1;

import java.util.Scanner;
public class FindFactorial
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = FindFactorial(n);
        System.out.println(result);
    }

    public static int FindFactorial(int n) {
        if (n <= 1) return 1;
        return FindFactorial(n-1)*n;
    }
}
