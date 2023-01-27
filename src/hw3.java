import java.util.*;

public class hw3 {
    public static void main(String[] args) {
        selector();
    }

    public static void selector() {
        boolean flag = true;
        // Если передать в createListInt в качестве параметра 0, будет сгенерирован список из N чисел,
        // где N от 0 до 100. Или передать в качестве параметра необходимое число элементов списка, пример 12.
        List<Integer> lst = createListInt(10);
        Scanner sc = new Scanner(System.in);
        while (flag) {
            System.out.println("\n1. Первая задача: Пусть дан произвольный список целых чисел, удалить из него четные числа");
            System.out.println("2. Вторая задача: Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее ариф. из этого списка");
            System.out.println("3. Третья задача: 3)(Дополнительное) Реализовать алгоритм сортировки слиянием (Дополнительное)");
            System.out.println("*. Для выхода любой символ");
            System.out.print("Выберите номер задачи для запуска: ");
            if (sc.hasNextInt()) {
                int sw = sc.nextInt();

                switch (sw) {
                    case 1 -> {
                        System.out.print("Исходный список: ");
                        System.out.println(lst);
                        System.out.print("Список после удаления четных: ");
                        System.out.println(removeEvenNumbers(lst));
                    }
                    case 2 -> {
                        System.out.print("Исходный список: ");
                        System.out.println(lst);
                        HashMap<String, Double> res = getMinMaxMid(lst);
                        System.out.printf("Минимальное значение %.0f, максимальное значение %.0f, среднее значение %.2f\n", res.get("min"), res.get("max"), res.get("mid"));
                    }
                    case 3 -> {
                        int[] arr = lst.stream().mapToInt(i -> i).toArray();
                        System.out.println("Исходный список: ");
                        System.out.println(arrayToString(arr));
                        System.out.println("Отсортированный список: ");
                        System.out.println(arrayToString(mergeSort(arr)));
                    }
                    default -> {
                        flag = false;
                    }
                }
            } else {
                System.out.println("Номер задачи указан некорректно!");
                System.out.println("\nBye bye!");
                flag = false;
            }
        }
    }

    public static List<Integer> createListInt(int size) {
        Random random = new Random();
        if (size == 0) {
            size = random.nextInt(2, 100);
        }
        List<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            // Ограничил случайные числа от 0 до 1000, для упрощения восприятия, можно убрать 1000, будет от и до.
            list.add(random.nextInt(1000));
        }
        return list;
    }

    public static List<Integer> removeEvenNumbers(List<Integer> list) {
        list.removeIf(n -> n % 2 == 0);
        return list;
    }

    public static HashMap<String, Double> getMinMaxMid(List<Integer> list) {
        int min = list.get(0);
        int max = list.get(0);
        int sum = 0;
        int counter = list.size();
        HashMap<String, Double> result = new HashMap<>();

        for (int i : list
        ) {
            if (i < min) min = i;
            if (i > max) max = i;
            sum += i;
        }

        double mid = (double) sum / (double) counter;
        result.put("max", (double) max);
        result.put("min", (double) min);
        result.put("mid", mid);

        return result;
    }

    public static int[] mergeSort(int[] array) {
        if (array.length > 1) {
            int mid = array.length / 2;
            int[] left = Arrays.copyOfRange(array, 0, mid);
            int[] right = Arrays.copyOfRange(array, mid, array.length);

            left = mergeSort(left);
            right = mergeSort(right);

            return merge(left, right);
        }
        return array;
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[k] = left[i];
                i++;
            } else {
                result[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            result[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            result[k] = right[j];
            j++;
            k++;
        }
        return result;
    }

    private static String arrayToString(int[] array) {
        return Arrays.toString(array);
    }


}
