import java.util.Scanner;

public class hw2_3 {

    public static boolean isPalindrome(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        return s.equals(reversed);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String ln = sc.next();
        if(isPalindrome(ln)){
            System.out.printf("Строка %s является палиндромом", ln);
        } else {
            System.out.printf("Строка %s не является палиндромом", ln);
        }
    }
}
