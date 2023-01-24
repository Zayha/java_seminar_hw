import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class hw2_1 {
    private static final Logger LOGGER = Logger.getLogger(hw2_1.class.getName());

    public static void main(String[] args) throws SecurityException, IOException {
        // конфигурация логгера
        FileHandler fileTxt = new FileHandler("bubblesort.log");
        SimpleFormatter formatterTxt = new SimpleFormatter();
        fileTxt.setFormatter(formatterTxt);
        LOGGER.addHandler(fileTxt);
        // logger

        int[] arr = {55, 2, 9, 1, 5, 6, 0};
        LOGGER.info("Incoming List: " + Arrays.toString(arr));
        List<Integer> sortedList = sort(arr);
        LOGGER.info("Sorted List: " + sortedList);
    }

    public static List<Integer> sort(int[] arr) {
        boolean swapped;
        int temp;
        List<Integer> sortedList = new ArrayList<Integer>();

        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                    LOGGER.info("Swapped: " + arr[j] + " and " + arr[j + 1]);
                }
            }
            if (!swapped)
                break;
        }
        for (int j : arr) {
            sortedList.add(j);
        }
        return sortedList;
    }
}
