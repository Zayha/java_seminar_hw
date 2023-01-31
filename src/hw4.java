import java.util.LinkedList;

import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

public class hw4 {
    public static void main(String[] args) {
//        Первая задача
        LinkedList<String> ls = new LinkedList<>();
        ls.add("1");
        ls.add("2");
        ls.add("3");
        System.out.println(ls);
        System.out.println(reverseLinlist(ls));
//        Вторая задача
        getconsolemeth(ls);
//        Третья задача
        someCalc();
    }

    public static LinkedList<String> reverseLinlist(LinkedList<String> list) {
        LinkedList<String> result = new LinkedList<>();
        for (String n :
                list) {
            result.addFirst(n);
        }
        return result;
    }

    public static String first(LinkedList<String> list) {
        return list.get(1);
    }

    public static LinkedList<String> dequeue(LinkedList<String> list) {
        if (list.size() < 2) {
            System.out.println("Элемент отсутствует");
        } else {
            System.out.println(list.get(1));
            list.remove(1);
        }
        return list;
    }

    public static LinkedList<String> enqueue(LinkedList<String> list, String element) {
        list.add(element);
        return list;
    }

    public static String parcenqueue(String str){
        String[] starr = str.split("\"");
        if(starr.length == 3){
            return starr[1];
        } else {
            return "";
        }
    }


    public static void getconsolemeth(LinkedList<String> list) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        LinkedList<String> res;


        System.out.println("Доступные команды: " +
                "\n enqueue() for.ex.: enqueue(\"356\")" +
                "\n dequeue()" +
                "\n first()" +
                "\n exit()");
        while (flag) {
            System.out.print("\nEnter command: ");
            String c = sc.next();

            if(Objects.equals(c, "exit()")){
                flag = false;
                }

            if(Objects.equals(c, "first()")){
                System.out.println(first(list));
            }

            if(Objects.equals(c, "dequeue()")){
                res = (LinkedList<String>) list.clone();
                list.clear();
                list.addAll(dequeue(res));
            }

            if(c.contains("enqueue")){
                res = (LinkedList<String>) list.clone();
                list.clear();
                list.addAll(enqueue(res, parcenqueue(c)));
            }
            System.out.println("List: " + list);
        }
    }

    public static double getTrueDouble(String num){
        double result = 0.0;
        boolean flag = true;
        try{
            result = Double.parseDouble(num);
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        if(!flag){
            if(num.contains(",")){
                num = num.replace(",", ".");
            } else {
                num = num.replace(".", ",");
            }
        result = Double.parseDouble(num);
        }
        return result;
    }

    public static void someCalc() {
        Scanner sc = new Scanner(System.in);
        double res;
        System.out.println("Доступные действия: +, -, *, /, отмена!");
        System.out.print("Введите число: ");
        res = getTrueDouble(sc.next());
        Stack<Double> result = new Stack<>();
        result.add(res);
        while (true) {
            System.out.printf("\nОтвет: %.2f", result.peek());
            System.out.print("\nДействие или \"отмена\", \"выход\": ");
            String act = sc.next();
            if(Objects.equals(act, "выход")){
                break;
            }
            if((Objects.equals(act, "отмена")) && !result.empty()){
                result.pop();
                if(result.empty()){
                    result.add(0.0);
                }
                continue;
            }
            System.out.print("Введите число: ");
//            double dig = sc.nextDouble();
            res = hw1.calculator(result.peek(), getTrueDouble(sc.next()), act);
            result.push(res);
            System.out.println(result);
            System.out.println(result.peek());
        }
    }
}
