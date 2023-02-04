import java.util.*;

public class hw5 {
    public static void main(String[] args) {
        //первое задание
        System.out.println(phonebook("Boris"));
        //второе задание
        List<String> db = Arrays.asList(
                "Иван Иванов",
                "Светлана Петрова",
                "Кристина Белова",
                "Анна Мусина",
                "Анна Крутова",
                "Иван Юрин",
                "Петр Лыков",
                "Павел Чернов",
                "Петр Чернышов",
                "Мария Федорова",
                "Марина Светлова",
                "Мария Савина",
                "Мария Рыкова",
                "Марина Лугова",
                "Анна Владимирова",
                "Иван Мечников",
                "Петр Петин",
                "Иван Ежов");
        System.out.println(getStat(db));

    }

    public static String phonebook(String name) {
        HashMap<String, LinkedList<Long>> db = new HashMap<>();
        LinkedList<Long> values = new LinkedList<>();
        values.add(9261772421L);
        values.add(4995477894L);
        db.put("Serj", values);
        values.clear();
        values.add(9152623354L);
        values.add(9035473541L);
        values.add(4955477412L);
        db.put("Boris", values);
        return db.get(name).toString();
    }

    public static LinkedHashMap<String, Integer> getStat(List<String> db) {
        HashMap<String, Integer> base = new HashMap<>();
        LinkedHashMap<String, Integer> nb = new LinkedHashMap<>();

        // собираем кол-во повторений имен
        for (String names :
                db) {
            // Отделяем имена от фамилий
            String name = names.split(" ")[0];
            if (base.containsKey(name)) {
                int c = base.get(name);
                base.replace(name, ++c);
            } else {
                base.put(name, 1);
            }
        }

        // сортировка с сокращением объекта Map на каждом цикле. формирование нового упорядоченнго об.LinkedHashMap
        do {
            int m = 0;
            String max_key = "";
            for (Map.Entry<String, Integer> entry : base.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                if (value > m) {
                    m = value;
                    max_key = key;
                }
            }
            nb.put(max_key, m);
            base.remove(max_key);
        } while (!base.isEmpty());
        return nb;
    }

}
