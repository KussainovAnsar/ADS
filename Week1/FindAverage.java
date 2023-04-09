package Week1;

import java.util.Scanner;
public class FindAverage {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for (int i = 0;i < n;i++)
        {
            arr[i] = scanner.nextInt();
        }

        System.out.println(findAverage(arr,n));
    }

    public static double findAverage(int[] arr, int n) {
        double sum = 0;

        for (int i = 0; i < n; i++)
            sum += arr[i];

        return (sum / n);
    }
}
