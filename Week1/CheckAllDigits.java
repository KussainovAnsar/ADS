package Week1;
import java.util.Scanner;
public class CheckAllDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        if (areAllCharsDigits(s)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static boolean areAllCharsDigits(String str)
    {
        if (str.isEmpty())
        {
            return true;
        }
        if (Character.isDigit(str.charAt(0)))
        {
            return areAllCharsDigits(str.substring(1));
        }
        else
        {
            return false;
        }
    }
}
