package Week1;

import java.util.Scanner;
public class FindFibonacci
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = FindFibonacci(n);
        System.out.println(result);
    }

    public static int FindFibonacci(int n) {
        if (n == 0 || n ==1)
        {
            return n;
        }
        else
        {
            return FindFibonacci(n - 1) + FindFibonacci(n - 2);
        }
    }
}
