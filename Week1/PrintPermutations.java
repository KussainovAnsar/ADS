package Week1;
import java.util.Scanner;
public class PrintPermutations
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        printPermutations("", s);
    }

    public static void printPermutations(String l, String r) {
        if (r.length() == 0) {
            System.out.println(l);
        }
        else
        {
            for (int i = 0; i < r.length(); i++)
            {
                String newl = l + r.charAt(i);
                String newr = r.substring(0, i) + r.substring(i + 1);
                printPermutations(newl, newr);
            }
        }
    }
}
