import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class hw2_2 {
    public static List<String> parseData(String filePath) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        String temp;
        List<String> result = new ArrayList<>();

        for (String line : lines) {
            temp = line;
            String[] t = temp.split(",");
            for (String ne : t) {
                String res = ne.split(":")[1].replace("\"", "").replace(" ", "");
                result.add(res);

            }

        }
//        System.out.println(result);
        List<String> out = new ArrayList<>();
        out.add("Студент ");
        out.add(" получил ");
        out.add(" по предмету ");
        List<String> out_res = new ArrayList<>();
        int counter = 0;
        for (String s : result) {
            sb.append(out.get(counter));
            sb.append(s);
            counter++;
            if (counter > 2) {
                counter = 0;
                out_res.add(sb.toString());
                sb.setLength(0);
            }
        }

        return out_res;
    }

    public static void main(String[] args) {
        List<String> lines = parseData("db.txt");
        for (String student : lines
        ) {
            System.out.println(student);
        }
    }
}

