package Week1;

import java.util.Scanner;
public class FindMin {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for (int i = 0;i < n;i++)
        {
            arr[i] = scanner.nextInt();
        }

        System.out.println(findMin(arr,0,n-1));
    }

    public static int findMin(int[] arr, int start, int end) {
        if (start == end)
        {
            return arr[start];
        }
        else
        {
            int mid = (start + end) / 2;
            int left = findMin(arr, start, mid);
            int right = findMin(arr, mid + 1, end);
            return Math.min(left, right);
        }
    }
}


