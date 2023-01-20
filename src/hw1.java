import java.util.*;

public class hw1 {
    public static int triangularNumber(int n) {
        return n * (n + 1) / 2;
    }

    public static int factorialn(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static List<Integer> primeNumbers(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(2);
        if (n == 2) return result;
        for (int i = 3; i <= n; i++) {
            int c = 0;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    c += 1;
                    break;
                }

            }
            if (c == 0) result.add(i);

        }
        return result;
    }

    public static double calculator(double n1, double n2, String action) {
        double result = 0;
        if (Objects.equals(action, "-")) result = n1 - n2;
        if (Objects.equals(action, "+")) result = n1 + n2;
        if (Objects.equals(action, "/") && n2 != 0) result = n1 / n2;
        if (Objects.equals(action, "*")) result = n1 * n2;
        return result;

    }

    public static List<String> getNumbers(String input) {
        List<String> result = new ArrayList<>();
        if (Objects.equals(input, "?")) {
            for (int i = 0; i < 10; i++) {
                result.add(Integer.toString(i));
            }
            return result;
        }
        if (Objects.equals(input, "??")) {
            for (int i = 10; i < 100; i++) {
                result.add(Integer.toString(i));
            }
            return result;
        } else {
            char[] chars = input.toCharArray();
            for (int i = 0; i <= 9; i++) {
                result.add((chars[0] == '?' ? i + "" : chars[0] + "") + (chars[1] == '?' ? i : chars[1] + ""));
            }
        }
        return result;
    }


    public static String solutionOfEquation(String equations) {
        List<Integer> result = new ArrayList<>();
        String[] sp = equations.split(" ");
        List<String> x1 = new ArrayList<>();
        List<String> x2 = new ArrayList<>();
        if (sp[0].contains("?")) {
            x1 = getNumbers(sp[0]);
        } else {
            x1.add(sp[0]);
        }
        if (sp[2].contains("?")) {
            x2 = getNumbers(sp[2]);
        } else {
            x2.add(sp[2]);
        }
        for (int i = 0; i < x1.size(); i++) {
            for (int j = 0; j < x2.size(); j++) {
                if (Objects.equals(sp[1], "+")) {
                    if (Integer.parseInt(x1.get(i)) + Integer.parseInt(x2.get(j)) == Integer.parseInt(sp[4])) {
                        result.add(i);
                        result.add(j);
                        break;
                    }
                }
                if (Objects.equals(sp[1], "-")) {
                    if (Integer.parseInt(x1.get(i)) - Integer.parseInt(x2.get(j)) == Integer.parseInt(sp[4])) {
                        result.add(i);
                        result.add(j);
                        break;
                    }
                }
                if (result.size() > 1) break;
            }

        }
        if (result.size() >= 2) {
            sp[0] = sp[0].replace("??", "?").replace("?", Integer.toString(result.get(0)));
            sp[2] = sp[2].replace("??", "?").replace("?", Integer.toString(result.get(1)));
            String res = String.join(" ", sp);
            return res;
        } else {
            return "Решений нет";
        }

    }

    public static void main(String[] args) {
        int n = 5;

        System.out.printf("Треугольное число порядка %d = %d\n", n, triangularNumber(n));
        System.out.printf("Факториал %d! = %d\n", n, factorialn(n));

        n = 1000;

        System.out.printf("Ряд простых чисел до %d = ", n);
        System.out.print(primeNumbers(n));

//        Калькулятор
        Scanner cs = new Scanner(System.in);
        System.out.print("\nВведите число: ");
        double n1 = cs.nextDouble();
        System.out.print("\nУкажите действие + - / *: ");
        String action = cs.next();
        System.out.print("\nВведите второе число: ");
        double n2 = cs.nextDouble();
        System.out.printf("%.2f %s %.2f = %.2f", n1, action, n2, calculator(n1, n2, action));

//        Уравнение
        System.out.print("\nВведите уравнение вида ?5 + ? = 15 (вариант( Х - число): X?, ?X, ??, ?, XX): ");
        String equation = cs.nextLine();
        System.out.println(solutionOfEquation(equation));

    }
}
